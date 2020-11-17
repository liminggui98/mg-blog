
package org.mg.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.DataBaseModel;

import java.util.List;

/**
 * 功能描述
 *
 * @param <T> 数据实体类
 * @since 2020-05-29
 */
public interface BaseService<T extends DataBaseModel> {
    /**
     * 新增记录
     *
     * @param data 数据实体
     * @return 添加成功的数量
     */
    int add(T data);

    /**
     * 删除记录
     *
     * @param id 数据 id
     * @return 删除的数量
     */
    int delete(String id);

    /**
     * 批量删除
     *
     * @param ids id 集
     * @return 删除的数量
     */
    int batchDel(List<String> ids);

    /**
     * 更新数据
     *
     * @param data 数据实体
     * @return 更新的数量
     */
    int update(T data);

    /**
     * 查询指定 id 的数据
     *
     * @param id 数据 id
     * @return 实体数据
     */
    T query(String id);

    /**
     * 分页查询实体数据
     *
     * @param page 分页条件
     * @return 分页数据
     */
    Page<T> query(Page<T> page);
}
