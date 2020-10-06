package org.mg.blog.article.endpoint;

import org.mg.blog.article.api.ArticleApi;
import org.mg.blog.article.dto.Article;
import org.mg.blog.article.service.ArticleService;
import org.mg.blog.endpoint.BaseEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleEndpoint extends BaseEndpoint<ArticleService, Article> implements ArticleApi {
}
