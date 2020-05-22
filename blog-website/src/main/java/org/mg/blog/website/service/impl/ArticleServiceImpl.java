package org.mg.blog.website.service.impl;

import org.mg.blog.website.mapper.ArticleMapper;
import org.mg.blog.website.service.ArticleService;
import org.mg.blog.model.Article;
import org.mg.blog.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article queryById(String id) {
        return articleMapper.queryById(id);
    }

    @Override
    public Integer queryCount() {
        return articleMapper.queryCount();
    }

    @Override
    public Page<Article> queryByPage(Page<Article> page) {
        List<Article> articles = articleMapper.queryByPage(page);
        page.setTotal(queryCount());
        page.setRows(articles);
        return page;
    }
}
