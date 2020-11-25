use sys;
delete
from tbl_role;
delete
from tbl_resources;
delete
from tbl_role_resources;

insert into tbl_role(name, description, available)
values ('管理员', '管理员', 1);

-- 设置资源类
insert into tbl_resource(name, type, url, permission, parent_id, sort, external, available, icon)
values ('权限管理', 'menu', null, "rights:read", null, 1, 1, 1, '');

insert into tbl_role_resources(role_id, resources_id)
values (1, 1);