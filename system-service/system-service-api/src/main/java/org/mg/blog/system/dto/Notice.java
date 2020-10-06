package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 用户通知
 */
@Data
@TableName("tbl_notice")
@EqualsAndHashCode(callSuper = false)
public class Notice extends DataBaseModel {
    private Long userId;
    private String status;
    private String title;
    private String content;
}
