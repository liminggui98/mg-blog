package org.mg.blog.website.controller;

import org.mg.blog.model.Article;
import org.mg.blog.model.Page;
import org.mg.blog.website.model.SearchForm;
import org.mg.blog.website.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String toSearch(Model model, SearchForm searchForm){
        Page<Article> page = articleService.queryByPage(new Page<>());
        model.addAttribute("page", page);
        return "search";
    }
}
