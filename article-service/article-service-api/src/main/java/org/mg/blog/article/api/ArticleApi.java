package org.mg.blog.article.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.article.dto.Article;
import org.mg.blog.article.vo.resp.AddArticleResp;
import org.mg.blog.article.vo.resp.DeleteArticleResp;
import org.mg.blog.article.vo.resp.UpdateArticleResp;
import org.mg.blog.common.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 文章服务接口
 */
@FeignClient(value = "article-service-provider", path = "/article")
public interface ArticleApi {
    /**
     * 新增文章
     *
     * @param article 文章数据
     * @return 新增文章结果
     */
    @PutMapping
    Result<AddArticleResp> add(@RequestBody Article article);

    /**
     * 通过文章 id 删除文章数据
     *
     * @param id 文章 id
     * @return 删除文章结果
     */
    @DeleteMapping("/{id}")
    Result<DeleteArticleResp> deleteById(@PathVariable(value = "id") String id);

    /**
     * 根据文章 id 更新文章内容
     *
     * @param id 文章 id
     * @return 更新文章结果
     */
    @PutMapping("/{id}")
    Result<UpdateArticleResp> update(@PathVariable(value = "id") String id);

    /**
     * 通过文章 id 查询文章内容
     *
     * @param id 文章id
     * @return 文章内容
     */
    @GetMapping(value = "/{id}")
    Result<Article> queryById(@PathVariable(value = "id") String id);

    /**
     * 查询文章列表
     *
     * @param page 文章分页条件
     * @return 查询文章结果
     */
    @GetMapping("/list")
    Result<Page<Article>> query(@RequestBody Page<Article> page);
}
