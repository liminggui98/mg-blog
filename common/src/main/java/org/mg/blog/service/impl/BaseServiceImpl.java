
package org.mg.blog.service.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;

/**
 * 基础服务实现
 *
 * @since 2020-05-29
 * @param <T> 实体类
 */
public class BaseServiceImpl<T extends DataBaseModel> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public int add(T data) {
        int count = mapper.insert(data);
        if (count > 0) {
            getCache(data).put(data.getClass().getSimpleName() + ":" + data.getId(), data);
        }
        return count;
    }

    @Override
    public int delete(String id) {
        int count = mapper.deleteById(id);
        if (count > 0) {
            T data = mapper.selectOne(new QueryWrapper<>());
            getCache(data).evictIfPresent(data.getClass().getSimpleName() + ":" + id);
        }
        return count;
    }

    @Override
    public int batchDel(List<String> ids) {
        return mapper.deleteBatchIds(ids);
    }

    @Override
    public int update(T data) {
        int count = mapper.updateById(data);
        if (count > 0) {
            getCache(data).put(data.getClass().getSimpleName() + ":" + data.getId(), data);
        }
        return count;
    }

    @Override
    public T query(String id) {
        T data = mapper.selectById(id);
        if (Objects.nonNull(data)) {
            getCache(data).put(data.getClass().getSimpleName() + ":" + data.getId(), data);
        }
        return data;
    }

    @Override
    public Page<T> query(Page<T> page) {
        return mapper.selectPage(page, new QueryWrapper<T>());
    }

    private Cache getCache(T t) {
        Class clazz = t.getClass();

        String cacheName = "";
        Annotation[] annotations = clazz.getAnnotations();
        if (!Objects.isNull(annotations)) {
            for (Annotation annotation : annotations) {
                if (annotation.getClass() == TableName.class) {
                    TableName tabAnnotation = (TableName) annotation;
                    cacheName = tabAnnotation.value();
                }
            }
        }
        if (StringUtils.isEmpty(cacheName)) {
            cacheName = clazz.getSimpleName();
        }
        return cacheManager.getCache(cacheName);
    }
}
