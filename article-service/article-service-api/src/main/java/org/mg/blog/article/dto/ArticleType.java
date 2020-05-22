package org.mg.blog.article.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.common.dto.DataBaseModel;

/**
 * 文章类型
 */
@Data
@TableName("tbl_article_type")
@EqualsAndHashCode(callSuper = false)
public class ArticleType extends DataBaseModel {
    private String typeName;
}
