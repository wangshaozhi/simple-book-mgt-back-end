package com.cqupt.bookserver.Controller;


import com.cqupt.bookserver.Bean.BookBorrow;
import com.cqupt.bookserver.Bean.BookBorrowInfo;
import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.Bean.User;
import com.cqupt.bookserver.ServiceImpl.BookBorrowServiceImpl;
import com.cqupt.bookserver.Utils.dateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@CrossOrigin
public class BookBorrowController {

    @Autowired
    BookBorrowServiceImpl bookBorrowService;

    @PostMapping(value = "/api/getAllBookBorrowInfos")
    public Response<List<BookBorrowInfo>> getAllBookBorrowInfos(@RequestBody User user) {
        List<BookBorrowInfo> result = bookBorrowService.getAllBookBorrowInfos(user.getUsername());
        if (null != result) {
            return Response.success(result);
        } else {
            return Response.fail(null);
        }
    }

    @PostMapping(value = "/api/addBkBrwRecord")
    public Response<List<BookBorrow>> addBkBrwRecord(@RequestBody BookBorrow bookBorrow) throws ParseException {
        bookBorrow.setBorrowdate(dateUtils.getSystemTime());
        //归还日期为一个月之后
        bookBorrow.setReturndate(dateUtils.nextMonth());
        return bookBorrowService.addBkBrwRecord(bookBorrow) > 0 ? Response.success("添加成功！") : Response.fail("添加失败！");
    }

    @PostMapping(value = "/api/deleteBrwInfo")
    public Response<List<BookBorrow>> deleteBkBrwRecord(@RequestBody BookBorrow bookBorrow) {
        return bookBorrowService.deleteBookRdByIsbn(bookBorrow.getIsbn()) > 0 ? Response.success("归还成功！") :
                Response.fail("归还失败！");
    }

    @PostMapping(value = "/api/returnBook")
    public Response<List<BookBorrow>> returnBook(@RequestBody BookBorrow bookBorrow) {
        return bookBorrowService.returnBook(bookBorrow.getIsbn()) > 0 ? Response.success("归还成功！") :
                Response.fail("归还失败！");
    }

}
