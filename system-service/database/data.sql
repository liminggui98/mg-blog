USE sys;
DELETE
FROM tbl_config
WHERE 1 = 1;
DELETE
FROM tbl_role
WHERE 1 = 1;
DELETE
FROM tbl_resource
WHERE 1 = 1;
DELETE
FROM tbl_role_resource
WHERE 1 = 1;
DELETE
FROM tbl_user
WHERE 1 = 1;

INSERT INTO tbl_config(config_key, config_value)
values ('siteName', 'MgBlog');

INSERT INTO tbl_role(name, description, available)
values ('系统管理员', '系统管理员', 1);

INSERT INTO tbl_resource(name, type, url, permission, parent_id, sort, external, available, icon)
values ('权限管理', 'menu', null, "rights:read", null, 1, 1, 1, '');

INSERT INTO tbl_role_resource(role_id, resource_id)
values (1, 1);

INSERT INTO tbl_user(username, password, nickname, mobile, email, qq, birthday, gender, user_type, company, blog,
                     location, source, uuid, privacy, notification, score, experience, reg_ip, last_login_ip,
                     last_login_time, login_count, remark, status)
values ('root', '123456', '系统管理员', '', '1406345965@qq.com', '1406345964', '1995-07-11', '0', '1', '', '', '江苏南京', '1',
        '',
        '1', '1', '1', '1', '', '', '2020-11-28', '1', '', '1');