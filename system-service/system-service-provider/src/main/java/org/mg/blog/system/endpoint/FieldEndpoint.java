
package org.mg.blog.system.endpoint;

import org.mg.blog.dto.Result;
import org.mg.blog.endpoint.BaseEndpoint;
import org.mg.blog.system.api.FieldApi;
import org.mg.blog.system.dto.Field;
import org.mg.blog.system.service.FieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * field 端点
 *
 * @since 2020-10-06
 */
@RestController
@RequestMapping(value = "/field")
public class FieldEndpoint extends BaseEndpoint<FieldService, Field> implements FieldApi {

    @Override
    public Result<List<Field>> queryByResourceId(String resourceId) {
        List<Field> fields = service.queryByResourceId(resourceId);

        Result<List<Field>> result = new Result<>();
        result.setResult(fields);
        return result;
    }
}
