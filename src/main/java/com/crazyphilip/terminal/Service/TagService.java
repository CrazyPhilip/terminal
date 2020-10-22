package com.crazyphilip.terminal.Service;

import com.crazyphilip.terminal.entity.Tag;
import com.crazyphilip.terminal.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<String> selectAllTags(){
        return tagMapper.selectAllTags();
    }

    public List<String> selectSimilarTags(String tag){
        return tagMapper.selectSimilarTags(tag);
    }

    public boolean checkTag(String tag){
        return tagMapper.checkTag(tag) > 0;
    }

    public int insertTag(String tag){
        return tagMapper.insertTag(tag);
    }
}
