
package org.mg.blog.system.endpoint;

import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.NoticeApi;
import org.mg.blog.system.dto.Notice;
import org.mg.blog.system.service.NoticeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知端点
 *
 * @since 2020-06-16
 */
@RestController
@RequestMapping(value = "/notice")
public class NoticeEndpoint extends BaseEndpoint<NoticeService, Notice> implements NoticeApi {
}
