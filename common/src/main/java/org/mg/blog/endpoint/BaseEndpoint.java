
package org.mg.blog.endpoint;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.api.BaseApi;
import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.resp.AddResp;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;
import org.mg.blog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基本端点
 *
 * @param <E> 服务实现类
 * @param <T> 数据实体类
 * @since 2020-05-29
 */
public abstract class BaseEndpoint<E extends BaseService<T>, T extends DataBaseModel> implements BaseApi<T> {

    @Autowired
    protected E service;

    @Override
    public Result<AddResp> add(T data) {
        int count = service.add(data);

        AddResp addResp = new AddResp();
        addResp.setCount(count);
        addResp.setDesc("添加成功");

        Result<AddResp> result = new Result<>();
        result.setResult(addResp);
        return result;
    }

    @Override
    public Result<DeleteByIdResp> delete(String id) {
        int count = service.delete(id);

        DeleteByIdResp deleteByIdResp = new DeleteByIdResp();
        deleteByIdResp.setCount(count);

        Result<DeleteByIdResp> result = new Result<>();
        result.setResult(deleteByIdResp);
        return result;
    }

    @Override
    public Result<DeleteByIdResp> batchDel(List<String> ids) {
        int count = service.batchDel(ids);

        DeleteByIdResp deleteByIdResp = new DeleteByIdResp();
        deleteByIdResp.setCount(count);

        Result<DeleteByIdResp> result = new Result<>();
        result.setResult(deleteByIdResp);
        return result;
    }

    @Override
    public Result<UpdateByIdResp> update(String id, T data) {
        int count = service.update(data);

        UpdateByIdResp updateByIdResp = new UpdateByIdResp();
        updateByIdResp.setCount(count);

        Result<UpdateByIdResp> result = new Result<>();
        result.setResult(updateByIdResp);
        return result;
    }

    @Override
    public Result<T> query(String id) {
        T object = service.query(id);

        Result<T> result = new Result<>();
        result.setResult(object);
        return result;
    }

    @Override
    public Result<Page<T>> query(Page<T> page) {
        Page<T> newPage = service.query(page);

        Result<Page<T>> result = new Result<>();
        result.setResult(newPage);
        return result;
    }

}
