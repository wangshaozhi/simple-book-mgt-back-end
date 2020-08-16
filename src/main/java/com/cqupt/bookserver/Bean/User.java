package com.cqupt.bookserver.Bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName: User
 * @Description: User用户实体类
 * @Author: wsz
 * @Date: 2020/3/27 14:25
 * @Version 1.0
 **/
@Data
public class User {

    private int id;

    private String username;

    private String password;

    private String salt;

    private String phone;

    private String name;

    private String email;

    private boolean enabled;

}
