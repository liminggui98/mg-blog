package org.mg.blog.article.api;

import org.mg.blog.api.BaseApi;
import org.mg.blog.article.dto.Type;
import org.mg.blog.fallback.BaseApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "article-service", contextId = "type-api", path = "/type", fallback = BaseApiFallBack.class)
public interface TypeApi extends BaseApi<Type> {
}
