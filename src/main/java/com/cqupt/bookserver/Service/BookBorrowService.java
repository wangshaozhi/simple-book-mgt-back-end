package com.cqupt.bookserver.Service;

import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookBorrow;
import com.cqupt.bookserver.Bean.BookBorrowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookBorrowService {

    List<BookBorrowInfo> getAllBookBorrowInfos(String username);

    int addBkBrwRecord(BookBorrow bookBorrow);

    int deleteBookRdByIsbn(String isbn);

    int returnBook(String isbn);
}
