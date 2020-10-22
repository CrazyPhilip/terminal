package com.crazyphilip.terminal.mapper;

import com.crazyphilip.terminal.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {

    List<String> selectAllTags();

    List<String> selectSimilarTags(String tag);

    int checkTag(String tag);

    int insertTag(String tag);
}
