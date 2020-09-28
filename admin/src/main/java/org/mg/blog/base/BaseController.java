
package org.mg.blog.base;

import static org.mg.blog.base.BaseContants.DATA_TABLE_VIEW;
import static org.mg.blog.constants.CommonConst.TABLE_OPTION_FIELD;

import com.alibaba.fastjson.JSON;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 基础转发器
 *
 * @since 2020-09-26
 */
public class BaseController {

    /**
     * to 列表页
     *
     * @param tableMap 列表页用的参数
     * @return 列表页视图
     */
    public ModelAndView toList(Map<String, Object> tableMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(TABLE_OPTION_FIELD, JSON.toJSONString(tableMap));
        modelAndView.setViewName(DATA_TABLE_VIEW);
        return modelAndView;
    }


}
