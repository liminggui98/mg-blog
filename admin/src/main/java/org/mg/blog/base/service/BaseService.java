
package org.mg.blog.base.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;

/**
 * 基本服务
 *
 * @param <T> 实体类
 * @since 2020-09-28
 */
public interface BaseService<T extends DataBaseModel> {
    /**
     * 通过分页条件查询数据集
     *
     * @param page 分页条件
     * @return 数据集
     */
    Page<T> query(Page<T> page);

    /**
     * 增加实体数据
     *
     * @param e 实体数据
     * @return 实体 id
     */
    String add(T e);

    /**
     * 通过 id 删除指定实体
     *
     * @param id 实体 id
     * @return 删除的记录数
     */
    Result<DeleteByIdResp> delete(String id);

    /**
     * 通过 id 查询指定实体数据
     *
     * @param id 实体 id
     * @return 实体数据
     */
    T query(String id);

    /**
     * 更新指定实体数据
     *
     * @param e 实体数据
     * @return 更新的记录数
     */
    Result<UpdateByIdResp> update(T e);
}
