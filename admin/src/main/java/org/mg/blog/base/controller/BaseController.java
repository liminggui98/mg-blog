
package org.mg.blog.base.controller;

import static org.mg.blog.base.constants.BaseContants.DATA_ADD_VIEW;
import static org.mg.blog.base.constants.BaseContants.DATA_DETAIL_VIEW;
import static org.mg.blog.base.constants.BaseContants.DATA_TABLE_VIEW;
import static org.mg.blog.constants.CommonConst.COLS_FIELD;
import static org.mg.blog.constants.CommonConst.TABLE_OPTION_FIELD;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.base.service.BaseService;
import org.mg.blog.dto.DataBaseModel;
import org.mg.blog.dto.Result;
import org.mg.blog.field.service.FieldService;
import org.mg.blog.resp.AddResp;
import org.mg.blog.resp.DeleteByIdResp;
import org.mg.blog.resp.UpdateByIdResp;
import org.mg.blog.system.dto.Field;
import org.mg.blog.utils.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * 基础转发器
 *
 * @param <E> 数据服务类
 * @param <T> 数据实体类
 * @since 2020-09-26
 */
public abstract class BaseController<T extends BaseService<E>, E extends DataBaseModel> {
    @Autowired
    protected T service;

    @Autowired
    protected FieldService fieldService;

    /**
     * to 增加视图数据页
     *
     * @return 视图
     */
    @GetMapping("/add")
    public ModelAndView toAdd() {
        return createView(DATA_ADD_VIEW);
    }

    /**
     * 添加对象
     *
     * @param obj 对象
     * @return 添加结果
     */
    @ResponseBody
    @PostMapping("/add")
    public Result<AddResp> add(E obj) {
        return service.add(obj);
    }

    /**
     * 删除数据实体
     *
     * @param id 数据实体 id
     * @return 删除结果
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public Result<DeleteByIdResp> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    /**
     * 批量删除
     *
     * @param ids id 集
     * @return 删除结果
     */
    @ResponseBody
    @DeleteMapping("/batchDel")
    public Result<DeleteByIdResp> batchDel(@RequestParam String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        return service.batchDel(idList);
    }

    /**
     * 修改数据实体
     *
     * @param id  数据实体 id
     * @param obj 数据实体
     * @return 修改结果
     */
    @ResponseBody
    @PutMapping("/{id}")
    public Result<UpdateByIdResp> update(@PathVariable("id") String id, E obj) {
        return service.update(obj);
    }

    /**
     * 查询数据实体
     *
     * @param id 实体 id
     * @return 查询实体展示界面
     */
    @GetMapping("/{id}")
    public ModelAndView query(@PathVariable("id") String id) {
        E obj = service.query(id);
        return createView(DATA_DETAIL_VIEW).addObject("data", obj);
    }

    /**
     * to 列表页
     *
     * @return 列表页视图
     */
    @GetMapping
    public ModelAndView toList() {
        Map<String, Object> tableMap = new HashMap<>(1);

        List<Field> fields = fieldService.queryByResourceId(null);
        tableMap.put(COLS_FIELD, FieldUtils.getFields(fields));

        ModelAndView view = createView(DATA_TABLE_VIEW);
        view.addObject(TABLE_OPTION_FIELD, JSON.toJSONString(tableMap));
        return view;
    }

    /**
     * 请求分页数据
     *
     * @param page 分页条件
     * @return 分页数据
     */
    @ResponseBody
    @PostMapping("/list")
    public Page<E> queryList(Page<E> page) {
        return service.query(page);
    }

    /**
     * 创建视图
     *
     * @param viewName 视图名
     * @return 视图实体
     */
    protected ModelAndView createView(String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    /**
     * 获取数据实体类名
     *
     * @return 数据实体类名
     */
    private String getDataClassName() {
        String signature = this.getClass().getGenericSuperclass().getTypeName();

        String temp = signature.substring(signature.indexOf("<") + 1);
        temp = temp.substring(0, temp.length() - 1);
        String[] classNames = temp.split(",");
        return classNames[1].trim();
    }
}
