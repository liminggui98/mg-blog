package org.mg.blog.system.api;


import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.Template;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 系统模板
 */
@FeignClient(name = "system-service", contextId = "templateApi", path = "/template", fallback = BaseApiFallBack.class)
public interface TemplateApi extends BaseApi<Template> {
}
