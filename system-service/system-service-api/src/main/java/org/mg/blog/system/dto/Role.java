package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 角色
 */
@Data
@TableName("tbl_role")
@EqualsAndHashCode(callSuper = false)
public class Role extends DataBaseModel {
    private String name;
    private String description;
    private Boolean available;

    private transient Integer selected;
}
