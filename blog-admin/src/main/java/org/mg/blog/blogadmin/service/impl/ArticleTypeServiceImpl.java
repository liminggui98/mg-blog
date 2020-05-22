package org.mg.blog.blogadmin.service.impl;

import org.mg.blog.blogadmin.service.ArticleTypeService;
import org.mg.blog.model.ArticleType;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ArticleTypeServiceImpl extends BaseServiceImpl<ArticleType> implements ArticleTypeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArticleType queryById(Integer id) {
        String querySql = "select id,name,create_time,update_time from tbl_article_type where id = ?";
        return jdbcTemplate.queryForObject(querySql, new ArticleTypeMapper(), id);
    }

    @Override
    public ArticleType queryByArticleId(Integer articleId) {
        return null;
    }

    private class ArticleTypeMapper implements RowMapper<ArticleType> {
        @Override
        public ArticleType mapRow(ResultSet resultSet, int i) throws SQLException {
            ArticleType articleType = new ArticleType();
            ResultSetUtils.handle(articleType, resultSet);
            return articleType;
        }
    }
}
