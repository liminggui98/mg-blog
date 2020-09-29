
package org.mg.blog.base.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.api.BaseApi;
import org.mg.blog.base.service.BaseService;
import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.resp.AddResp;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * 功能描述
 *
 * @since 2020-09-28
 */
public abstract class BaseServiceImpl<T extends BaseApi<E>, E extends DataBaseModel> implements BaseService<E> {
    @Autowired
    protected T api;

    @Override
    public Page<E> query(Page<E> page) {
        Result<Page<E>> result = api.query(page);
        return Optional.of(result.getResult()).orElse(null);
    }

    @Override
    public String add(E e) {
        Result<AddResp> result = api.add(e);
        return Optional.of(result.getResult().getCount() + "").orElse("");
    }

    @Override
    public Result<DeleteByIdResp> delete(String id) {
        return api.delete(id);
    }

    @Override
    public E query(String id) {
        Result<E> result = api.query(id);
        return Optional.ofNullable(result.getResult()).orElse(null);
    }

    @Override
    public Result<UpdateByIdResp> update(E e) {
        return api.update(e.getId(), e);
    }
}
