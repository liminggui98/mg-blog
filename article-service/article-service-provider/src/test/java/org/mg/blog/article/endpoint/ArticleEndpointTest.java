package org.mg.blog.article.endpoint;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mg.blog.article.BaseTest;
import org.mg.blog.article.dto.Article;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ArticleEndpointTest extends BaseTest {
    private MockMvc mockMvc;

    @Before
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleEndpoint()).build();
    }

    @Test
    void add() throws Exception {
        Article article = new Article();
        article.setTitle("标题");
        article.setContent("内容");
        article.setDescription("描述");
        article.setCoverImage("");

        RequestBuilder req = MockMvcRequestBuilders.post("/article").
                content(JSONUtils.toJSONString(article)).
                contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(req).andExpect(status().isOk());
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void queryById() {
    }

    @Test
    void queryCount() {
    }

    @Test
    void queryByPage() {
    }
}