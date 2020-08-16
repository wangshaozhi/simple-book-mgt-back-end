package com.cqupt.bookserver.Bean;

import lombok.Data;

/**
 * @ClassName: Category
 * @Description: 图书种类实体表
 * @Author: wsz
 * @Date: 2020/3/31 19:45
 * @Version 1.0
 **/
@Data
public class Category {

    /**
     * id
     */
    private int id;

    /**
     * 种类名
     */
    private String name;


    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
