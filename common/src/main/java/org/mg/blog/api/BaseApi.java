
package org.mg.blog.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.resp.AddResp;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 基本 api
 *
 * @param <T> 数据实体类
 * @since 2020-05-29
 */
public interface BaseApi<T extends DataBaseModel> {
    /**
     * 添加数据
     *
     * @param data 数据
     * @return 添加数据响应
     */
    @PostMapping
    Result<AddResp> add(@RequestBody T data);

    /**
     * 删除数据
     *
     * @param id 数据 id
     * @return 删除数据响应
     */
    @DeleteMapping(value = "/{id}")
    Result<DeleteByIdResp> delete(@PathVariable(value = "id") String id);

    /**
     * 更新数据
     *
     * @param id 数据 id
     * @param data 数据
     * @return 更新数据响应
     */
    @PutMapping(value = "/{id}")
    Result<UpdateByIdResp> update(@PathVariable(value = "id") String id, @RequestBody T data);

    /**
     * 查询数据
     *
     * @param id 数据 id
     * @return 更新数据响应
     */
    @GetMapping(value = "/{id}")
    Result<T> query(@PathVariable(value = "id") String id);

    /**
     * 获取数据集
     *
     * @param page 查询数据条件
     * @return 数据集
     */
    @PostMapping(value = "/list")
    Result<Page<T>> query(@RequestBody Page<T> page);
}
