package org.mg.blog.article.endpoint;

import org.mg.blog.article.api.TypeApi;
import org.mg.blog.article.dto.Type;
import org.mg.blog.article.service.TypeService;
import org.mg.blog.endpoint.BaseEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeEndpoint extends BaseEndpoint<TypeService, Type> implements TypeApi {
}
