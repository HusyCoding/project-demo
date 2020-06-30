####################################################
####################数据库初始化####################
####################################################

DROP TABLE if EXISTS sys_user;
# 系统用户表
CREATE TABLE `sys_user` (
	`user_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`account` VARCHAR(20) UNIQUE NOT NULL COMMENT '用户账号',
	`password` VARCHAR(32) NOT NULL COMMENT '用户密码',
	`user_name` VARCHAR(20) NOT NULL COMMENT '用户名称',
	`sex` TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户性别，0：男，1：女',
	`mobile` VARCHAR(11) NULL DEFAULT NULL COMMENT '手机号码',
	`status` INT(4) NOT NULL DEFAULT '0' COMMENT '状态  0：正常   1：禁用',
	`create_id` INT(11) UNSIGNED  NOT NULL comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_delete` TINYINT(1) UNSIGNED NOT NULL  DEFAULT 0  COMMENT '是否删除，0：否，1：是',
	PRIMARY KEY (`user_id`)
)
COMMENT='系统用户表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;


# 角色表
DROP TABLE if EXISTS sys_role;
CREATE TABLE `sys_role` (
	`role_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_code` VARCHAR(20) NOT NULL COMMENT '角色编码',
	`role_name` VARCHAR(32) NOT NULL COMMENT '角色名称',
	`parent_id` INT(11) UNSIGNED NOT NULL COMMENT '父级角色ID',
	`create_id` INT(11) UNSIGNED  NOT null comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_delete` TINYINT(1) UNSIGNED NOT NULL  DEFAULT 0  COMMENT '是否删除，0：否，1：是',
	PRIMARY KEY (`role_id`)
)
COMMENT='系统角色表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

# 菜单功能表
DROP TABLE if EXISTS sys_role;
CREATE TABLE `sys_role` (
	`role_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_code` VARCHAR(20) NOT NULL COMMENT '角色编码',
	`role_name` VARCHAR(32) NOT NULL COMMENT '角色名称',
	`create_id` INT(11) UNSIGNED  NOT null comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`is_delete` TINYINT(1) UNSIGNED NOT NULL  DEFAULT 0  COMMENT '是否删除，0：否，1：是',
	PRIMARY KEY (`role_id`)
)
COMMENT='系统角色表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;


# 用户角色关系表
DROP TABLE if EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`(
	`user_role_id` INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(11)  UNSIGNED NOT NULL,
	`role_id` INT(11)  UNSIGNED NOT NULL,
	`create_id` INT(11) UNSIGNED  NOT null comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`user_role_id`)
)
COMMENT='系统用户角色关系表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

INSERT INTO sys_user_role(role_id, user_id, create_id, create_time)	VALUES (1, 1, 1, NOW());

# 系统操作日志表
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`(
	`log_id` INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT,
	`business_name` VARCHAR(20) NOT NULL COMMENT '业务名称，一般记录菜单模块名称',
	`action` TINYINT(1) NOT NULL  COMMENT '1:新增、2:删除、3:修改',
	`operator_id` VARCHAR(20) NOT NULL COMMENT '操作账户ID',
	`ip` INT(10) UNSIGNED NOT NULL COMMENT '请求客户端IP',
	`uri` VARCHAR(50) NOT NULL COMMENT '请求服务URI',
	`method` VARCHAR(10) NOT NULL COMMENT '请求方式',
	`content` VARCHAR(100) NOT NULL DEFAULT COMMENT '请求参数',
	`access_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求时间',
	`cost_time` INT(7) UNSIGNED NOT NULL DEFAULT 0 COMMENT '请求耗时（毫秒）',
	PRIMARY KEY (`log_id`)
)
COMMENT='系统操作日志表'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;
