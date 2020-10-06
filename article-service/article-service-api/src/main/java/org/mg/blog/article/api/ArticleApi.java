package org.mg.blog.article.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.article.dto.Article;
import org.mg.blog.fallback.BaseApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 文章服务接口
 */
@FeignClient(value = "article-service", contextId = "article-api", path = "/article", fallback = BaseApiFallBack.class)
public interface ArticleApi extends BaseApi<Article> {
}
