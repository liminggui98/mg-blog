<#include "include/macros.ftl">
<!DOCTYPE html>
<html lang="zh">
<@header></@header>
<body>
<@prompt></@prompt>
<div class="article_box clearfix">
    <div class="left">
        <!--首页最新模板部分-->
        <div class="list_article_title clearfix">
            <h3>搜索内容</h3>
            <p>亲，您搜索的结果都在下面了哦！</p>
        </div>
        <div class="article_box_one">
            <ul class="index_article">
                <#list page.content as article>
                    <li class="clearfix article_list">
                        <a href="/article/${article.id}" class="article_list_img">
                            <img src="/img/article3.jpg">
                        </a>
                        <h3>${article.title}</h3>
                        <p>${article.description}</p>
                        <div class="article_list_link">
                        <span class="article_list_count">
                            <i class="see_count"></i>
                            查看次数:${article.viewCount}
                        </span>
                            <span class="article_list_like">
                            <i class="like_count"></i>
                            点赞次数:${article.pointCount}
                        </span>
                            <a href="/article/${article.id}">查看详细</a>
                        </div>
                    </li>
                </#list>
            </ul>
        </div>
        <div class="pagelist">
            <a href="#">首页</a>
            <a href="#">上一页</a>
            <a href="#" class="pagelist_active">1</a>
            <a href="#">2</a>
            <a href="#">下一页</a>
            <a href="#">尾页</a>
        </div>
    </div>
    <@right></@right>
</div>
<@footer></@footer>

</body>
</html>