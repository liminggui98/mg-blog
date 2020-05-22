package org.mg.blog.blogadmin.service;

import org.mg.blog.model.ArticleType;

public interface ArticleTypeService extends BaseService<ArticleType> {
    /**
     * 通过文章 id 查询文章类型
     *
     * @param articleId 文章id
     * @return 文章类型
     */
    ArticleType queryByArticleId(Integer articleId);
}
