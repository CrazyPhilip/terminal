package com.crazyphilip.terminal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com.crazyphilip.terminal.mapper")
@SpringBootApplication
public class TerminalApplication{

    public static Map<String,String> Commands = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(TerminalApplication.class, args);
    }

}
