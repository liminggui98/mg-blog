<#include "include/macros.ftl">
<!DOCTYPE html>
<html lang="zh">
<@header></@header>
<body>
<@prompt></@prompt>
<div class="article_box clearfix">
    <div class="left">
        <!--首页博文推荐部分-->
        <div class="article_box_one">
            <div class="index_article_title clearfix">
                <h3>推荐博文</h3>
                <a href="/article/list">更多></a>
            </div>
            <ul class="index_article">
                <#list page.rows as article>
                    <li class="clearfix article_list">
                        <a href="/article/${article.id}" class="article_list_img">
                            <img src="img/article3.jpg">
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
        <div>
            <input type="button" class="more" id="load_more" value="点击加载更多">
        </div>
    </div>
    <@right></@right>
</div>
<@footer></@footer>
<script>
    $(function () {
        var i = 2; //设置当前页数
        $('#load_more').click(function () {
            $.ajax({
                url: '', // 这是当前服务器的地址
                type: 'POST',
                data: {
                    "next": i,
                    'table': 'news',
                    'classid': '9',
                    'action': 'getmorenews',
                    'limit': 6,
                    'small_length': 120
                },
                dataType: 'html',
                beforeSend: function () {
                    $("#load_more").attr('value', '正在努力加载中...');
                    $('#load_more').attr('disabled', 'disabled');
                },
                success: function (data) {
                    if (data.length > 10) {
                        $("#showajaxnews").append(data);
                        $("#load_more").removeAttr('disabled');
                        $("#load_more").attr('value', '点击加载更多!');
                        i++;
                    } else {
                        $("#load_more").show().html("已全部加载完毕！");
                        $('#load_more').attr('disabled', 'disabled');
                        return false;
                    }
                }
            });
        });
    });
</script>
</body>
</html>