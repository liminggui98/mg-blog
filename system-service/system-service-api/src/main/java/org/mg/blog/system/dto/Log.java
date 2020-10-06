package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 日志
 */
@Data
@TableName("tbl_log")
@EqualsAndHashCode(callSuper = false)
public class Log extends DataBaseModel {
    private Long userId;
    private String logLevel;
    private String ip;
    private String content;
    private String params;
    private String type;
    private String ua;
    private String os;
    private String browser;
    private String spiderType;
    private String requestUrl;
    private String referer;
}
