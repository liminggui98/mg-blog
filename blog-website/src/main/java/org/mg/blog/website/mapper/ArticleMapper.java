package org.mg.blog.website.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mg.blog.model.Article;
import org.mg.blog.model.Page;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 通过文章 id 查询文章
     *
     * @param id 文章 id
     * @return 分页对象
     */
    Article queryById(@Param(value = "id") String id);

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
     * @return 文章集
     */
    List<Article> queryByPage(Page<Article> page);
}
