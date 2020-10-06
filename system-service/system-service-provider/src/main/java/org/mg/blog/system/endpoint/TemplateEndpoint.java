package org.mg.blog.system.endpoint;

import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.TemplateApi;
import org.mg.blog.system.dto.Template;
import org.mg.blog.system.service.TemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模板端点
 *
 * @since 2020-06-20
 */
@RestController
@RequestMapping(value = "/template")
public class TemplateEndpoint extends BaseEndpoint<TemplateService, Template> implements TemplateApi {
}
