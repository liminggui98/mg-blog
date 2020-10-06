
package org.mg.blog.system.endpoint;

import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.LinkApi;
import org.mg.blog.system.dto.Link;
import org.mg.blog.system.service.LinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * link endpoint
 *
 * @since 2020-09-28
 */
@RestController
@RequestMapping(value = "/link")
public class LinkEndpoint extends BaseEndpoint<LinkService, Link> implements LinkApi {
}
