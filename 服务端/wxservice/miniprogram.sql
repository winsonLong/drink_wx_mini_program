/*
Navicat MySQL Data Transfer

Source Server         : lys
Source Server Version : 50541
Source Host           : localhost:3306
Source Database       : miniprogram

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2020-02-19 15:40:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for drink
-- ----------------------------
DROP TABLE IF EXISTS `drink`;
CREATE TABLE `drink` (
  `drinkId` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `picUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`drinkId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of drink
-- ----------------------------
INSERT INTO `drink` VALUES ('a', '奶茶三兄弟', '18', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('b', '珍珠奶茶', '1', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('c', '鲜芋青稞牛奶', '14', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('d', '茉香奶茶', '16', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('e', '美式咖啡', '18', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('f', '拿铁咖啡', '18', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('g', '青稞可可牛奶', '20', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('h', '双拼可可牛奶', '22', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');
INSERT INTO `drink` VALUES ('i', '布丁可可牛奶', '22', 'http://www.coco-tea.com.cn/images/product/%E9%86%87%E9%A6%99%E5%A5%B6%E8%8C%B6/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6460x460.png');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `drinkIds` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('sdadas', '猜你喜欢', 'a,b,c,d,e,f');
INSERT INTO `type` VALUES ('dsadsd', '咖啡时光', 'a,c');
INSERT INTO `type` VALUES ('dsadas', '暖饮轻食', 'a,e,g');
INSERT INTO `type` VALUES ('vdsvd', '浓情可可', 'a,b,c,d');
INSERT INTO `type` VALUES ('dsda', '牧场牛奶', 'c,d,e,a,b');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL COMMENT '用户Id',
  `avartar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `nickname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('09A6555D8190FC3741BF1DFDD4494F94', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eo5icPnuNzKDibwxH3Bv99XAI6Lsib8ianGMbmicDBhnalwPzgAa9bV3Ex2g4QkmEH8Xwh0pbB9nvOHzqg/132', '龙建国', null, 'Suizhou', 'Hubei', null);
INSERT INTO `user` VALUES ('123', '123', null, '123', null, null, null);
