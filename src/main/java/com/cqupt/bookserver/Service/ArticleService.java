package com.cqupt.bookserver.Service;

import com.cqupt.bookserver.Bean.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticleById(int id);

    int addArticle(Article article);
}
