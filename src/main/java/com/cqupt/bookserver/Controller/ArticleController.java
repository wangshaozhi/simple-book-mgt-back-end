package com.cqupt.bookserver.Controller;

import com.cqupt.bookserver.Bean.Article;
import com.cqupt.bookserver.Bean.Response;
import com.cqupt.bookserver.ServiceImpl.ArticleServiceImpl;
import com.cqupt.bookserver.Utils.dateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/api/getAllArticles")
    public Response<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        if (articles != null) {
            return Response.success(articles);
        } else {
            return Response.fail("get article fail");

        }
    }

    @GetMapping("/api/getArticleById")
    public Response<List<Article>> getArticleById(@RequestParam int id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return Response.success(article);
        } else {
            log.info("get  Article failed in getArticleById in line 48");
            return Response.fail("fail");

        }
    }

    @PostMapping("/api/addArticleInfo")
    public Response<List<Article>> addArticleInfo(@RequestBody Article article) throws ParseException {
        article.setArticle_date(dateUtils.getSystemTime());
        return articleService.addArticle(article) > 0 ? Response.success("添加成功！") : Response.fail("添加失败！");
    }
}
