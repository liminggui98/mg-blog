package org.mg.blog.system.endpoint;

import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.UpdateRecordApi;
import org.mg.blog.system.dto.UpdateRecord;
import org.mg.blog.system.service.UpdateRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 更新记录端点
 *
 * @since 2020-06-20
 */
@RestController
@RequestMapping(value = "/update/resource")
public class UpdateRecordEndpoint extends BaseEndpoint<UpdateRecordService, UpdateRecord> implements UpdateRecordApi {
}
