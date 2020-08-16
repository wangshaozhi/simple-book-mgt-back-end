package com.cqupt.bookserver.Bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookBorrow {

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 图书isbn 图书的唯一标识
     */
    private String isbn;

    /**
     * 借书的时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrowdate;

    /**
     * 归还书的时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returndate;

    /**
     * 是否规范的标志 1 归还 0 还没有
     */
    private boolean isreturn;
}
