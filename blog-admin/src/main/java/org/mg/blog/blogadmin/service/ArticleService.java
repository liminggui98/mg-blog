package org.mg.blog.blogadmin.service;

import org.mg.blog.model.Article;
import org.mg.blog.model.Page;

/**
 * 文章服务接口
 */
public interface ArticleService {
    /**
     * 通过文章 id 查询文章内容
     *
     * @param id 文章id
     * @return 文章内容
     */
    Article queryById(String id);

    /**
     * 通过文章 id 删除文章
     *
     * @param id 文章id
     * @return 0：删除失败（文章不存在） 1：删除成功
     */
    int deleteById(String id);

    /**
     * 更新文章内容
     *
     * @param article 文章内容
     * @return 0：更新失败 1：更新成功
     */
    int update(Article article);

    /**
     * 查询文章的总记录数
     *
     * @return 总数
     */
    int queryTotalCount();

    /**
     * 通过分页条件查询文章
     *
     * @param page 分页条件
     * @return 分页内容
     */
    Page<Article> queryByPage(Page<Article> page);

    /**
     * 新增文章
     *
     * @param article 文章
     * @return 0: 新增失败 1：新增成功
     */
    int add(Article article);
}
