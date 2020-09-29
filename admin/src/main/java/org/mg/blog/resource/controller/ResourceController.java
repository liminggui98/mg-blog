
package org.mg.blog.resource.controller;

import static org.mg.blog.resource.constants.Url.RESOURCE_URL;

import org.mg.blog.base.controller.BaseController;
import org.mg.blog.resource.service.ResourceService;
import org.mg.blog.system.dto.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述
 *
 * @since 2020-09-26
 */
@Controller
@RequestMapping(value = RESOURCE_URL)
public class ResourceController extends BaseController<ResourceService, Resource> {
}
