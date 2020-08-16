package com.cqupt.bookserver.Controller;

import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookAndCategory;
import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.Bean.User;
import com.cqupt.bookserver.ServiceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: BookController
 * @Description: BookController类
 * @Author: wsz
 * @Date: 2020/3/30 21:40
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(value = "/api/getBooksByCid")
    public Response<List<Book>> getBookByCid(@RequestParam int cid) {
        List<Book> result = bookService.getBookByCid(cid);
        if (result != null) {
            return Response.success(result);
        }
        return Response.fail(result);
    }

    @GetMapping(value = "/api/getAllBooks")
    public Response<Set<BookAndCategory>> getAllBooks() {
        List<BookAndCategory> result = bookService.getBookAndCategory();
        if (result != null) {
            return Response.success(result);
        }
        return Response.fail(result);
    }

    @PostMapping(value = "/api/addBook")
    public Response<String> addBook(@RequestBody Book book) {
        if (bookService.addBook(book) > 0) {
            return Response.success("添加成功！");
        }
        return Response.fail("添加失败");
    }

    @PostMapping(value = "/api/deleteBook")
    public Response<String> deleteBook(@RequestBody Book book) {
        String isbn = book.getIsbn();
        if (bookService.deleteBook(isbn) > 0) {
            return Response.success("删除成功！");
        }
        return Response.fail("删除失败！");
    }

    @PostMapping(value = "/api/updateBook")
    public Response<String> updateBook(@RequestBody Book book) {
        if (bookService.updateBook(book) > 0) {
            return Response.success("更新成功！");
        }
        return Response.fail("更新失败！");
    }

    @PostMapping(value = "/api/updateIsBrw")
    public Response<String> updateIsBrw(@RequestBody Book book) {
        String isbn = book.getIsbn();
        return bookService.updateIsBrw(isbn) > 0 ? Response.success("更新成功！") : Response.fail("更新失败！");
    }

    @PostMapping(value = "/api/updateIsReturn")
    public Response<String> updateIsReturn(@RequestBody Book book) {
        String isbn = book.getIsbn();
        return bookService.updateIsReturn(isbn) > 0 ? Response.success("更新成功！") : Response.fail("更新失败！");
    }
}
