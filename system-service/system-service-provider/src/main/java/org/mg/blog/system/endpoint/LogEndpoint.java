
package org.mg.blog.system.endpoint;

import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.LogApi;
import org.mg.blog.system.dto.Log;
import org.mg.blog.system.service.LogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志端点
 *
 * @since 2020-06-16
 */
@RestController
@RequestMapping(value = "/log")
public class LogEndpoint extends BaseEndpoint<LogService, Log> implements LogApi {
}
