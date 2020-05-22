<#include "include/macros.ftl">
<!DOCTYPE html>
<html lang="zh">
<@header></@header>
<body>
<@prompt></@prompt>
<div class="article_box clearfix">
    <div class="left">
        <div class="article_content_box clearfix">
            <div class="article_article_title">
                <h3>最新模板
                    <span>您当前的位置：<a href="/index">首页></a><a href="#">列表页></a><a href="#">内容页</a></span>
                </h3>
            </div>
            <h3 class="article_content_title">${article.title}</h3>
            <div class="article_author_count_box clearfix">
                <i class="article_author_img" title="张政"><img src="/img/self_touxiang.jpg"></i>
                <a class="article_author"></a>
                <p>发表时间：${article.createTime?date!}</p>
                <p>查看次数：${article.viewCount}</p>
                <p>点赞次数：${article.pointCount}</p>
                <p>评论次数：${article.pointCount}   </p>
            </div>
            <div class="article_info">
                <p><b>简介&nbsp;&nbsp;</b>${article.description}</p>
            </div>
            <div class="article_content">
                ${article.content}
            </div>
            <div class="article_end">
                <p>注：本文由：张政 作者：<a href="#">张政</a> 发表，其版权均为作者所有，如需转载请注明文章出处及作者。</p>
            </div>
            <div class="article_like_box">
                <a href="#">喜欢的话点个赞吧！</a>
            </div>
            <div class="article_prev_next_box">
                <a href="#">上一章：</a>
                <a href="#">下一章：</a>
            </div>
        </div>
        <div class="article_like_article">
            <div class="article_article_title">
                <h3>相关文章</h3>
            </div>
            <div class="article_like_list">
                <a href="#">相似文章相似文章相似文章相似文章相似文章</a>
            </div>
        </div>
        <div class="pinglun_box">
            <div class="article_article_title">
                <h3>文章评论</h3>
            </div>
        </div>
    </div>
    <@right></@right>
</div>
</body>
<@footer></@footer>
</html>