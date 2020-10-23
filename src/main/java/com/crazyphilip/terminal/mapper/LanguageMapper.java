package com.crazyphilip.terminal.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LanguageMapper {

    List<String> selectAllLanguages();

    List<String> selectSimilarLanguages(String lang);

    int checkLanguage(String lang);

    int insertLanguage(String lang);

    boolean deleteLanguage(String lang);
}
