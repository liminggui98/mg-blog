package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.BaseService;
import org.mg.blog.blogadmin.service.TagService;
import org.mg.blog.model.ArticleTag;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TagServiceImpl extends BaseServiceImpl<ArticleTag> implements TagService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleTag> queryByArticleId(Integer articleId) {
        String querySql = "select tag.id as id,tag.name as name,tag.create_time as create_time,tag.update_time as update_time" +
                " from tbl_tags tag,tbl_article_tags article_tags " +
                "where tag.id = article_tags.tag_id and article_tags.article_id = ?";
        return jdbcTemplate.query(querySql, new ArticleTagMapper(), articleId);
    }

    @Override
    public ArticleTag queryById(Integer id) {
        return null;
    }

    private class ArticleTagMapper implements RowMapper<ArticleTag> {
        @Override
        public ArticleTag mapRow(ResultSet resultSet, int i) throws SQLException {
            ArticleTag tag = new ArticleTag();
            ResultSetUtils.handle(tag, resultSet);
            tag.setTagName(FieldUtils.getString(resultSet, "name"));
            return tag;
        }
    }
}
