package com.cqupt.bookserver.Dao;


import com.cqupt.bookserver.Bean.Article;
import com.cqupt.bookserver.Bean.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    @Select("select * from article_cmt")
    List<Article> getAllArticleInfos();

    @Select("select * from article_cmt where id=#{id}")
    Article getArticleById(@Param("id") int id);

    @Insert(value = "insert into article_cmt(article_title,article_content,article_date,article_author) " +
            "values(#{article.article_title},#{article.article_content}," +
            "#{article.article_date},#{article.article_author})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "article.id")
    int addArticle(@Param("article") Article article);
}
