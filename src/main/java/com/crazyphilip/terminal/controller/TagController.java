package com.crazyphilip.terminal.controller;

import com.crazyphilip.terminal.Service.TagService;
import com.crazyphilip.terminal.entity.Tag;
import com.crazyphilip.terminal.util.ReturnCode;
import com.crazyphilip.terminal.util.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Tag")
@CrossOrigin
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "GetAllTags")
    public ReturnVO getAllTags(){
        List<String> list = tagService.selectAllTags();
        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, String.valueOf(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "GetSimilarTags")
    public ReturnVO getSimilarTags(@RequestParam(value = "tag") String tag){
        List<String> list = tagService.selectSimilarTags(tag);

        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, String.valueOf(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "CheckTag")
    public ReturnVO checkTag(@RequestParam(value = "tag") String tag){
        try{
            boolean check = tagService.checkTag(tag);
            return new ReturnVO(ReturnCode.SUCCESS, check?"Tag已存在":"Tag不存在", check);
        }catch (Exception ex){
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "InsertTag")
    public ReturnVO insertTag(@RequestParam(value = "tag") String tag){
        //Tag t = new Tag();
        //t.setTag(tag);
        int count = tagService.insertTag(tag);
        if (count == 1){
            return new ReturnVO(ReturnCode.SUCCESS);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "DeleteTag")
    public ReturnVO deleteTag(@RequestParam(value = "tag") String tag){
        boolean b = tagService.deleteTag(tag);
        if (b){
            return new ReturnVO(ReturnCode.SUCCESS);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }
}
