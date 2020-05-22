package org.mg.blog.user.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.common.dto.DataBaseModel;

/**
 * 功能描述
 *
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends DataBaseModel {
    private String name; // 角色名
}
