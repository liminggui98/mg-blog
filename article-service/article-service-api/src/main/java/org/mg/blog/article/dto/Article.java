package org.mg.blog.article.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.common.dto.DataBaseModel;

import java.util.List;

/**
 * 文章实体
 */
@Data
@TableName("tbl_article")
@EqualsAndHashCode(callSuper = false)
public class Article extends DataBaseModel {
    private String title;
    private String content; // 文章内容
    private String description; // 简介
    private int viewCount;// 查看次数
    private int pointCount;// 点赞次数
    private String coverImage; // 封面图片
    private String userId; // 用户id
}
