package org.mg.blog.system.api;


import org.mg.blog.api.BaseApi;
import org.mg.blog.fallback.BaseApiFallBack;
import org.mg.blog.system.dto.UpdateRecord;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 更新记录
 */
@FeignClient(name = "system-service", contextId = "updateRecordApi", path = "/update/record", fallback = BaseApiFallBack.class)
public interface UpdateRecordApi extends BaseApi<UpdateRecord> {
}
