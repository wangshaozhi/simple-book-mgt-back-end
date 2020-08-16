package com.cqupt.bookserver.Bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookBorrowInfo {

    /**
     * 图书的ISBN号
     */
    private String isbn;

    /**
     * 图书的名称
     */
    private String bookName;


    /**
     * 图书的作者
     */
    private String bookAuthor;

    /**
     * 图书的结束日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrow_date;

    /**
     * 图书的归还日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date return_date;
}
