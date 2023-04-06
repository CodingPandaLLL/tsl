package com.cpl.tsl.bean;


import lombok.Data;

/**
 * @author: lll
 * @description: User
 * @Date : 2022/10/10
 */
@Data
public class User {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}