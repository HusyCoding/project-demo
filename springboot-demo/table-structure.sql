

DROP TABLE if EXISTS sys_user;
# 用户表
CREATE TABLE `sys_user` (
	`user_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`account` VARCHAR(20) UNIQUE NOT NULL COMMENT '用户账号',
	`password` VARCHAR(32) NOT NULL COMMENT '用户密码',
	`user_name` VARCHAR(20) NOT NULL COMMENT '用户名称',
	`sex` TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户性别，0：男，1：女',
	`mobile` VARCHAR(11) NULL DEFAULT NULL COMMENT '手机号码',
	`is_delete` TINYINT(1) UNSIGNED NOT NULL  DEFAULT 0  COMMENT '是否删除，0：否，1：是',
	`create_id` INT(11) UNSIGNED  NOT NULL comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`user_id`)
	INDEX KEY idx_account
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=INNODB;


INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('admin', '123456', 0,'12345678901', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('zhansan', '123456',1, '12345678902', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('lisi', '123456',0, '12345678903', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('wangwu', '123456',1, '12345678904', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('zhaoliu', '123456',0, '12345678905', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('niuqi', '123456',1, '12345678906', 1);
INSERT INTO `sys_user` (user_account, user_password, user_phone, create_id)	VALUES ('baye', '123456',0, '12345678907', 1);

# 角色表
DROP TABLE if EXISTS sys_role;
CREATE TABLE `sys_role` (
	`role_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
	`role_code` VARCHAR(20) NOT NULL COMMENT '角色编码',
	`role_name` VARCHAR(32) NOT NULL COMMENT '角色名称',
	`create_id` INT(11) UNSIGNED  NOT null comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`role_id`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;

INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('superadmin', '管理员', 1);
INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('admin', '管理员', 1);
INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('test', '测试', 1);
INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('business ', '运营', 1);
INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('finance', '财务', 1);
INSERT INTO sys_role	(role_code, role_name, create_id, create_time)	VALUES ('development', '研发', 1);

# 用户角色关系表
DROP TABLE if EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`(
	`user_role_id` INT(10)  UNSIGNED NOT NULL AUTO_INCREMENT,
	`user_id` INT(10)  UNSIGNED NOT NULL,
	`role_id` INT(10)  UNSIGNED NOT NULL,
	`create_id` INT(11) UNSIGNED  NOT null comment '创建人',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_id` INT(11)  UNSIGNED NULL DEFAULT NULL COMMENT '更新人',
	`update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`user_role_id`)
);

INSERT INTO sys_user_role(role_id, user_id, create_id, create_time)	VALUES (1, 1, 1, NOW());

# 系统操作日志表
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`(

);

