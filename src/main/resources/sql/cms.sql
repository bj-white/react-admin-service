/*
*用户表 user
*/
create table user (
	id bigint(32) auto_increment primary key,
	usercode varchar(32),
	username varchar(64),
	password varchar(32),
	createby int,
	createtime datetime,
	updatetime datetime,
	state int /* 1正常  0关闭 */
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
 * 角色表
 */
create table role (
	id bigint(32) auto_increment primary key,
	name varchar(64),
	createby int,
	createtime datetime,
	updatetime datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
 * 用户角色中间表
 */
create table user_role (
	user_id bigint(32),
	role_id bigint(32),
	foreign key(user_id) references user(id),
	foreign key(role_id) references role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
*菜单表
*/
create table menu (
	id bigint(32) auto_increment primary key,
	name varchar(64),
	parent_id bigint(32),	
	url varchar(128),
	component varchar(64),
	sort int,
	icon varchar(64),
	createby int,
	createtime datetime,
	updatetime datetime,
	state int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
*菜单角色中间表 menu_role
*/
create table menu_role (
	menu_id bigint(32),
	role_id bigint(32),
	foreign key(menu_id) references menu(id),
	foreign key(role_id) references role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
*权限表 permission
*/
create table permission (
	id bigint(32) auto_increment primary key,
	name varchar(64),
	createby int,
	createtime datetime,
	updatetime datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
*权限角色中间表 permission_role
*/
create table permission_role (
	permission_id bigint(32),
	role_id bigint(32),
	foreign key(permission_id) references permission(id),
	foreign key(role_id) references role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table test (
	id bigint(32) auto_increment primary key,
	`order` int,
	number varchar(32),
	name varchar(32),
	ename varchar(64),
	sex varchar(32),
	tel varchar(32),
	phone varchar(32),
	email varchar(64),
	dep varchar(128),
	center varchar(128),
	company_code varchar(32),
	company varchar(128),
	position varchar(64),
	rank varchar(128),
	level varchar(128),
	qualification varchar(128)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;