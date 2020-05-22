package org.mg.blog.website.controller;

import org.mg.blog.website.service.ArticleService;
import org.mg.blog.controller.BaseController;
import org.mg.blog.model.Article;
import org.mg.blog.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.mg.blog.constants.BlogConstants.INDEX_TEMPLATE_NAME;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"/", "index"})
    public String index(Model model) {
        Page<Article> page = articleService.queryByPage(new Page<>());
        model.addAttribute("page",page);
        return INDEX_TEMPLATE_NAME;
    }
}
