
package org.mg.blog.dto;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本字段
 *
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataBaseModel implements Serializable {
    @TableId
    private String id;

    private Date createTime;

    private Date updateTime;
}
