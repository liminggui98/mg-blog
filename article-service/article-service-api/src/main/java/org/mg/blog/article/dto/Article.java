package org.mg.blog.article.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

import java.util.List;

/**
 * 文章实体
 */
@Data
@TableName("tbl_article")
@EqualsAndHashCode(callSuper = false)
public class Article extends DataBaseModel {
    /**
     * 文章标题
     */
    private String title;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 状态 0：有效
     */
    private Boolean status;

    /**
     * 文章类型数据
     */

    private transient List<Type> types;

    /**
     * 文章关键词集
     */
    private transient List<String> keywords;
}
