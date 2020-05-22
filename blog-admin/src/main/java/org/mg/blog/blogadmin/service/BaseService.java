package org.mg.blog.blogadmin.service;

/**
 * 基础的服务
 *
 * @param <T> 针对的对象
 */
public interface BaseService<T> {
    /**
     * 通过id查询记录
     *
     * @param id id
     * @return T 对象
     */
    T queryById(Integer id);
}
