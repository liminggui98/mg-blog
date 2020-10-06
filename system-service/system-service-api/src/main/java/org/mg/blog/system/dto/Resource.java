package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

import java.util.List;

/**
 * 资源
 */
@Data
@TableName("tbl_resource")
@EqualsAndHashCode(callSuper = false)
public class Resource extends DataBaseModel {
    private String name;
    private String type;
    private String url;
    private String permission;
    private Long parentId;
    private Integer sort;
    private Boolean external;
    private Boolean available;
    private String icon;

    private transient List<Resource> nodes;
}
