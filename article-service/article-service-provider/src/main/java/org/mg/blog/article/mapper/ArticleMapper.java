package org.mg.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.mg.blog.article.dto.Article;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
