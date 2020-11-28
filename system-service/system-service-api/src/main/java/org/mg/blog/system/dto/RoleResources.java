package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 角色资源
 */
@Data
@TableName("tbl_role_resource")
@EqualsAndHashCode(callSuper = false)
public class RoleResources extends DataBaseModel {
    private Long roleId;
    private Long resourceId;
}
