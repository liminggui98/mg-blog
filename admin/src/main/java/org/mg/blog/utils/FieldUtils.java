
package org.mg.blog.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字段处理工具
 *
 * @since 2020-09-26
 */
public class FieldUtils {
    /**
     * 隐藏构造器
     */
    private FieldUtils() {
    }

    /**
     * 返回数据字段对应关系
     *
     * @param dataBaseModel 类对象
     * @return 字段对应关系
     */
    public static List<Map<String, Object>> getFields(Class dataBaseModel) {
        Field[] fields = dataBaseModel.getDeclaredFields();

        List<Map<String, Object>> fieldMaps = new ArrayList<>();
        for (Field field : fields) {
            if (Modifier.isTransient(field.getModifiers())) {
                continue;
            }

            Map<String, Object> fieldMap = new HashMap<>();
            fieldMap.put("field", field.getName());
            fieldMap.put("title", field.getName());
            fieldMaps.add(fieldMap);
        }
        return fieldMaps;
    }

    public static List<Map<String, Object>> getFields(String className) throws ClassNotFoundException {
        Class dataBaseModel = Class.forName(className);
        return getFields(dataBaseModel);
    }

    public static List<Map<String, Object>> getFields(List<org.mg.blog.system.dto.Field> fields) {
        List<Map<String, Object>> fieldMaps = new ArrayList<>();
        fields.stream().forEach(f -> {
            Map<String, Object> fieldMap = new HashMap<>();
            fieldMap.put("field", f.getName());
            fieldMap.put("title", f.getName());
            fieldMaps.add(fieldMap);
        });
        return fieldMaps;
    }
}
