package com.cqupt.bookserver.ServiceImpl;


import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookAndCategory;
import com.cqupt.bookserver.Bean.Category;
import com.cqupt.bookserver.Dao.BookMapper;
import com.cqupt.bookserver.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BookServiceImpl
 * @Description: BookServiceImpl层
 * @Author: wsz
 * @Date: 2020/3/30 21:37
 * @Version 1.0
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getBookByCid(int cid) {
        List<Book> result = bookMapper.getBookByCid(cid);
        return result;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBook();
    }

    @Override
    public int deleteBook(String isbn) {
        return bookMapper.deleteBookById(isbn);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int updateIsReturn(String isbn) {
        return bookMapper.updateIsReturn(isbn);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        if (null != bookMapper.getBookByIsbn(isbn)) {
            return bookMapper.getBookByIsbn(isbn);
        }
        return null;
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int updateIsBrw(String isbn) {
        return bookMapper.updateIsBrw(isbn);
    }

    @Override
    public List<BookAndCategory> getBookAndCategory() {
        List<BookAndCategory> result = bookMapper.getBookAndCategory();
        for (int i = 0; i < result.size(); i++) {
            BookAndCategory item = result.get(i);
            //将类别和名称赋给category对象
            item.setCategory(new Category(item.getCid(), item.getName()));
        }
        return result;
    }
}
