drop table if exists tbl_article;

create table tbl_article
(
    id          varchar(1024) primary key,
    title       varchar(1024) not null default '' comment '文章标题',
    content     varchar(1024) not null default '' comment '文章内容',
    description varchar(1024) not null default '' comment '文章描述|简介',
    view_count  int           not null default 0 comment ' 查看次数 ',
    point_count int           not null default 0 comment ' 点赞次数 ',
    cover_image varchar(128)  not null default '' comment ' 文章封面 ',
    create_time datetime          not null default current_timestamp comment ' 创建时间 ',
    update_time datetime          not null default current_timestamp comment ' 更新时间 ',
    user_id     varchar(1024) not null comment '用户id'
)

