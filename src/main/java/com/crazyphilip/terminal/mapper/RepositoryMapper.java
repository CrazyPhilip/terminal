package com.crazyphilip.terminal.mapper;

import com.crazyphilip.terminal.entity.Repository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepositoryMapper {

    List<Repository> selectRepositories(String lang);
}
