package com.cqupt.bookserver.Service;


import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookAndCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: BookService
 * @Description: BookService
 * @Author: wsz
 * @Date: 2020/3/30 21:37
 * @Version 1.0
 **/
public interface BookService {

    List<Book> getBookByCid(int cid);

    List<Book> getAllBooks();

    int deleteBook(String isbn);

    int addBook(Book book);

    int updateBook(Book book);

    List<BookAndCategory> getBookAndCategory();

    int updateIsBrw(String isbn);

    Book  getBookByIsbn( String isbn);

    int updateIsReturn(String isbn);
}
