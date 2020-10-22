package com.crazyphilip.terminal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private int id;

    private String uid;

    private String name;

    private String password;

    private int access;
}
