package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

import java.util.Date;

/**
 * 用户
 */
@Data
@TableName("tbl_user")
@EqualsAndHashCode(callSuper = false)
public class User extends DataBaseModel {
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String qq;
    private Date birthday;
    private Integer gender;
    private String avatar;
    private String userType;
    private String company;
    private String blog;
    private String location;
    private String source;
    private String uuid;
    private Integer privacy;
    private Integer notification;
    private Integer score;
    private Integer experience;
    private String regIp;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Integer loginCount;
    private String remark;
    private Integer status;
}
