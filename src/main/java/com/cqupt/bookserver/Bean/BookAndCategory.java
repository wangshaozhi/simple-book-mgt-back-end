package com.cqupt.bookserver.Bean;

import lombok.Data;

/**
 * @ClassName: BookAndCategory
 * @Description: 图书和种类的总表
 * @Author: wsz
 * @Date: 2020/3/31 18:21
 * @Version 1.0
 **/
@Data
public class BookAndCategory {

    /**
     * 图书isbn
     */
    private String isbn;

    /**
     * 封面url
     */
    private String cover;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版日期
     */
    private String date;

    /**
     * 出版社
     */
    private String press;

    /**
     * 简介
     */
    private String abs;

    /**
     * 分类
     */
    private int cid;

    /**
     * 种类
     */
    private Category category;

    /**
     * 种类名称
     */
    private String name;

    /**
     * 图书是否被借走
     */
    private int isborrow;
}
