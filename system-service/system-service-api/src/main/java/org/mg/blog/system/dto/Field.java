
package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.mg.blog.dto.DataBaseModel;

/**
 * 功能描述
 *
 * @since 2020-10-06
 */
@Data
@TableName("tbl_field")
@EqualsAndHashCode(callSuper = false)
public class Field extends DataBaseModel {
    private String userId;

    private String resourceId;

    private String name;

    private String type;

    private long sort;
}
