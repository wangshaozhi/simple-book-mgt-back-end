package com.cqupt.bookserver.Dao;


import com.cqupt.bookserver.Bean.Book;
import com.cqupt.bookserver.Bean.BookAndCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: BookMapper
 * @Description: Book管理Mapper
 * @Author: wsz
 * @Date: 2020/3/30 21:27
 * @Version 1.0
 **/
public interface BookMapper {

    @Select("select * from book where cid=#{cid} and isborrow = 0")
    List<Book> getBookByCid(@Param("cid") int cid);

    @Select("select * from book")
    List<Book> getAllBook();

    @Delete("delete from book where isbn=#{isbn}")
    int deleteBookById(@Param("isbn") String isbn);

    @Insert("insert into book(isbn,cover,title,author,date,press,abs,cid,isborrow) values(#{book.isbn},#{book.cover}," +
            "#{book.title},#{book.author},#{book.date},#{book.press},#{book.abs},#{book.cid},#{book.isborrow})")
    @Options(useGeneratedKeys = true, keyColumn = "isbn", keyProperty = "book.isbn")
    int addBook(@Param("book") Book book);

    @Update("update book set cover=#{cover},title=#{title},author=#{author},date=#{date},press=#{press},abs=#{abs}," +
            "cid=#{cid},isborrow=#{isborrow} where isbn=#{isbn}")
    int updateBook(Book book);

    @Select("select * from book,category where book.cid = category.id and isborrow = 0")
    List<BookAndCategory> getBookAndCategory();

    @Update("update book set isborrow= 1 where isbn=#{isbn}")
    int updateIsBrw(@Param("isbn") String isbn);

    @Select("select * from book where isbn=#{isbn}")
    Book getBookByIsbn(@Param("isbn") String isbn);

    @Update("update book set isborrow= 0 where isbn=#{isbn}")
    int updateIsReturn(@Param("isbn") String isbn);
}
