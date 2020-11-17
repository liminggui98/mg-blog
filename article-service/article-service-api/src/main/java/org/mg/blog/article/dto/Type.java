package org.mg.blog.article.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

import java.util.List;

@Data
@TableName("tbl_type")
@EqualsAndHashCode(callSuper = false)
public class Type extends DataBaseModel {
    /**
     * 类型名
     */
    private String typeName;

    /**
     * 状态 0：有效
     */
    private Boolean status;

    /**
     * 父类型 id, 无父类型时为 0
     */
    private String parentId;

    /**
     * 创建用户的 id
     */
    private String createUserId;

    /**
     * 子类型
     */
    private transient List<Type> subTypes;
}
