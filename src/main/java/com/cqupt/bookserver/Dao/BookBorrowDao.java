package com.cqupt.bookserver.Dao;


import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookBorrow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBorrowDao {

    @Select(value = "select * from bookborrow where username=#{username} and isreturn = 0")
    List<BookBorrow> getBkBrwByUsername(String username);

    @Insert(value = "insert into bookborrow(username,isbn,borrowdate,returndate,isreturn) values(#{username},#{isbn}," +  "#{borrowdate},#{returndate},#{isreturn})")
    int addBkBrwRecord(BookBorrow bookBorrow);

    @Delete(value = "delete from bookborrow where isbn = #{isbn}")
    int deleteBookRdByIsbn(@Param("isbn") String isbn);

    @Update("update bookborrow set isreturn= true where isbn=#{isbn}")
    int returnBook(String isbn);
}
