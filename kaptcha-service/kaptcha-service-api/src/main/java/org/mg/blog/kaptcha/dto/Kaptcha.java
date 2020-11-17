package org.mg.blog.kaptcha.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import org.mg.blog.dto.DataBaseModel;

@TableName("tbl_kaptcha")
public class Kaptcha extends DataBaseModel {
    private String value;
}
