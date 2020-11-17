#-------------------文章表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_article
(
    id          VARCHAR(50) PRIMARY KEY COMMENT '主键',
    create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    title       VARCHAR(200) NOT NULL COMMENT '文章标题',
    user_id     VARCHAR(50)  NOT NULL COMMENT '用户id',
    content     MEDIUMTEXT COMMENT '文章内容',
    status      SMALLINT     NOT NULL DEFAULT 0 COMMENT '状态 0：有效'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------类型表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_type
(
    id             VARCHAR(50) NOT NULL PRIMARY KEY,
    create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    type_name      VARCHAR(50) NOT NULL COMMENT '类型名',
    status         SMALLINT    NOT NULL DEFAULT 0 COMMENT '状态 0：有效',
    parent_id			 VARCHAR(50) NOT NULL DEFAULT '0' COMMENT '父类型 id, 无父类型时为 0',
    create_user_id VARCHAR(50) NOT NULL COMMENT '创建用户的 id'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------文章-类型关联表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_article_type
(
    id             VARCHAR(50) NOT NULL PRIMARY KEY,
    create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    article_id     VARCHAR(50) NOT NULL COMMENT '文章 id',
    type_id        VARCHAR(50) NOT NULL COMMENT '类型 id',
    status         SMALLINT    NOT NULL DEFAULT 0 COMMENT '状态 0：有效',
    create_user_id VARCHAR(50) NOT NULL COMMENT '创建用户的 id'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------文章关键词表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_article_keyword
(
    id             VARCHAR(50) NOT NULL PRIMARY KEY,
    create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ariticle_id    VARCHAR(50) NOT NULL,
    word           VARCHAR(20) NOT NULL COMMENT '关键词',
    status         SMALLINT    NOT NULL DEFAULT 0 COMMENT '状态 0：有效',
    create_user_id VARCHAR(50) NOT NULL COMMENT '创建用户的 id'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------文章阅读数据表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_article_look
(
    id          VARCHAR(50) NOT NULL PRIMARY KEY,
    create_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id     VARCHAR(50) NOT NULL COMMENT '用户 id',
    user_ip     VARCHAR(20) NOT NULL COMMENT '用户ip',
    ariticle_id VARCHAR(50) NOT NULL COMMENT '创建用户 id'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------文章点赞数据表-------------------
CREATE TABLE
    IF
    NOT EXISTS tbl_article_love
(
    id          VARCHAR(50) NOT NULL PRIMARY KEY,
    create_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id     VARCHAR(50) NOT NULL COMMENT '用户 id',
    ariticle_id VARCHAR(50) NOT NULL COMMENT '创建用户 id'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

#-------------------文章评论数据表-------------------#
CREATE TABLE
    IF
    NOT EXISTS tbl_article_commont
(
    id          VARCHAR(50)  NOT NULL PRIMARY KEY,
    create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id     VARCHAR(50)  NOT NULL COMMENT '用户 id',
    ariticle_id VARCHAR(50)  NOT NULL COMMENT '创建用户 id',
    content     VARCHAR(500) NOT NULL COMMENT '用户拼论'
) ENGINE = INNODB
  AUTO_INCREMENT = 0
  CHARACTER
      SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;
