-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.16 - MySQL Community Server - GPL
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for husy_db
CREATE DATABASE IF NOT EXISTS `husy_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `husy_db`;

-- Dumping structure for table husy_db.sys_log
CREATE TABLE IF NOT EXISTS `sys_log` (
  `log_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `business_name` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务名称，一般记录菜单模块名称',
  `action` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '0:DB查询、1:DB新增、2:DB删除、3:DB修改',
  `operator_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '操作账户ID',
  `ip` int(10) unsigned NOT NULL COMMENT '请求客户端IP',
  `uri` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求服务URI',
  `method` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '请求方式',
  `content` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求参数',
  `access_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求时间',
  `cost_time` int(7) unsigned NOT NULL DEFAULT '0' COMMENT '请求耗时（毫秒）',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统操作日志表';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_menu
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `menu_id` int(11) unsigned NOT NULL COMMENT 'ID',
  `parent_id` int(1) unsigned DEFAULT NULL COMMENT '父菜单ID',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `menu_level` tinyint(4) unsigned NOT NULL COMMENT '菜单级别，0:一级，1:二级，2:三级，3:四级',
  `menu_order` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '菜单排序',
  `is_spread` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否展开  0：不展开  1：展开',
  `status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '状态,0:禁用,1:启用',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单授权码(多个用逗号分隔，如：user:list,user:create)',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建用户',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '更新用户',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除：0-未删除，1-已删除',
  PRIMARY KEY (`menu_id`),
  KEY `idx_parent_code` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_region
CREATE TABLE IF NOT EXISTS `sys_region` (
  `region_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '行政区域编码',
  `region_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '行政区域名称',
  `parent_code` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '上级行政区域编码',
  `region_type` tinyint(4) unsigned NOT NULL COMMENT '行政区域级别：1-省/直辖市; 2-省级市/地级市/州; 3-区/县/县级市',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0-未删除，1-已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci AVG_ROW_LENGTH=55 COMMENT='区域信息:\r\n第一、二位表示省（自治区、直辖市、特别行政区）。\r\n第三、四位表示市（地区、自治州、盟及国家直辖市所属市辖区和县的汇总码）。其中，01-20，51-70表示省直辖市；21-50表示地区（自治州、盟）。\r\n第五、六位表示县（市辖区、县级市、旗）。01-20表示市辖区或地区（自治州、盟）辖县级市；21-70表示县（旗）；81-99表示省直辖县级市；71-80表示工业园区或者经济开发区。';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_role
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_code` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编码',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `create_id` int(11) unsigned NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` int(11) unsigned DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_role_menu
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `id` int(11) unsigned NOT NULL COMMENT 'ID',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色ID',
  `menu_id` int(11) unsigned NOT NULL COMMENT '菜单ID',
  `check_state` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '选中状态：0未选中,1选中,2半选',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` int(11) unsigned NOT NULL COMMENT '创建用户ID',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_id` int(11) unsigned NOT NULL COMMENT '更新用户ID',
  PRIMARY KEY (`id`),
  KEY `idx_role_menu` (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单对应关系';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_user
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(20) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
  `sex` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '用户性别，0：男，1：女',
  `mobile` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
  `status` int(4) unsigned NOT NULL DEFAULT '0' COMMENT '状态  0：正常   1：禁用',
  `create_id` int(11) unsigned NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` int(11) unsigned NOT NULL COMMENT '更新人ID',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0：否，1：是',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户表';

-- Data exporting was unselected.

-- Dumping structure for table husy_db.sys_user_role
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `user_role_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `create_id` int(11) unsigned NOT NULL COMMENT '创建人id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` int(11) unsigned NOT NULL COMMENT '更新人id',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户角色关系表';

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
