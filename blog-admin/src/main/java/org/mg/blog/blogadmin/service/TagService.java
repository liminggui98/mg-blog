package org.mg.blog.blogadmin.service;

import org.mg.blog.model.ArticleTag;

import java.util.List;

public interface TagService extends BaseService<ArticleTag> {
    /**
     * 通过文章 id 查询标签集
     *
     * @param articleId 文章 id
     * @return 标签集
     */
    List<ArticleTag> queryByArticleId(Integer articleId);
}
