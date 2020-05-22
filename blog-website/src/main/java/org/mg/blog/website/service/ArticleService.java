package org.mg.blog.website.service;

import org.mg.blog.model.Article;
import org.mg.blog.model.Page;

/**
 * 文章服务
 */
public interface ArticleService {
    /**
     * 通过文章 id 查询文章
     *
     * @param id 文章 id
     * @return 分页对象
     */
    Article queryById(String id);


    /**
     * 查询文章总数
     *
     * @return 文章总数
     */
    Integer queryCount();

    /**
     * 通过分页条件查询文章
     *
     * @param page 分页条件
     * @return 分页对象
     */
    Page<Article> queryByPage(Page<Article> page);
}
