package org.mg.blog.website.controller;

import org.mg.blog.model.Article;
import org.mg.blog.model.Page;
import org.mg.blog.website.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public String toList(Page<Article> page, Model model) {
        page = articleService.queryByPage(page);
        model.addAttribute("page", page);
        return "list";
    }

    @RequestMapping("/{id}")
    public String toArticle(@PathVariable String id, Model model) {
        Article article = articleService.queryById(id);
        model.addAttribute("article", article);
        return "article";
    }
}
