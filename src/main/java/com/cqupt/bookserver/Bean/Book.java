package com.cqupt.bookserver.Bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Book
 * @Description: book实体类
 * @Author: wsz
 * @Date: 2020/3/30 21:31
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
public class Book {

    /**
     * 书籍封面url
     */
    private String cover;

    /**
     * 书籍标题
     */
    private String title;

    /**
     * 书籍作者
     */
    private String author;

    /**
     * 书籍出版日期
     */
    private String date;

    /**
     * 书籍出版社
     */
    private String press;

    /**
     * 书籍简介
     */
    private String abs;

    /**
     * 书籍分类
     */
    private int cid;

    /**
     * 图书的isbn,每个图书的isbn唯一
     */
    private String isbn;

    /**
     * 该图书是否被借出了 0 没有 1 借出了
     */
    private int isborrow;

}
