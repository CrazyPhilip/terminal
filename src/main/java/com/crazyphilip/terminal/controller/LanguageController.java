package com.crazyphilip.terminal.controller;

import com.crazyphilip.terminal.Service.LanguageService;
import com.crazyphilip.terminal.util.ReturnCode;
import com.crazyphilip.terminal.util.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Language")
@CrossOrigin
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/GetAllLanguages")
    public ReturnVO getAllLanguages(){
        List<String> list = languageService.selectAllLanguages();
        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, String.valueOf(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "GetSimilarLanguages")
    public ReturnVO getSimilarLanguages(@RequestParam(value = "language") String language){
        List<String> list = languageService.selectSimilarLanguages(language);

        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, String.valueOf(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "CheckLanguage")
    public ReturnVO checkLanguage(@RequestParam(value = "language") String language){
        try{
            boolean check = languageService.checkLanguage(language);
            return new ReturnVO(ReturnCode.SUCCESS, check?"Language已存在":"Language不存在", check);
        }catch (Exception ex){
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "InsertLanguage")
    public ReturnVO insertLanguage(@RequestParam(value = "language") String language){
        int count = languageService.insertLanguage(language);
        if (count == 1){
            return new ReturnVO(ReturnCode.SUCCESS);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @GetMapping(value = "DeleteLanguage")
    public ReturnVO deleteLanguage(@RequestParam(value = "language") String language){
        boolean b = languageService.deleteLanguage(language);
        if (b){
            return new ReturnVO(ReturnCode.SUCCESS);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }
}
