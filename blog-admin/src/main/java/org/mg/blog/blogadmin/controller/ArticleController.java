package org.mg.blog.blogadmin.controller;

import org.mg.blog.blogadmin.service.ArticleService;
import org.mg.blog.entity.ResponseVO;
import org.mg.blog.model.Article;
import org.mg.blog.model.Page;
import org.mg.blog.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Article> list(Page<Article> page) {
        return articleService.queryByPage(page);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseVO add(Article article, Model model) {
        articleService.add(article);
        return ResultUtils.success("");
    }
}
