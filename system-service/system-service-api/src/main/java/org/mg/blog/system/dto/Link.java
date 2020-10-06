package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 功能描述
 *
 * @since 2020-06-16
 */
@Data
@TableName("tbl_link")
@EqualsAndHashCode(callSuper = false)
public class Link extends DataBaseModel {
    private String url;
    private String name;
    private String description;
    private String email;
    private String qq;
    private String favicon;
    private Boolean status;
    private Boolean homePageDisplay;
    private String remark;
    private String source;
}
