package com.cqupt.bookserver.ServiceImpl;


import com.cqupt.bookserver.Bean.Article;
import com.cqupt.bookserver.Dao.ArticleMapper;
import com.cqupt.bookserver.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public List<Article> getAllArticles() {
        if (articleMapper.getAllArticleInfos() != null) {
            return articleMapper.getAllArticleInfos();
        }
        return null;
    }

    @Override
    public Article getArticleById(int id) {
        if (articleMapper.getArticleById(id) != null) {
            return articleMapper.getArticleById(id);
        }
        return null;
    }
}
