package com.crazyphilip.terminal.Service;

import com.crazyphilip.terminal.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageMapper languageMapper;

    public List<String> selectAllLanguages(){
        return languageMapper.selectAllLanguages();
    }

    public List<String> selectSimilarLanguages(String lang){
        return languageMapper.selectSimilarLanguages(lang);
    }

    public boolean checkLanguage(String lang){
        return languageMapper.checkLanguage(lang) > 0;
    }

    public int insertLanguage(String lang){
        return languageMapper.insertLanguage(lang);
    }

    public boolean deleteLanguage(String lang){
        return languageMapper.deleteLanguage(lang);
    }
}
