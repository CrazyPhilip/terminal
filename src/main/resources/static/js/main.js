$(function() {

    var terminal = $('.terminal');
    var input = $('.input');
    var input_box = $('.input-box');

    terminal.on('click',()=>{
        input.focus();
    })

    input.on('keypress',function(e){
        if(e.keyCode === 13)
        {
            if ( input.val() === "clear")
            {
                terminal.children('pre').remove();
                input.val("");
            }else {
                print(input.val());
            }
        }
    })

    input.bind('input propertychange', function() {
        var $this = $(this);
        //console.log($this);
        var text_length = $this.val().length;//获取当前文本框的长度
        var current_width = parseInt(text_length) *16;//该16是改变前的宽度除以当前字符串的长度,算出每个字符的长度
        //console.log(current_width)
        $this.css("width",current_width+"px");
    });

    setInterval(()=>{
        if(input.is(":focus"))
        {
            ;
        }
        else
        {
            input.focus();
        }
    },1000)

    function print(cmd)
    {
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: "/command",
            data: cmd,
            datatype: 'string',
            cache: false,
            timeout: 600000,
            success: function(data){
                if (data === ""){
                    input_box.before('<pre class="output">' + cmd + '</pre>');
                }else {
                    input_box.before('<pre class="output">' + cmd + '</pre><pre class="output2">' + data + '</pre>');
                }
                input.val("");
            },
            error: function(e){
                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        })

        //内容保持在底部
        terminal.scrollTop(terminal[0].scrollHeight);
    }

})