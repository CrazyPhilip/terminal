package com.crazyphilip.terminal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Repository {

    private int id;

    private String title;

    private String description;

    private String createtime;

    private String url;

    private String lang;

    private String tags;
}
