-- ----------------------------
-- Table structure for tbl_config
-- ----------------------------
DROP TABLE IF EXISTS `tbl_config`;
CREATE TABLE `tbl_config`
(
    `id`           int(20) UNSIGNED                                       NOT NULL AUTO_INCREMENT,
    `config_key`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置关键字',
    `config_value` text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL COMMENT '配置项内容',
    `create_time`  datetime(0)                                            NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`  datetime(0)                                            NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_link
-- ----------------------------
DROP TABLE IF EXISTS `tbl_link`;
CREATE TABLE `tbl_link`
(
    `id`                bigint(20) UNSIGNED                                                   NOT NULL AUTO_INCREMENT,
    `url`               varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci               NOT NULL COMMENT '链接地址',
    `name`              varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci                NULL DEFAULT NULL COMMENT '链接名',
    `description`       varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci               NULL DEFAULT NULL COMMENT '链接介绍',
    `email`             varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci               NULL DEFAULT NULL COMMENT '友链站长邮箱',
    `qq`                varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci                NULL DEFAULT NULL COMMENT '友链站长QQ',
    `favicon`           varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci               NULL DEFAULT NULL,
    `status`            tinyint(1) UNSIGNED                                                   NULL DEFAULT 1 COMMENT '状态',
    `home_page_display` tinyint(1) UNSIGNED                                                   NULL DEFAULT 1 COMMENT '是否首页显示',
    `remark`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci               NULL DEFAULT NULL COMMENT '备注',
    `source`            enum ('ADMIN','AUTOMATIC') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'ADMIN' COMMENT '来源：管理员添加、自动申请',
    `create_time`       datetime(0)                                                           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`       datetime(0)                                                           NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_log
-- ----------------------------
DROP TABLE IF EXISTS `tbl_log`;
CREATE TABLE `tbl_log`
(
    `id`          bigint(20) UNSIGNED                                                        NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) UNSIGNED                                                        NULL     DEFAULT NULL COMMENT '已登录用户ID',
    `type`        enum ('SYSTEM','VISIT','ERROR') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'SYSTEM' COMMENT '日志类型（系统操作日志，用户访问日志，异常记录日志）',
    `log_level`   enum ('ERROR','WARN','INFO') CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL DEFAULT 'INFO' COMMENT '日志级别',
    `content`     varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci                   NULL     DEFAULT NULL COMMENT '日志内容（业务操作）',
    `params`      varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci                   NULL     DEFAULT NULL COMMENT '请求参数（业务操作）',
    `spider_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci                     NULL     DEFAULT NULL COMMENT '爬虫类型（当访问者被鉴定为爬虫时该字段表示爬虫的类型）',
    `ip`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci                     NULL     DEFAULT NULL COMMENT '操作用户的ip',
    `ua`          varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci                    NULL     DEFAULT NULL COMMENT '操作用户的user_agent',
    `os`          varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci                     NULL     DEFAULT NULL COMMENT '评论时的系统类型',
    `browser`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci                     NULL     DEFAULT NULL COMMENT '评论时的浏览器类型',
    `request_url` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci                   NULL     DEFAULT NULL COMMENT '请求的路径',
    `referer`     varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci                   NULL     DEFAULT NULL COMMENT '请求来源地址',
    `create_time` datetime(0)                                                                NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)                                                                NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_notice
-- ----------------------------
DROP TABLE IF EXISTS `tbl_notice`;
CREATE TABLE `tbl_notice`
(
    `id`          bigint(20) UNSIGNED                                                       NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) UNSIGNED                                                       NOT NULL COMMENT '被通知的用户ID',
    `status`      enum ('RELEASE','NOT_RELEASE') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'NOT_RELEASE' COMMENT '通知状态',
    `title`       varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci                   NULL DEFAULT NULL COMMENT '通知的标题',
    `content`     varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci                  NULL DEFAULT NULL COMMENT '通知的内容',
    `create_time` datetime(0)                                                               NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)                                                               NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_resources
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resource`;
CREATE TABLE `tbl_resource`(
    `id`          bigint(20) UNSIGNED                                     NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `type`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `url`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `permission`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `parent_id`   bigint(20) UNSIGNED                                     NULL DEFAULT 0,
    `sort`        int(10) UNSIGNED                                        NULL DEFAULT NULL,
    `external`    tinyint(1) UNSIGNED                                     NULL DEFAULT NULL COMMENT '是否外部链接',
    `available`   tinyint(1) UNSIGNED                                     NULL DEFAULT 0,
    `icon`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
    `create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_tbl_resource_parent_id` (`parent_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`
(
    `id`          bigint(20) UNSIGNED                                     NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
    `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `available`   tinyint(1)                                              NULL DEFAULT 0,
    `create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role_resources`;
CREATE TABLE `tbl_role_resources`
(
    `id`           bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `role_id`      bigint(20) UNSIGNED NOT NULL,
    `resources_id` bigint(20) UNSIGNED NOT NULL,
    `create_time`  datetime(0)         NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`  datetime(0)         NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_template
-- ----------------------------
DROP TABLE IF EXISTS `tbl_template`;
CREATE TABLE `tbl_template`
(
    `id`          bigint(20) UNSIGNED                                     NOT NULL AUTO_INCREMENT,
    `ref_key`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '键',
    `ref_value`   text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '模板内容',
    `create_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_update_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_update_record`;
CREATE TABLE `tbl_update_record`
(
    `id`           bigint(20) UNSIGNED                                      NOT NULL AUTO_INCREMENT,
    `version`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci   NULL DEFAULT NULL COMMENT '更新版本',
    `description`  varchar(2500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新记录备注',
    `record_time` datetime(0)                                              NULL DEFAULT CURRENT_TIMESTAMP COMMENT '项目更新时间',
    `create_time`  datetime(0)                                              NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time`  datetime(0)                                              NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`
(
    `id`              bigint(20) UNSIGNED                                                                                                                                                                         NOT NULL AUTO_INCREMENT,
    `username`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL,
    `password`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '登录密码',
    `nickname`        varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                      NULL DEFAULT '' COMMENT '昵称',
    `mobile`          varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                      NULL DEFAULT NULL COMMENT '手机号',
    `email`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '邮箱地址',
    `qq`              varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                      NULL DEFAULT NULL COMMENT 'QQ',
    `birthday`        date                                                                                                                                                                                        NULL DEFAULT NULL COMMENT '生日',
    `gender`          smallint(2)                                                                                                                                                                                 NULL DEFAULT NULL COMMENT '性别',
    `avatar`          varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '头像地址',
    `user_type`       enum ('ROOT','ADMIN','USER') CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                     NULL DEFAULT 'ADMIN' COMMENT '超级管理员、管理员、普通用户',
    `company`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '公司',
    `blog`            varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '个人博客地址',
    `location`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '地址',
    `source`          enum ('GITHUB','GITEE','WEIBO','DINGTALK','BAIDU','CSDN','CODING','OSCHINA','TENCENT_CLOUD','ALIPAY','TAOBAO','QQ','WECHAT','GOOGLE','FACEBOOK') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户来源',
    `uuid`            varchar(50)                                                                                                                                                                                 NULL COMMENT '用户唯一表示(第三方网站)',
    `privacy`         tinyint(2)                                                                                                                                                                                  NULL DEFAULT NULL COMMENT '隐私（1：公开，0：不公开）',
    `notification`    tinyint(2) UNSIGNED                                                                                                                                                                         NULL DEFAULT NULL COMMENT '通知：(1：通知显示消息详情，2：通知不显示详情)',
    `score`           int(10) UNSIGNED                                                                                                                                                                            NULL DEFAULT 0 COMMENT '金币值',
    `experience`      int(10) UNSIGNED                                                                                                                                                                            NULL DEFAULT 0 COMMENT '经验值',
    `reg_ip`          varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                      NULL DEFAULT NULL COMMENT '注册IP',
    `last_login_ip`   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                      NULL DEFAULT NULL COMMENT '最近登录IP',
    `last_login_time` datetime(0)                                                                                                                                                                                 NULL DEFAULT NULL COMMENT '最近登录时间',
    `login_count`     int(10) UNSIGNED                                                                                                                                                                            NULL DEFAULT 0 COMMENT '登录次数',
    `remark`          varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci                                                                                                                                     NULL DEFAULT NULL COMMENT '用户备注',
    `status`          int(1) UNSIGNED                                                                                                                                                                             NULL DEFAULT NULL COMMENT '用户状态',
    `create_time`     datetime(0)                                                                                                                                                                                 NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    `update_time`     datetime(0)                                                                                                                                                                                 NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tbl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role`
(
    `id`          bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20) UNSIGNED NOT NULL,
    `role_id`     bigint(20) UNSIGNED NOT NULL,
    `create_time` datetime(0)         NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
    `update_time` datetime(0)         NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 0
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;
