package org.mg.blog.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本字段
 */
@Data
public class DataBaseModel implements Serializable {
    private Integer id;
    private Date createTime;
    private Date updateTime;
}
