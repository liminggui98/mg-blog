
package org.mg.blog.fallback;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.dto.Status;
import org.mg.blog.resp.AddResp;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;
import org.mg.blog.service.BaseService;

/**
 * 用于返回 BaseApi 断路信息
 *
 * @param <T> 数据实体类
 * @param <E> 服务实现类
 * @since 2020-05-29
 */
public class BaseApiFallBack<E extends BaseService<T>, T extends DataBaseModel> implements BaseApi<T> {

    @Override
    public Result<AddResp> add(T data) {
        return errorResult();
    }

    @Override
    public Result<DeleteByIdResp> delete(String id) {
        return errorResult();
    }

    @Override
    public Result<UpdateByIdResp> update(String id, T data) {
        return errorResult();
    }

    @Override
    public Result<T> query(String id) {
        return errorResult();
    }

    @Override
    public Result<Page<T>> query(Page<T> page) {
        return errorResult();
    }

    private Result errorResult() {
        Result result = new Result();
        result.setStatus(Status.INTERNAL_ERROR);
        return result;
    }
}
