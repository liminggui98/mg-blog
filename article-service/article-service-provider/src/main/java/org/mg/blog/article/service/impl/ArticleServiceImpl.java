package org.mg.blog.article.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.article.dto.Article;
import org.mg.blog.article.mapper.ArticleMapper;
import org.mg.blog.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int add(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public int deleteById(String id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public int update(String id, Article article) {
        return articleMapper.updateById(article);
    }

    @Override
    public Article queryById(String id) {
        return articleMapper.selectById(id);
    }

    @Override
    public Page<Article> queryByPage(Page<Article> page) {
        return articleMapper.selectPage(page, Wrappers.emptyWrapper());
    }
}
