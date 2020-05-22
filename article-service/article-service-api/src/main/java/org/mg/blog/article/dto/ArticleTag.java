package org.mg.blog.article.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.common.dto.DataBaseModel;

/**
 * 文章标签
 */
@Data
@TableName("tbl_article_tag")
@EqualsAndHashCode(callSuper = false)
public class ArticleTag extends DataBaseModel {
    private String tagName;
}
