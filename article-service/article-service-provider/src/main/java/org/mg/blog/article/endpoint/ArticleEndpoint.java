package org.mg.blog.article.endpoint;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mg.blog.article.api.ArticleApi;
import org.mg.blog.article.dto.Article;
import org.mg.blog.article.service.ArticleService;
import org.mg.blog.article.vo.resp.AddArticleResp;
import org.mg.blog.article.vo.resp.DeleteArticleResp;
import org.mg.blog.article.vo.resp.UpdateArticleResp;
import org.mg.blog.common.dto.Result;
import org.mg.blog.user.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleEndpoint implements ArticleApi {

    @Autowired
    private UserApi userApi;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ArticleService articleService;

    @Override
    public Result<AddArticleResp> add(Article article) {
        int count = articleService.add(article);

        AddArticleResp resp = new AddArticleResp();

        Result<AddArticleResp> result = new Result();
        result.setResult(resp);
        return result;
    }

    @Override
    public Result<DeleteArticleResp> deleteById(String id) {
        return null;
    }

    @Override
    public Result<UpdateArticleResp> update(String id) {
        return null;
    }

    @Override
    public Result<Article> queryById(String id) {
        Article article = articleService.queryById(id);

        Result<Article> result = new Result();
        result.setResult(article);
        return result;
    }

    @Override
    public Result<Page<Article>> query(Page<Article> page) {
        return null;
    }
}
