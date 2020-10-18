package com.crazyphilip.terminal.mapper;

import com.crazyphilip.terminal.entity.WebLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    int insertLog(WebLog webLog);

    int countLog();
}
