package org.mg.blog.article.vo.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新增文章响应信息
 *
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddArticleResp{
    private Long updateRecordNum;
}
