package com.cqupt.bookserver.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Article {

    /**
     * 文章id
     */
    private int id;

    /**
     * 文章标题
     */
    private String article_title;

    /**
     * 文章简介
     */
    private String article_content;

    /**
     * 文章编写日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date article_date;

    /**
     * 文章作者
     */
    private String article_author;

}
