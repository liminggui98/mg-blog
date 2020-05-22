package org.mg.blog.user.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.common.dto.DataBaseModel;

import java.util.Date;

/**
 * 用户实体类
 *
 * @since 2020-05-21
 */
@Data
@TableName("tbl_user")
@EqualsAndHashCode(callSuper = false)
public class User extends DataBaseModel {
    private String userName; // 用户名
    private String pass; // 密码
    private String firstName; // 名
    private String lastName; // 姓
    private String profilePhoto; // 头像路径
    private Date lastLoginTime; // 上次登录时间
    private String lastLoginIp; // 上次登录时间
}
