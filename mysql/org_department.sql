/*
 Navicat Premium Data Transfer

 Source Server         : 测试库
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 10.115.5.119:3306
 Source Schema         : budget

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 25/07/2019 14:47:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for org_department
-- ----------------------------
DROP TABLE IF EXISTS `org_department`;
CREATE TABLE `org_department`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级主键id',
  `org_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '部门名称或下属机构名称',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '1 : 线下公司主体，\r\n2：大区，\r\n3 : 大区本部，\r\n4：分部，\r\n5：分部汇总，\r\n6：大区汇总，\r\n7：线下本部，\r\n8：独立公司,\r\n9 : 新业务汇总',
  `org_level` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '部门级别字符串,如\'0.1.3.9\'',
  `seq_num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序号',
  `business_sector_id` int(11) NULL DEFAULT NULL COMMENT '业务板块id',
  `create_user_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_org_level`(`org_level`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预算组织表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of org_department
-- ----------------------------
INSERT INTO `org_department` VALUES (1, 0, '线下公司', 1, '0', 0, 1, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (2, 0, '线上公司', 8, '0', 0, 1, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (3, 0, '美店', 8, '0', 0, 1, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (4, 0, '家电定制', 8, '0', 0, 1, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (5, 0, '商贸', 8, '0', 0, 1, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (6, 0, '新业务汇总', 9, '0', 0, NULL, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (7, 6, '新业务---电竞网咖', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (8, 6, '新业务---厨空间', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (9, 6, '新业务---家装', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (10, 6, '新业务---酒窖', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (11, 6, '新业务---玩具', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (12, 6, '新业务---IXINA', 8, '0', 0, 2, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (13, 0, '极信转售', 8, '0', 0, 3, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (14, 0, '极信运营商', 8, '0', 0, 3, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (15, 0, '安迅运营商', 8, '0', 0, 4, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (16, 0, '安迅物流', 8, '0', 0, 4, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (17, 0, '管家售后', 8, '0', 0, 5, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (18, 0, '国美九诺', 8, '0', 0, 5, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (19, 0, '国美智能', 8, '0', 0, 5, 0, '2019-05-30 21:00:00', 0, '2019-05-30 21:00:00');
INSERT INTO `org_department` VALUES (24, 1, '线下本部', 7, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (25, 1, '东北大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (26, 1, '福建大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (27, 1, '广西大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (28, 1, '华北一区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (29, 1, '华北二区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (30, 1, '华东一区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (31, 1, '华东二区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (32, 1, '华中大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (33, 1, '河南大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (34, 1, '华南大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (35, 1, '西南大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (36, 1, '西北大区', 2, '0', 0, NULL, 0, '2019-07-11 10:48:26', 0, '2019-07-11 10:48:26');
INSERT INTO `org_department` VALUES (37, 25, '东北大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (38, 25, '沈阳分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (39, 25, '吉林分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (40, 25, '大连分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (41, 25, '鞍海分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (42, 25, '黑天鹅分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (43, 26, '福建大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (44, 26, '福州分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (45, 26, '厦门分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (46, 27, '广西大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (47, 27, '南宁分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (48, 28, '华北一区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (49, 28, '北京分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (50, 28, '天津分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (51, 28, '北京大中', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (52, 29, '华北二区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (53, 29, '济南分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (54, 29, '青岛国美', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (55, 29, '烟台国美', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (56, 29, '河北分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (57, 29, '内蒙分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (58, 29, '山西分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (59, 29, '山东大中', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (60, 30, '华东一区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (61, 30, '南京分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (62, 30, '徐州分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (63, 30, '苏州分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (64, 31, '华东二区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (65, 31, '安徽分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (66, 31, '浙江分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (67, 31, '宁波分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (68, 32, '华中大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (69, 32, '武汉分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:00', 0, '2019-07-11 10:54:00');
INSERT INTO `org_department` VALUES (70, 32, '湖南分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (71, 32, '江西分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (72, 33, '河南大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (73, 33, '河南永乐', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (74, 33, '河南分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (75, 33, '漯河分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (76, 34, '华南大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (77, 34, '佛山分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (78, 34, '湛江分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (79, 34, '广州分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (80, 34, '中山分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (81, 35, '西南大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (82, 35, '成都分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (83, 35, '重庆分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (84, 35, '昆明分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (85, 35, '贵州分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (86, 36, '西北大区本部', 3, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (87, 36, '甘肃分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (88, 36, '西安分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (89, 36, '新疆分部', 4, '0', 0, NULL, 0, '2019-07-11 10:54:01', 0, '2019-07-11 10:54:01');
INSERT INTO `org_department` VALUES (91, 25, '东北大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (92, 26, '福建大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (93, 27, '广西大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (94, 28, '华北一区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (95, 29, '华北二区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (96, 30, '华东一区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (97, 31, '华东二区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (98, 32, '华中大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (99, 33, '河南大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (100, 34, '华南大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (101, 35, '西南大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (102, 36, '西北大区汇总', 5, '0', 0, NULL, 0, '2019-07-11 11:03:24', 0, '2019-07-11 11:03:24');
INSERT INTO `org_department` VALUES (103, 1, '线下整体汇总', 6, '0', 0, NULL, 0, '2019-07-11 11:15:17', 0, '2019-07-11 11:15:17');

SET FOREIGN_KEY_CHECKS = 1;
