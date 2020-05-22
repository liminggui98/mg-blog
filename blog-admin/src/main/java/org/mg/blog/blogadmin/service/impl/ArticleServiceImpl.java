package org.mg.blog.blogadmin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.mg.blog.blogadmin.service.ArticleService;
import org.mg.blog.blogadmin.service.ArticleTypeService;
import org.mg.blog.blogadmin.service.TagService;
import org.mg.blog.model.Article;
import org.mg.blog.model.ArticleTag;
import org.mg.blog.model.ArticleType;
import org.mg.blog.model.Page;
import org.mg.blog.utils.FieldUtils;
import org.mg.blog.utils.ResultSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 文章服务实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private static final String QUERY_SQL = "select * from tbl_article where id = ?";
    private static final String DELETE_SQL = "delete from tbl_article where id = ?";
    private static final String COUNT_SQL = "select count(*) from tbl_article";
    private static final String QUERY_PAGE_SQL = "select * from tbl_article limit ?,?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private TagService tagService;

    @Override
    public Article queryById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return jdbcTemplate.queryForObject(QUERY_SQL, Article.class);
    }

    @Override
    public int deleteById(String id) {
        if (StringUtils.isEmpty(id)) {
            return 0;
        }
        return jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public int update(Article article) {
        return 0;
    }

    @Override
    public int queryTotalCount() {
        return jdbcTemplate.queryForObject(COUNT_SQL, Integer.class);
    }

    @Override
    public Page<Article> queryByPage(Page<Article> page) {
        if (ObjectUtils.isEmpty(page)) {
            return page;
        }
        int pageCount = page.getPageCount();
        int pageNum = page.getPageNum();
        int begin = (pageNum - 1) * pageCount;
        int end = pageNum * pageCount;

        List<Article> articles = jdbcTemplate.query(QUERY_PAGE_SQL, new ArticleMapper(), begin, end);
        page.setRows(articles);
        page.setTotal(queryTotalCount());
        return page;
    }

    @Override
    public int add(Article article) {
        String insertSQL = "insert into tbl_article(title,content,description) values(?,?,?)";
        return jdbcTemplate.update(insertSQL, article.getTitle(), article.getContent(), article.getDescription());
    }

    private class ArticleMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet resultSet, int i) throws SQLException {
            Article article = new Article();
            ResultSetUtils.handle(article, resultSet);
            article.setTitle(FieldUtils.getString(resultSet, "title"));
            article.setContent(FieldUtils.getString(resultSet, "content"));
            article.setDescription(FieldUtils.getString(resultSet, "description"));
            article.setViewCount(resultSet.getInt("view_count"));
            article.setPointCount(resultSet.getInt("point_count"));
            article.setCoverImage(FieldUtils.getString(resultSet, "cover_image"));

            int typeId = resultSet.getInt("type_id");
            if (typeId > 0) {
                ArticleType articleType = articleTypeService.queryById(typeId);
                article.setType(articleType);
            }
            List<ArticleTag> tags = tagService.queryByArticleId(article.getId());
            article.setTags(new ArrayList<>(tags));
            return article;
        }
    }
}
