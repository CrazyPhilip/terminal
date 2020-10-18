package com.crazyphilip.terminal.Service;

import com.crazyphilip.terminal.entity.WebLog;
import com.crazyphilip.terminal.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    @Autowired(required = false)
    private LogMapper logMapper;

    @Transactional(rollbackFor = Exception.class)
    public int insertLog(WebLog webLog){
        return logMapper.insertLog(webLog);
    }

    public int countLog(){
        return logMapper.countLog();
    }
}
