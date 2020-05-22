package org.mg.blog.file.endpoint;

import org.mg.blog.article.api.ArticleService;
import org.mg.blog.model.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/article")
public class FileServiceEndpoint {
    @Resource
    private ArticleService articleService;

    @GetMapping(value = "/{id}")
    public Article queryById(@PathVariable(value = "id") String id) {
        return articleService.queryById(id);
    }

}
