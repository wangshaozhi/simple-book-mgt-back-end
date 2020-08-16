package com.cqupt.bookserver.ServiceImpl;


import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookBorrow;
import com.cqupt.bookserver.Bean.BookBorrowInfo;
import com.cqupt.bookserver.Dao.BookBorrowDao;
import com.cqupt.bookserver.Service.BookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    BookBorrowDao bkBrwDao;

    @Autowired
    BookServiceImpl bookService;

    @Override
    public int addBkBrwRecord(BookBorrow bookBorrow) {
        return bkBrwDao.addBkBrwRecord(bookBorrow);
    }

    @Override
    public int returnBook(String isbn) {
        return bkBrwDao.returnBook(isbn);
    }

    @Override
    public int deleteBookRdByIsbn(String isbn) {
        return bkBrwDao.deleteBookRdByIsbn(isbn);
    }

    @Override
    public List<BookBorrowInfo> getAllBookBorrowInfos(String username) {
        //根据用户名查找所有的借书记录
        List<BookBorrow> bookBorrows = bkBrwDao.getBkBrwByUsername(username);
        //展示给前端的图书借阅信息
        List<BookBorrowInfo> bkBrwInfos = new ArrayList<>();
        if (null != bkBrwDao.getBkBrwByUsername(username)) {
            for (BookBorrow item : bookBorrows) {
                //图书借阅信息实体类
                BookBorrowInfo bkBrwInfo = new BookBorrowInfo();
                //借阅图书信息实体类
                Book book = new Book();
                bkBrwInfo.setIsbn(item.getIsbn());
                bkBrwInfo.setBorrow_date(item.getBorrowdate());
                bkBrwInfo.setReturn_date(item.getReturndate());
                book = bookService.getBookByIsbn(item.getIsbn());
                if (null != book) {
                    //根据isbn获取图书信息
                    bkBrwInfo.setBookName(book.getTitle());
                    bkBrwInfo.setBookAuthor(book.getAuthor());
                }
                bkBrwInfos.add(bkBrwInfo);
            }
        }
        if (null != bkBrwInfos) {
            return bkBrwInfos;
        }
        return null;
    }
}
