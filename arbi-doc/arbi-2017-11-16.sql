/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.34-log : Database - arbi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`arbi` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `arbi`;

/*Table structure for table `adjudication_amendment_record` */

DROP TABLE IF EXISTS `adjudication_amendment_record`;

CREATE TABLE `adjudication_amendment_record` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `CASE_ID` varchar(600) NOT NULL COMMENT '案件id',
  `CONTENT_ID` varchar(32) NOT NULL COMMENT '补正人ID user_info中的id',
  `CONTENT` text NOT NULL COMMENT '当事人补正内容',
  `ARBITRATOR_CONTENT` text COMMENT '仲裁员补正内容',
  `STAUTS` char(1) NOT NULL COMMENT '0-待审核，1-审核通过，2-审核失败',
  `REMARK` text COMMENT '备注',
  `CREATER` varchar(32) NOT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL COMMENT '创建日期yyyyMMdd',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `adjudication_amendment_record` */

insert  into `adjudication_amendment_record`(`ID`,`CASE_ID`,`CONTENT_ID`,`CONTENT`,`ARBITRATOR_CONTENT`,`STAUTS`,`REMARK`,`CREATER`,`CREATE_TIME`) values ('1','1','1','1','1','1','1','1','2017-11-07 22:18:44'),('15','20','21','22','22','2','22','22','2017-11-16 11:57:24'),('16','20','20','222','222','2','222','222','2017-11-16 11:57:55'),('17','20','20','2222','2222','2','2222','2222','2017-11-16 11:58:26'),('2','2','2','补正记录','补正记录','1','1','1','2017-11-23 22:19:33'),('3','3','3','1','1','1','1','1','2017-11-02 22:19:50'),('4','2','2','补正记录','补正记录','2','2','2','2017-11-29 22:20:48'),('5','2','1','补正记录','补正记录','1','1','1','2017-11-15 09:53:59');

/*Table structure for table `api_org_cert` */

DROP TABLE IF EXISTS `api_org_cert`;

CREATE TABLE `api_org_cert` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ORG_ID` varchar(32) NOT NULL COMMENT '机构ID',
  `VERSION` int(5) NOT NULL DEFAULT '0' COMMENT '版本号',
  `CLT_PUBLIC_KEY` blob COMMENT '客户端公钥',
  `CLT_PRIVATE_CERT` blob COMMENT '客户端私钥证书',
  `CLT_PRIVATE_KEY_PASS` varchar(1024) DEFAULT NULL COMMENT '客户端私钥库密钥',
  `PLT_PUBLIC_KEY` blob COMMENT '平台公钥',
  `PLT_PRIVATE_CERT` blob COMMENT '平台私钥证书',
  `PLT_PRIVATE_KEY_PASS` varchar(1024) DEFAULT NULL COMMENT '平台私钥库证密钥',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0-初始，1-正常（使用中），2-失效（过期）',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='API-机构证书表';

/*Data for the table `api_org_cert` */

/*Table structure for table `api_orgnazation` */

DROP TABLE IF EXISTS `api_orgnazation`;

CREATE TABLE `api_orgnazation` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `NAME` varchar(255) NOT NULL COMMENT '机构名称(简称)',
  `REG_NAME` varchar(255) NOT NULL COMMENT '机构全称',
  `ORG_SITE` varchar(255) DEFAULT NULL COMMENT '机构网址',
  `COUNTRY` varchar(255) DEFAULT NULL COMMENT '机构所在国家',
  `PROVINCE` varchar(255) DEFAULT NULL COMMENT '机构所在省份',
  `CITY` varchar(255) DEFAULT NULL COMMENT '机构所在城市',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='API-机构表';

/*Data for the table `api_orgnazation` */

/*Table structure for table `arbi_change_record` */

DROP TABLE IF EXISTS `arbi_change_record`;

CREATE TABLE `arbi_change_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `CHANGE_CONTENT` varchar(600) DEFAULT NULL,
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '变更人ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `COUNTERCLAIM_FLAG` char(1) DEFAULT NULL COMMENT '请求标志。0-正请求，1-反请求',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态。0-待审核,1-审核通过,2-审核未通过',
  `REASON` text COMMENT '未通过原因',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `arbi_change_record` */

insert  into `arbi_change_record`(`ID`,`CASE_ID`,`CHANGE_CONTENT`,`USER_ID`,`REQUEST_ID`,`COUNTERCLAIM_FLAG`,`STATUS`,`REASON`,`CREATER_ID`,`CREATE_TIME`) values (1,'2','新内容','2',3,'0','2','不通过原因','2','2017-11-15 16:09:28'),(2,'2','新内容','2',3,'0','0','','2','2017-11-15 16:09:28'),(3,'2','新内容','2',3,'0','1','','2','2017-11-15 16:09:28'),(4,'2','新内容','2',4,'1','2','不通过原因','2','2017-11-15 16:09:28'),(5,'2','新内容','2',4,'1','0','','2','2017-11-15 16:09:28'),(6,'2','新内容','2',4,'1','1','','2','2017-11-15 16:09:28');

/*Table structure for table `arbitrator_info` */

DROP TABLE IF EXISTS `arbitrator_info`;

CREATE TABLE `arbitrator_info` (
  `ID` varchar(32) NOT NULL DEFAULT '',
  `USER_ID` varchar(32) DEFAULT NULL,
  `BIRTHDAY` varchar(8) DEFAULT NULL,
  `VOCATION` varchar(256) DEFAULT NULL,
  `ACCEPT_STATUS` char(1) DEFAULT NULL,
  `SPECIALTY` varchar(256) DEFAULT NULL,
  `ADDRESS` varchar(256) DEFAULT NULL,
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_DATE` varchar(8) DEFAULT NULL,
  `CREATE_TIME` varchar(6) DEFAULT NULL,
  `UPDATE_ID` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` varchar(8) DEFAULT NULL,
  `UPDATE_TIME` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `arbitrator_info` */

insert  into `arbitrator_info`(`ID`,`USER_ID`,`BIRTHDAY`,`VOCATION`,`ACCEPT_STATUS`,`SPECIALTY`,`ADDRESS`,`CREATER_ID`,`CREATE_DATE`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_DATE`,`UPDATE_TIME`) values ('1','1','1','1','0','1','1','1','1','1','1','1','1'),('2','2',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3','3',NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `case_agent` */

DROP TABLE IF EXISTS `case_agent`;

CREATE TABLE `case_agent` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `LITIGANT_TYPE` char(1) DEFAULT NULL COMMENT '当事人身份,0-申请人，1-被申请人',
  `AGENT_ID` varchar(32) DEFAULT NULL COMMENT '代理人编号  ---USER_ID',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='案件代理人关系表';

/*Data for the table `case_agent` */

insert  into `case_agent`(`ID`,`CASE_ID`,`LITIGANT_TYPE`,`AGENT_ID`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_TIME`) values (1,'1','1','1',NULL,NULL,NULL,NULL),(2,'1','0','2',NULL,NULL,NULL,NULL),(3,'CASE20171111185391902042','0','1','1','2017-11-11 18:53:11',NULL,NULL),(4,'CASE20171111185591902044','0','1','1','2017-11-11 18:55:19',NULL,NULL),(5,'CASE20171113103989408820','0','1','1','2017-11-13 10:39:10',NULL,NULL),(6,'CASE20171113103989408822','0','1','1','2017-11-13 10:39:23',NULL,NULL),(7,'CASE20171111185391908734','0','1','1','2017-11-14 16:48:44',NULL,NULL),(8,'CASE20171111185391908734','1','2','1','2017-11-14 16:49:45',NULL,NULL),(9,'CASE20171115132057560779','0','2','2','2017-11-15 13:20:22',NULL,NULL),(10,'CASE20171115141357560781','0','2','2','2017-11-15 14:13:35',NULL,NULL),(11,'CASE20171115155942008532','0','2','2','2017-11-15 15:59:55',NULL,NULL),(12,'CASE20171115162371345962','0','2','2','2017-11-15 16:23:39',NULL,NULL),(15,'20','0','2121',NULL,NULL,NULL,NULL),(16,'20','1','1212',NULL,NULL,NULL,NULL);

/*Table structure for table `case_approve` */

DROP TABLE IF EXISTS `case_approve`;

CREATE TABLE `case_approve` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `APPROVE_USER_ID` varchar(32) DEFAULT NULL COMMENT '审批人ID',
  `APPROVE_CONTENT` text COMMENT '审批内容',
  `APPROVE_TYPE` char(255) DEFAULT NULL COMMENT '审批类型',
  `APPROVE_STATUS` char(255) DEFAULT NULL COMMENT '0-待审核，1-审核通过，2-审核未通过',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_approve` */

insert  into `case_approve`(`ID`,`CASE_ID`,`REQUEST_ID`,`APPROVE_USER_ID`,`APPROVE_CONTENT`,`APPROVE_TYPE`,`APPROVE_STATUS`,`CREATE_TIME`) values (1,'1',15,'11','审批内容2','1','0','2017-11-15 17:22:26'),(2,'2',1,'1','ddd','1','1','2017-11-11 15:11:48'),(3,'3',1,'1','eee','1','2','2017-11-11 15:12:04'),(5,'1',16,'10','审批内容1','2','0','2017-11-16 16:41:53'),(6,'5',21,'9','不通过','4','2','2017-11-16 12:02:07'),(7,'5',21,'9','通过','4','1','2017-11-16 12:02:16'),(8,'5',21,'10','不通过','4','2','2017-11-16 12:09:02'),(9,'5',21,'9','通过','4','1','2017-11-16 12:05:38'),(10,'5',21,'10','通过','4','1','2017-11-16 12:05:55'),(11,'5',21,'11','不通过','4','2','2017-11-16 12:06:15'),(12,'5',21,'10','通过','4','1','2017-11-16 12:06:41'),(13,'5',21,'11','通过','4','1','2017-11-16 12:06:57'),(14,'1',3,'1','通过','8','2','2017-11-16 16:47:23');

/*Table structure for table `case_approve_suggest` */

DROP TABLE IF EXISTS `case_approve_suggest`;

CREATE TABLE `case_approve_suggest` (
  `ID` int(11) DEFAULT NULL,
  `CASE_ID` varchar(255) DEFAULT NULL COMMENT '案件ID',
  `APPROVE_ID` int(11) DEFAULT NULL COMMENT '审批ID',
  `APPROVE_SUGGEST` text COMMENT '审批意见',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_approve_suggest` */

insert  into `case_approve_suggest`(`ID`,`CASE_ID`,`APPROVE_ID`,`APPROVE_SUGGEST`,`CREATER_ID`,`CREATE_TIME`) values (1,'1',1,'本庭决定小胖赔偿小豪炒饭一顿','1','2017-11-12 21:58:33'),(2,'1',5,'审批意见内容','2','2017-11-22 11:44:00'),(3,'5',6,'不通过，因为不通过','9','2017-11-16 12:11:32'),(4,'5',7,'通过，就是通过','9','2017-11-16 12:11:35'),(5,'5',8,'我不想让你通过','10','2017-11-16 12:08:15'),(6,'5',9,'算了，让你通过吧','9','2017-11-16 12:08:45'),(7,'5',10,'通过就通过','10','2017-11-16 12:09:07'),(8,'5',11,'不送礼我不让你通过','11','2017-11-16 12:09:31'),(9,'5',12,'送给我礼物了，通过你的请求','10','2017-11-16 12:09:54'),(10,'5',13,'给部长送礼，再给我送礼，小子，你可以的，让你荣光','11','2017-11-16 12:10:30');

/*Table structure for table `case_arbitrator` */

DROP TABLE IF EXISTS `case_arbitrator`;

CREATE TABLE `case_arbitrator` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(128) DEFAULT NULL COMMENT '案件ID',
  `ARBITRATOR_ID` varchar(32) DEFAULT NULL COMMENT '仲裁员ID',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态，0-待受理，1-不受理，2-有效，3-回避',
  `TYPE` char(1) DEFAULT NULL COMMENT '类型，0-指派，1-选定',
  `ACCEPT_TIME` varchar(6) DEFAULT NULL COMMENT '受理时间',
  `REMARK` varchar(512) DEFAULT NULL COMMENT '备注',
  `CREATE_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `ACCEPT_DATE` timestamp NULL DEFAULT NULL COMMENT '受理日期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='案件仲裁员关系表';

/*Data for the table `case_arbitrator` */

insert  into `case_arbitrator`(`ID`,`CASE_ID`,`ARBITRATOR_ID`,`STATUS`,`TYPE`,`ACCEPT_TIME`,`REMARK`,`CREATE_ID`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_TIME`,`ACCEPT_DATE`) values (28,'2','2','2','0',NULL,NULL,'999999','2017-11-13 22:43:27',NULL,NULL,NULL),(29,'1','1','2','0',NULL,NULL,'999998','2017-11-14 12:05:24',NULL,NULL,NULL);

/*Table structure for table `case_avoid_record` */

DROP TABLE IF EXISTS `case_avoid_record`;

CREATE TABLE `case_avoid_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `AVOID_ID` varchar(32) DEFAULT NULL COMMENT '回避人ID user_id',
  `AVOID_REASON` text COMMENT '回避理由',
  `AVOID_TYPE` char(1) DEFAULT NULL COMMENT '回避类型 0-秘书回避 1-仲裁员回避',
  `AVOID_STYLE` char(1) DEFAULT NULL COMMENT '回避方式 0-自己回避 1-被回避',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 0 -待审核 1 审核通过 2 审核失败',
  `FAIL_REASON` text COMMENT '审核失败原因',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_avoid_record` */

insert  into `case_avoid_record`(`ID`,`CASE_ID`,`AVOID_ID`,`AVOID_REASON`,`AVOID_TYPE`,`AVOID_STYLE`,`STATUS`,`FAIL_REASON`,`CREATER_ID`,`CREATE_TIME`) values (1,'1','2','22222222','0','0',NULL,NULL,'2','2017-11-14 22:07:29'),(2,'1','2','22222222','1','0',NULL,NULL,'2','2017-11-14 22:08:39'),(3,'1','4','22222222','0','1',NULL,NULL,'2','2017-11-14 22:09:33'),(4,'1','1','22222222','1','1',NULL,NULL,'2','2017-11-14 22:10:05'),(5,'CASE20171111185391908734','2','我和申请人有关系','0','0',NULL,NULL,'2','2017-11-15 18:05:17'),(6,'CASE20171111185391908734','2','我和申请人有关系','0','0',NULL,NULL,'2','2017-11-15 18:16:55'),(7,'CASE20171111185391908734','2','我和申请人有关系','0','0','0',NULL,'2','2017-11-15 19:53:00');

/*Table structure for table `case_change_record` */

DROP TABLE IF EXISTS `case_change_record`;

CREATE TABLE `case_change_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `CHANGE_CONTENT` text COMMENT '变更内容',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '变更人ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `COUNTERCLAIM_FLAG` varchar(255) DEFAULT NULL COMMENT '请求标志 0-正请求 1-反请求',
  `STATUS` varchar(255) DEFAULT NULL COMMENT '状态 0 待审核 1 通过 2 未通过',
  `REASON` text COMMENT '未通过原因',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_change_record` */

insert  into `case_change_record`(`ID`,`CASE_ID`,`CHANGE_CONTENT`,`USER_ID`,`REQUEST_ID`,`COUNTERCLAIM_FLAG`,`STATUS`,`REASON`,`CREATER_ID`,`CREATE_TIME`) values (2,'1','2222222222','2',1,'0','0',NULL,'2',NULL),(3,'2','新内容','2',3,'0','0',NULL,'2',NULL),(4,'2','新内容','2',4,'1','0',NULL,'2',NULL);

/*Table structure for table `case_classify` */

DROP TABLE IF EXISTS `case_classify`;

CREATE TABLE `case_classify` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `TYPE_NAME` varchar(128) DEFAULT NULL COMMENT '类型名',
  `CASE_TYPE` char(1) DEFAULT NULL COMMENT '案件类型 0-个人，1-企业',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_classify` */

insert  into `case_classify`(`ID`,`TYPE_NAME`,`CASE_TYPE`,`REMARK`) values (1,'债权转让合同纠纷','0','债权转让合同纠纷'),(2,'借款合同纠纷','0','借款合同纠纷'),(3,'信用卡纠纷','1','信用卡纠纷'),(4,'金融借款合同纠纷','1','金融借款合同纠纷');

/*Table structure for table `case_defendant` */

DROP TABLE IF EXISTS `case_defendant`;

CREATE TABLE `case_defendant` (
  `ID` varchar(32) DEFAULT NULL,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `PROP_NAME` varchar(32) DEFAULT NULL COMMENT '被申请人名称',
  `CARD_ID` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `ADDRESS` varchar(128) DEFAULT NULL COMMENT '住址',
  `PHONE` varchar(16) DEFAULT NULL COMMENT '手机号',
  `CARD_IMAGE_PRONT` varchar(32) DEFAULT NULL COMMENT '身份证正面照',
  `CARD_IMAGE_CON` varchar(32) DEFAULT NULL COMMENT '身份证反面照',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `BIRTHDAY` varchar(8) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `PROP_TYPE` char(1) DEFAULT NULL,
  `CERT_NAME` varchar(32) DEFAULT NULL,
  `CERT_DUTIES` varchar(32) DEFAULT NULL,
  `UNIFIED_SOCIAL_CODE` varchar(32) DEFAULT NULL,
  `ETHNIC` varchar(32) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_defendant` */

insert  into `case_defendant`(`ID`,`CASE_ID`,`PROP_NAME`,`CARD_ID`,`ADDRESS`,`PHONE`,`CARD_IMAGE_PRONT`,`CARD_IMAGE_CON`,`CREATER_ID`,`CREATE_TIME`,`BIRTHDAY`,`EMAIL`,`PROP_TYPE`,`CERT_NAME`,`CERT_DUTIES`,`UNIFIED_SOCIAL_CODE`,`ETHNIC`,`SEX`) values ('1','1','被申请徐奕豪','441521199802138213','广东省汕尾市海丰县88888','13148726005','',NULL,NULL,'2017-11-14 14:28:14','20170807','yihaoxu1998@gmail.com','0','','','','汉族','男'),('2','2','周慧杰','421024199512256666',NULL,NULL,NULL,NULL,NULL,'2017-11-09 15:57:52',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('3','3','陈炎辉','441521199808071234',NULL,NULL,NULL,NULL,NULL,'2017-11-09 15:58:20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'CASE20171111185391902042','徐奕豪','441521199802138213','11111111','徐奕豪',NULL,NULL,'1','2017-11-11 18:53:11',NULL,NULL,'0',NULL,NULL,NULL,NULL,'女'),(NULL,'CASE20171111185591902044','徐奕豪','441521199802138216','广东省汕尾市海丰县附城镇','13148726005',NULL,NULL,'1','2017-11-11 18:55:19','19980213','1441315275@qq.com','0',NULL,NULL,NULL,'汉族','男'),(NULL,'CASE20171113103989408820','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'1','2017-11-13 10:39:10','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男'),(NULL,'CASE20171113103989408822','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'1','2017-11-13 10:39:23','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男'),('4','CASE20171111185391908734','侯龙','441521199802138216','湖北省武汉市',NULL,NULL,NULL,NULL,'2017-11-13 18:20:27',NULL,NULL,NULL,'小龙',NULL,NULL,NULL,NULL),(NULL,'CASE20171115132057560779','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'2','2017-11-15 13:20:22','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男'),(NULL,'CASE20171115141357560781','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'2','2017-11-15 14:13:35','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男'),(NULL,'CASE20171115155942008532','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'2','2017-11-15 15:59:55','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男'),(NULL,'CASE20171115162371345962','周慧杰','441521199802138216','湖南省长沙市','13148726005',NULL,NULL,'2','2017-11-15 16:23:39','19880215','1441315275@qq.com','0','徐奕豪','COO','SAF132213','汉族','男');

/*Table structure for table `case_doc` */

DROP TABLE IF EXISTS `case_doc`;

CREATE TABLE `case_doc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DOC_NAME` varchar(256) DEFAULT NULL COMMENT '文件名',
  `DOC_TYPE` char(1) DEFAULT NULL COMMENT '文书类型 0-撤案决定书，1-裁决书，2-仲裁申请书，3-反请求申请，4-反请求撤案决定书',
  `SIGN_STATUS` char(1) DEFAULT NULL COMMENT '签章状态',
  `FILE_ID` varchar(32) DEFAULT NULL COMMENT '文件ID',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `STATUS` char(1) DEFAULT NULL COMMENT '业务状态 0-正常，1-废弃',
  `LOGISTICS_STATUS` char(1) DEFAULT NULL COMMENT '逻辑状态',
  `DOC_YEAR_NUMBER` varchar(32) DEFAULT NULL COMMENT '文书年编号',
  `DOC_SERIAL_NUMBER` varchar(32) DEFAULT NULL COMMENT '文书序列号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_doc` */

insert  into `case_doc`(`ID`,`DOC_NAME`,`DOC_TYPE`,`SIGN_STATUS`,`FILE_ID`,`CASE_ID`,`STATUS`,`LOGISTICS_STATUS`,`DOC_YEAR_NUMBER`,`DOC_SERIAL_NUMBER`) values (2,'反请求撤案决定书','3',NULL,NULL,'1',NULL,NULL,'2017','571817'),(3,'反请求撤案决定书','3',NULL,NULL,'1',NULL,NULL,'2017','196610');

/*Table structure for table `case_doc_content` */

DROP TABLE IF EXISTS `case_doc_content`;

CREATE TABLE `case_doc_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件id',
  `REQUEST_ID` int(11) DEFAULT NULL,
  `BODY_TEXT` text COMMENT '正文',
  `OPINION` text COMMENT '意见',
  `FINAL_DECISION` text COMMENT '最终决定',
  `ISSUE_TYPE` int(11) DEFAULT NULL COMMENT '出具类型',
  `ISSUE_ID` varchar(32) DEFAULT NULL COMMENT '出具人id',
  `ISSUS_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出具时间',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `DOC_ID` int(11) DEFAULT NULL COMMENT '文书id',
  `SECRETARY_ID` varchar(32) DEFAULT NULL COMMENT '秘书ID',
  `ARBITRATOR_ID` varchar(32) DEFAULT NULL COMMENT '仲裁员ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_doc_content` */

insert  into `case_doc_content`(`ID`,`CASE_ID`,`REQUEST_ID`,`BODY_TEXT`,`OPINION`,`FINAL_DECISION`,`ISSUE_TYPE`,`ISSUE_ID`,`ISSUS_TIME`,`CREATE_TIME`,`DOC_ID`,`SECRETARY_ID`,`ARBITRATOR_ID`) values (1,'1',NULL,'甲方欠乙方5000元，提起仲裁请求','判定乙方在明天之前还甲方5000元','判定乙方在明天之前还甲方5000元',1,NULL,'2017-11-10 10:51:33','2017-11-10 10:51:33',1,'2',NULL),(2,'1',NULL,'甲方欠乙方5000元，提起仲裁请求','判定乙方在明天之前还甲方5000元','判定乙方在明天之前还甲方5000元',1,NULL,'2017-11-13 15:13:23','2017-11-10 10:58:33',2,'1','1'),(3,'1',NULL,'甲方欠乙方5000元，提起仲裁请求','判定乙方在明天之前还甲方5000元','判定乙方在明天之前还甲方5000元',1,NULL,'2017-11-10 10:51:33','2017-11-10 10:51:33',3,'1','1'),(4,NULL,NULL,'2014年3月23日某某人提出仲裁请求后愿意撤回仲裁申请','建议通过','同意撤回',NULL,NULL,NULL,'2017-11-16 16:00:58',NULL,'4','1');

/*Table structure for table `case_eval` */

DROP TABLE IF EXISTS `case_eval`;

CREATE TABLE `case_eval` (
  `ID` varchar(32) DEFAULT NULL,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `LITIGANT_ID` varchar(32) DEFAULT NULL COMMENT '当事人ID',
  `OPINION_RATING` char(255) DEFAULT NULL COMMENT '评价等级 0-满意，1-一般，2-待改善',
  `OPINION_CONTENT` text COMMENT '评价内容',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_ID` varchar(255) DEFAULT NULL,
  `UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `CREATE_DATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_eval` */

insert  into `case_eval`(`ID`,`CASE_ID`,`LITIGANT_ID`,`OPINION_RATING`,`OPINION_CONTENT`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_TIME`,`CREATE_DATE`) values ('1','1','1','满意','挺好的','1','2017-11-07 11:06:26','','2017-11-07 11:06:26','2017-10-01'),('2','2','2','一般','一般般吧','2','2017-11-07 20:34:58',NULL,'2017-11-07 20:34:58','2017-10-02');

/*Table structure for table `case_info` */

DROP TABLE IF EXISTS `case_info`;

CREATE TABLE `case_info` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `CASE_NO` varchar(32) DEFAULT NULL COMMENT '案号',
  `ACCEPTANCE_NO` varchar(32) DEFAULT NULL COMMENT '收案号',
  `CASE_TYPE_ID` int(11) DEFAULT NULL COMMENT '案件类型ID',
  `CURRENT_MAIN_NODE` int(11) DEFAULT NULL COMMENT '当前主流程节点',
  `CURRENT_CHILD_NODE` int(11) DEFAULT NULL COMMENT '当前子流程节点',
  `STATUS` char(1) DEFAULT NULL COMMENT '案件状态 ',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建者ID',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `REGISTER_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '立案时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL,
  `ACCEPT_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '接案时间（仲裁员接案时间）',
  `CURRENT_OWNER` varchar(32) DEFAULT NULL COMMENT '当前责任人，用户编号',
  `COMPLETE_TIME` timestamp NULL DEFAULT NULL COMMENT '结案时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_info` */

insert  into `case_info`(`ID`,`CASE_NO`,`ACCEPTANCE_NO`,`CASE_TYPE_ID`,`CURRENT_MAIN_NODE`,`CURRENT_CHILD_NODE`,`STATUS`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_TIME`,`REGISTER_TIME`,`UPDATE_ID`,`ACCEPT_TIME`,`CURRENT_OWNER`,`COMPLETE_TIME`) values ('1','SA888888','SA666666',1,1,2,NULL,'1','2017-11-13 19:44:58','2017-11-13 19:44:58','2017-11-13 19:44:58','','2017-11-13 19:44:58',NULL,NULL),('2','SA123456','SA654321',1,7,2,NULL,'1','2017-11-15 11:50:31','2017-11-15 11:50:31','2017-11-15 11:50:31','','2017-11-15 11:50:31','',NULL),('3','SA999999','SA999988',1,1,2,NULL,'1','2017-11-11 20:00:21','2017-11-11 20:00:21','2017-11-11 20:00:21','','2017-11-11 20:00:21','',NULL),('4',NULL,'5',1,1,2,NULL,'1','2017-11-13 22:42:58','2017-11-13 22:43:02',NULL,NULL,NULL,NULL,NULL),('5','SA3847583','6',1,4,NULL,NULL,'1','2017-11-16 11:40:36','2017-11-16 11:40:39',NULL,NULL,NULL,NULL,NULL),('CASE20171111185391902042',NULL,'SA20171111185391902043',1,2,NULL,NULL,'1','2017-11-11 18:53:11',NULL,NULL,NULL,NULL,NULL,NULL),('CASE20171111185391908734',NULL,NULL,1,2,2,NULL,'1','2017-11-13 18:07:52','2017-11-13 18:08:19','2017-11-13 18:08:23',NULL,NULL,NULL,NULL),('CASE20171111185591902044',NULL,'SA20171111185591902045',1,2,NULL,NULL,'1','2017-11-11 18:55:19',NULL,NULL,NULL,NULL,NULL,NULL),('CASE20171113103989408820',NULL,'SA20171113103989408821',1,2,NULL,NULL,'1','2017-11-13 10:39:10',NULL,NULL,NULL,NULL,'1',NULL),('CASE20171113103989408822',NULL,'SA20171113103989408823',1,2,NULL,NULL,'1','2017-11-13 10:39:23',NULL,NULL,NULL,NULL,'1',NULL),('CASE20171115132057560779',NULL,'SA20171115132057560780',1,2,NULL,NULL,'2','2017-11-15 13:20:22',NULL,NULL,NULL,NULL,'1',NULL),('CASE20171115141357560781',NULL,'SA20171115141357560782',1,2,NULL,NULL,'2','2017-11-15 14:13:35',NULL,NULL,NULL,NULL,'3',NULL),('CASE20171115155942008532',NULL,'SA20171115155942008533',1,2,NULL,NULL,'2','2017-11-15 15:59:55',NULL,NULL,NULL,NULL,'5',NULL),('CASE20171115162371345962',NULL,'SA20171115162371345963',1,2,NULL,NULL,'2','2017-11-15 16:23:39',NULL,NULL,NULL,NULL,'4',NULL);

/*Table structure for table `case_juris_dis` */

DROP TABLE IF EXISTS `case_juris_dis`;

CREATE TABLE `case_juris_dis` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `REASON` varchar(600) DEFAULT NULL COMMENT '理由',
  `JURIS_ID` varchar(32) DEFAULT NULL COMMENT '异议人ID',
  `COUNTERCLAIM_FLAG` char(1) DEFAULT NULL COMMENT '请求标志，0-正请求，1-反请求',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态。0-待审核，1-审核通过，2-审核未通过',
  `FAIL_REASON` varchar(600) DEFAULT NULL COMMENT '失败原因',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='案件管辖权异议记录表';

/*Data for the table `case_juris_dis` */

insert  into `case_juris_dis`(`ID`,`CASE_ID`,`REQUEST_ID`,`REASON`,`JURIS_ID`,`COUNTERCLAIM_FLAG`,`STATUS`,`FAIL_REASON`,`CREATER_ID`,`CREATE_TIME`) values (1,'1',1,'2222222222','2','0',NULL,NULL,'2','2017-11-14 21:59:53'),(2,'2',3,'异议内容','2','0','0',NULL,'2','2017-11-14 21:59:53'),(3,'2',4,'异议内容','2','1','0',NULL,'2','2017-11-14 21:59:53'),(4,'5',21,'不属于该法院仲裁','6','0','0',NULL,'2','2017-11-16 11:51:28');

/*Table structure for table `case_manager` */

DROP TABLE IF EXISTS `case_manager`;

CREATE TABLE `case_manager` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件id',
  `MANAGER_ID` varchar(32) DEFAULT NULL COMMENT '仲裁委工作人员ID',
  `MANAGER_TYPE` char(1) DEFAULT NULL COMMENT '工作人员身份 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 0-有效，1-回避',
  `REMARK` varchar(512) DEFAULT NULL COMMENT '备注',
  `CREATE_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_manager` */

insert  into `case_manager`(`ID`,`CASE_ID`,`MANAGER_ID`,`MANAGER_TYPE`,`STATUS`,`REMARK`,`CREATE_ID`,`CREATE_TIME`) values (2,'2','2','0','0',NULL,NULL,'2017-11-11 20:09:14'),(3,'CASE20171111185391908734','2','0','0',NULL,NULL,'2017-11-13 18:16:00'),(4,'CASE20171111185391908734','3','0','0',NULL,NULL,'2017-11-14 10:33:49'),(8,'1','4','2','0',NULL,'999999','2017-11-14 13:39:51'),(9,'CASE20171115132057560779','1','2','0',NULL,'999999','2017-11-15 13:24:08'),(10,'CASE20171115141357560781','3','2','0',NULL,'999999','2017-11-15 14:17:21'),(11,'CASE20171115155531415925','5','2','0',NULL,'999999','2017-11-15 15:59:24'),(12,'CASE20171115155942008532','5','2','0',NULL,'999999','2017-11-15 16:03:42'),(13,'CASE20171115162371345962','4','2','0',NULL,'999999','2017-11-15 16:27:25'),(14,'CASE20171115182119589325','1','2','0',NULL,'999999','2017-11-15 18:25:36'),(15,'CASE20171115182119589327','3','2','0',NULL,'999999','2017-11-15 18:25:40'),(16,'CASE20171115182219589329','3','2','0',NULL,'999999','2017-11-15 18:25:49'),(17,'5','7','0','0',NULL,NULL,NULL),(18,'5','8','1','0',NULL,NULL,NULL),(19,'5','9','2','0',NULL,NULL,NULL),(20,'5','10','3','0',NULL,NULL,NULL),(21,'5','11','4','0',NULL,NULL,'2017-11-16 12:03:28');

/*Table structure for table `case_mat` */

DROP TABLE IF EXISTS `case_mat`;

CREATE TABLE `case_mat` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `ATTACH_NAME` varchar(128) DEFAULT NULL COMMENT '附件名称',
  `MAT_TYPE` char(1) DEFAULT NULL COMMENT '材料类型 0-附件，1-证据，2-委托代理人材料',
  `NODE_ID` int(11) DEFAULT NULL COMMENT '节点ID',
  `EVIDENCE_MAT` varchar(128) DEFAULT NULL COMMENT '证据材料',
  `PURPOSE_EVIDENCE` varchar(256) DEFAULT NULL COMMENT '证据目的',
  `SOURCE_EVIDENCE` varchar(256) DEFAULT NULL COMMENT '证据来源',
  `DOC_NAME` varchar(128) DEFAULT NULL COMMENT '文件吗',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `FILE_ID` varchar(32) DEFAULT NULL COMMENT '文件ID',
  `DOC_TYPE` varchar(128) DEFAULT NULL COMMENT '文件类型后缀名',
  `REQUEST_ID` int(11) DEFAULT NULL,
  `COUNTERCLAIM_FLAG` char(1) DEFAULT NULL,
  `ATTACH_CONTENT` text COMMENT '附件内容',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_mat` */

insert  into `case_mat`(`ID`,`CASE_ID`,`ATTACH_NAME`,`MAT_TYPE`,`NODE_ID`,`EVIDENCE_MAT`,`PURPOSE_EVIDENCE`,`SOURCE_EVIDENCE`,`DOC_NAME`,`REMARK`,`FILE_ID`,`DOC_TYPE`,`REQUEST_ID`,`COUNTERCLAIM_FLAG`,`ATTACH_CONTENT`) values (1,'1','正请求附件','0',0,'',NULL,NULL,'正请求附件文件名',NULL,'正请求附件文件ID','正请求附件文件类型',NULL,'0','正请求附件1内容'),(2,'1','正请求附件','0',0,'',NULL,NULL,'正请求附件文件名2',NULL,'正请求附件文件ID2','正请求附件文件类型2',NULL,'0','正请求附件2内容'),(3,'1','','1',0,'正请求证据材料','正请求证据目的','正请求来源','正请求证据文件名',NULL,'正请求证据文件ID1','正请求证据文件名',NULL,'0',NULL),(4,'1',NULL,'1',0,'正请求证据材料2','正请求证据目的2','正请求来源2','正请求证据文件名2',NULL,'正请求证据文件ID2','正请求证据文件名2',NULL,'0',NULL),(5,'1','反请求附件','0',0,'',NULL,NULL,'1',NULL,NULL,NULL,NULL,'1','反请求附件1内容'),(6,'1','','1',0,'反请求证据材料','反请求证据目的','反请求来源','反请求证据文件名',NULL,NULL,NULL,NULL,'1','反请求附件1内容'),(7,'1',NULL,'2',0,'1',NULL,NULL,'3',NULL,NULL,NULL,NULL,'0',NULL),(8,'1',NULL,'3',0,'1',NULL,NULL,'4',NULL,NULL,NULL,NULL,'0',NULL),(9,'2',NULL,'1',NULL,'证据材料','证据目的','证据来源','证据文件名',NULL,'2',NULL,6,'0',NULL),(10,'2','附件1','0',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,6,'0','附件1内容'),(11,'2',NULL,'1',NULL,'证据材料','证据目的','证据来源','证据文件名',NULL,'2',NULL,7,'0',NULL),(12,'2','附件1','0',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,7,'0','附件1内容'),(13,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',8,'0',NULL),(14,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',8,'0','附件内容'),(15,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',9,'0',NULL),(16,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',9,'0','附件内容'),(17,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',17,'0',NULL),(18,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',17,'0','附件内容'),(19,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',18,'0',NULL),(20,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',18,'0','附件内容'),(21,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',19,'0',NULL),(22,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',19,'0','附件内容'),(23,'2','律师材料','3',0,'律师材料','律师材料','律师材料','律师材料.doc',NULL,'2','doc',19,'0','律师材料'),(24,'2','律师材料','3',0,'律师材料','律师材料','律师材料','律师材料.doc',NULL,'2','doc',19,'1','律师材料'),(25,'CASE20171115162371345962',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',20,'0',NULL),(26,'CASE20171115162371345962','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',20,'0','附件内容'),(27,'2','答辩证据.doc','2',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',19,'0','附件内容'),(30,'2','答辩证据.doc','2',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',19,'1','附件内容'),(31,'2','律师材料','3',0,'律师材料','律师材料','律师材料','律师材料.doc',NULL,'2','doc',19,'0','律师材料'),(32,'2','律师材料','3',0,'律师材料','律师材料','律师材料','律师材料.doc',NULL,'2','doc',19,'1','律师材料'),(33,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',19,'1','附件内容'),(34,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',19,'1',NULL),(35,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',18,'1','附件内容'),(36,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',18,'1',NULL),(37,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',17,'1','附件内容'),(38,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',17,'1',NULL),(39,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',9,'1','附件内容'),(40,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',9,'1',NULL),(41,'2','附件名称.doc','0',NULL,NULL,NULL,NULL,NULL,NULL,'1','doc',8,'1','附件内容'),(42,'2',NULL,'1',NULL,'附件材料','附件目的','证据来源','证据.doc',NULL,'2','doc',8,'1',NULL),(43,'2','附件1','0',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,7,'1','附件1内容'),(44,'2',NULL,'1',NULL,'证据材料','证据目的','证据来源','证据文件名',NULL,'2',NULL,7,'1',NULL),(45,'2','附件1','0',NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,6,'1','附件1内容'),(46,'2',NULL,'1',NULL,'证据材料','证据目的','证据来源','证据文件名',NULL,'2',NULL,6,'1',NULL);

/*Table structure for table `case_node` */

DROP TABLE IF EXISTS `case_node`;

CREATE TABLE `case_node` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `NODE_NAME` varchar(128) DEFAULT NULL COMMENT '节点名',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 0-正常，1-不可用',
  `TYPE` char(1) DEFAULT NULL COMMENT '0-主流程节点，1-子流程节点',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_node` */

insert  into `case_node`(`ID`,`NODE_NAME`,`STATUS`,`TYPE`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_TIME`) values (1,'申请立案','0','0','admin','2017-11-07 19:48:22',NULL),(2,'立案审核','0','0','admin','2017-11-07 19:48:22',NULL),(3,'缴费','0','0','admin','2017-11-07 19:48:22',NULL),(4,'答辩','0','0','admin','2017-11-07 19:48:22',NULL),(6,'等待确认仲裁员','0','0','admin','2017-11-07 19:48:22',NULL),(7,'审理出具裁决书','0','0','admin','2017-11-07 19:48:22',NULL),(8,'','0','0','admin','2017-11-13 20:40:39','2017-11-13 20:40:39'),(9,'结案','0','0','admin','2017-11-07 19:57:09',NULL),(10,'调解和解','0','1','admin','2017-11-13 20:38:10',NULL),(11,'变更仲裁请求','0','1','admin','2017-11-07 19:57:09',NULL),(12,'管辖权异议','0','1','admin','2017-11-07 19:57:09',NULL),(13,'反请求','0','1','admin','2017-11-07 19:57:09',NULL),(14,'反请求答辩','0','1','admin','2017-11-07 19:57:09',NULL),(15,'反请求管辖权异议','0','1','admin','2017-11-07 19:57:09',NULL),(16,'变更仲裁反请求','0','1','admin','2017-11-13 20:33:57','2017-11-13 20:33:57');

/*Table structure for table `case_node_oper` */

DROP TABLE IF EXISTS `case_node_oper`;

CREATE TABLE `case_node_oper` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `CASE_ID` varchar(255) DEFAULT NULL COMMENT '案件ID',
  `NODE_ID` int(11) DEFAULT NULL COMMENT '节点ID',
  `NEXT_NODE_ID` int(11) DEFAULT NULL COMMENT '流转节点ID',
  `OPER_RECORD` varchar(256) DEFAULT NULL COMMENT '操作记录',
  `BUSS_ID` varchar(32) DEFAULT NULL COMMENT '包括缴费ID，审批ID',
  `DEAL_STATUS` char(1) DEFAULT NULL COMMENT '0-初始，1-成功，2-失败，3-终止',
  `START_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `PLAN_END_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '计划结束时间',
  `REAL_END_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '操作人ID',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_node_oper` */

insert  into `case_node_oper`(`ID`,`REQUEST_ID`,`CASE_ID`,`NODE_ID`,`NEXT_NODE_ID`,`OPER_RECORD`,`BUSS_ID`,`DEAL_STATUS`,`START_TIME`,`PLAN_END_TIME`,`REAL_END_TIME`,`CREATER_ID`,`CREATE_TIME`) values (1,NULL,'1',1,2,'申请人提交立案申请',NULL,'1','2017-11-13 10:18:24','2017-11-13 10:18:24','2017-11-13 10:18:24',NULL,'2017-03-12 00:00:00'),(2,NULL,'1',2,3,'申请人缴费成功',NULL,'1','2017-11-14 20:14:43','2017-11-14 20:14:43','2017-11-14 20:14:43',NULL,'2017-11-14 20:14:43'),(3,NULL,'1',3,4,'申请人选择仲裁员',NULL,'1','2017-11-13 16:12:52','2017-11-13 16:12:52','2017-11-13 16:12:52',NULL,'2017-03-13 16:11:39'),(4,NULL,'1',13,3,'被申请人提交立案申请',NULL,'1','2017-11-13 20:01:48','2017-11-13 20:01:48','2017-11-13 20:01:48',NULL,'2017-11-13 20:01:48'),(5,NULL,'CASE20171111185391908734',1,2,'申请人提交立案申请',NULL,'1','2017-11-13 20:15:39','2017-11-13 20:19:19','2017-11-13 20:19:19',NULL,'2017-11-13 20:19:19'),(6,NULL,'CASE20171111185391908734',2,3,'申请人缴费成功',NULL,'1','2017-11-13 20:22:33','2017-11-15 20:18:51','2017-11-13 20:22:33',NULL,'2017-11-13 20:22:33'),(7,NULL,'CASE20171111185391908734',3,4,'开始答辩',NULL,'1','2017-11-13 20:22:44','2017-11-15 20:22:28','2017-11-13 20:22:44',NULL,'2017-11-13 20:22:44'),(8,NULL,'CASE20171111185391908734',4,5,'等待确认仲裁员',NULL,'1','2017-11-13 20:23:44','2017-11-13 20:20:03','2017-11-13 20:23:44',NULL,'2017-11-13 20:23:44'),(9,NULL,'CASE20171111185391908734',6,7,'审理出具裁决书',NULL,'1','2017-11-13 20:24:55','2017-11-13 20:24:55','2017-11-13 20:24:55',NULL,'2017-11-13 20:24:55');

/*Table structure for table `case_pay_order` */

DROP TABLE IF EXISTS `case_pay_order`;

CREATE TABLE `case_pay_order` (
  `ID` varchar(32) NOT NULL COMMENT '主键id',
  `ORDER_NO` varchar(32) DEFAULT NULL COMMENT '订单号',
  `CASE_ID` varchar(11) DEFAULT NULL COMMENT '案件ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `CHANGE_ID` int(11) DEFAULT NULL,
  `PAY_ACCOUNT` varchar(600) DEFAULT NULL COMMENT '变更请求ID',
  `STATUS` char(1) DEFAULT '' COMMENT '状态 0-待支付 1-支付成功 2支付失败',
  `AMOUNT` decimal(8,2) DEFAULT NULL COMMENT '金额',
  `PAY_TYPE` char(255) DEFAULT NULL COMMENT '支付方式',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_pay_order` */

/*Table structure for table `case_proposer` */

DROP TABLE IF EXISTS `case_proposer`;

CREATE TABLE `case_proposer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件',
  `PROP_NAME` varchar(128) DEFAULT NULL COMMENT '申请人名称',
  `CARD_ID` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `ADDRESS` varchar(128) DEFAULT NULL COMMENT '住址',
  `PHONE` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `CARD_IMAGE_FRONT` varchar(32) DEFAULT NULL COMMENT '身份证正面照',
  `CARD_IMAGE_CON` varchar(32) DEFAULT NULL COMMENT '身份证反面照',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `BIRTHDAY` varchar(8) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `PROP_TYPE` char(1) DEFAULT NULL,
  `CERT_NAME` varchar(32) DEFAULT NULL,
  `CERT_DUTIES` varchar(32) DEFAULT NULL,
  `UNIFIED_SOCIAL_CODE` varchar(32) DEFAULT NULL,
  `ETHNIC` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_proposer` */

insert  into `case_proposer`(`ID`,`CASE_ID`,`PROP_NAME`,`CARD_ID`,`ADDRESS`,`PHONE`,`CARD_IMAGE_FRONT`,`CARD_IMAGE_CON`,`CREATER_ID`,`CREATE_TIME`,`BIRTHDAY`,`SEX`,`EMAIL`,`PROP_TYPE`,`CERT_NAME`,`CERT_DUTIES`,`UNIFIED_SOCIAL_CODE`,`ETHNIC`) values (1,'1','徐奕豪','441521199802138213','广东省汕尾市海丰县88888','18523234544','',NULL,NULL,'2017-11-14 11:54:20','20170807','男','yihaoxu1998@gmail.com','0','','','','汉族'),(2,'2','徐奕豪','441521199802138213','广东省汕尾市海丰县88888','13148726005',NULL,NULL,NULL,'2017-11-09 15:49:20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'3','徐奕豪','441521199802138213','广东省汕尾市海丰县88888','13148726005',NULL,NULL,NULL,'2017-11-09 15:51:08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'CASE20171111185391902042','徐奕豪','441521199802138213','11111111','徐奕豪',NULL,NULL,'1','2017-11-11 18:53:11',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(5,'CASE20171111185591902044','徐奕豪','441521199802138216','广东省汕尾市海丰县附城镇','13148726005',NULL,NULL,'1','2017-11-11 18:55:19','19980213','男','1441315275@qq.com','0',NULL,NULL,NULL,'汉族'),(6,'CASE20171113103989408820','徐奕豪','441521199802138213','11111111','徐奕豪',NULL,NULL,'1','2017-11-13 10:39:10',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(7,'CASE20171113103989408822','徐奕豪','441521199802138216','广东省汕尾市海丰县','13148726005',NULL,NULL,'1','2017-11-13 10:39:23','19980213','男','yihaoxu1998@gmail.com','0','徐奕豪','COO','SAF132213','汉族'),(8,'CASE20171111185391908734','徐奕豪','441221199802138216','11111','13148726005',NULL,NULL,'1','2017-11-13 18:09:34','19980213','男',NULL,'0','徐奕豪','COO',NULL,NULL),(9,'CASE20171115132057560779','徐奕豪2','441521199802138213','11111111','侯龙',NULL,NULL,'2','2017-11-15 13:20:22',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(10,'CASE20171115141357560781','徐奕豪2','441521199802138213','11111111','侯龙',NULL,NULL,'2','2017-11-15 14:13:35',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(11,'CASE20171115155942008532','徐奕豪2','441521199802138213','11111111','侯龙',NULL,NULL,'2','2017-11-15 15:59:55',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(12,'CASE20171115162371345962','徐奕豪2','441521199802138213','11111111','侯龙',NULL,NULL,'2','2017-11-15 16:23:39',NULL,'女',NULL,'0',NULL,NULL,NULL,NULL),(13,'5','李MM','441521199802138213','湖南省','13838384381',NULL,NULL,'2','2017-11-16 11:54:45',NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL),(15,'20','德玛西亚',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `case_rejoin_record` */

DROP TABLE IF EXISTS `case_rejoin_record`;

CREATE TABLE `case_rejoin_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求ID',
  `REJOIN_TEXT` text COMMENT '答辩内容',
  `REJOIN_ID` varchar(32) DEFAULT NULL COMMENT '答辩人ID',
  `COUNTERCLAIM_FLAG` char(1) DEFAULT NULL COMMENT '请求标志，0- 正请求，1-反请求',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人ID',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_rejoin_record` */

insert  into `case_rejoin_record`(`ID`,`CASE_ID`,`REQUEST_ID`,`REJOIN_TEXT`,`REJOIN_ID`,`COUNTERCLAIM_FLAG`,`STATUS`,`CREATER_ID`,`CREATE_TIME`) values (1,'1',1,'正请求答辩','1','0',NULL,'1','2017-11-09 15:13:14'),(2,'1',2,'反请求答辩','1','1',NULL,'1','2017-11-09 15:13:14'),(3,'2',4,'反请求答辩','1','1',NULL,'1','2017-11-09 15:13:14'),(4,'2',3,'正请求答辩','1','0',NULL,'1','2017-11-09 15:13:14');

/*Table structure for table `case_request_info` */

DROP TABLE IF EXISTS `case_request_info`;

CREATE TABLE `case_request_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案号',
  `ACCEPTANCE_NO` varchar(32) DEFAULT NULL COMMENT '受案号',
  `REQUEST_TYPE` char(1) DEFAULT NULL COMMENT '请求类型，0-本请求，1-反请求',
  `AGENT_FLAG` char(1) DEFAULT NULL COMMENT '代理标志',
  `ARB_CLAIM` longtext COMMENT '仲裁请求',
  `FACT` longtext COMMENT '事实',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '收案时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` timestamp NULL DEFAULT NULL,
  `DELAYED_REPLY` char(1) DEFAULT NULL COMMENT '0-未延期答辩，1-延期答辩',
  `REASON` longtext COMMENT '理由',
  `CASE_AMOUNT` decimal(16,2) DEFAULT NULL COMMENT '涉案金额',
  `CASE_ADMISSIBLE_AMOUNT` decimal(16,2) DEFAULT NULL COMMENT '受理费',
  `CASE_HANDLING_AMOUNT` decimal(16,2) DEFAULT NULL COMMENT '处理费',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='案件请求基本信息表';

/*Data for the table `case_request_info` */

insert  into `case_request_info`(`ID`,`CASE_ID`,`ACCEPTANCE_NO`,`REQUEST_TYPE`,`AGENT_FLAG`,`ARB_CLAIM`,`FACT`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_TIME`,`DELAYED_REPLY`,`REASON`,`CASE_AMOUNT`,`CASE_ADMISSIBLE_AMOUNT`,`CASE_HANDLING_AMOUNT`) values (1,'1','SA666666','0','1','1','正请求仲裁申请事实与理由','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'1','SA666666','1','1','2','反请求仲裁申请事实与理由',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2','SA654321','0','0','3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'2','SA654321','1','0','4',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'3','SA999988','0','0','5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'CASE20171111185391902042','SA20171111185391902043','0','0','仲裁请求','事实与理由','1','2017-11-11 18:53:11',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'CASE20171111185591902044','SA20171111185591902045','0','1','仲裁请求','事实与理由','1','2017-11-11 18:55:19',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'CASE20171113103989408820','SA20171113103989408821','0','0','仲裁请求','事实与理由','1','2017-11-13 10:39:10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'CASE20171113103989408822','SA20171113103989408823','0','1','仲裁请求','事实与理由','1','2017-11-13 10:39:23',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'4','5','0','1','仲裁请求','事实与理由','1','2017-11-13 22:43:35',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'CASE20171115132057560779','SA20171115132057560780','0','0','仲裁请求','事实与理由','2','2017-11-15 13:20:22',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(18,'CASE20171115141357560781','SA20171115141357560782','0','0','仲裁请求','事实与理由','2','2017-11-15 14:13:35',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'CASE20171115155942008532','SA20171115155942008533','0','0','仲裁请求','事实与理由','2','2017-11-15 15:59:55',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'CASE20171115162371345962','SA20171115162371345963','0','0','仲裁请求','事实与理由','2','2017-11-15 16:23:39',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'5','6','0','0','仲裁请求','仲裁本案件','2','2017-11-16 11:47:28',NULL,NULL,NULL,NULL,'20000.00','2000.00','1000.00'),(22,'20',NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `case_time_set` */

DROP TABLE IF EXISTS `case_time_set`;

CREATE TABLE `case_time_set` (
  `ID` varchar(32) DEFAULT NULL,
  `NODE_ID` int(11) DEFAULT NULL,
  `TIME_SET` bigint(20) DEFAULT NULL,
  `REMARK` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `case_time_set` */

/*Table structure for table `compromise_record` */

DROP TABLE IF EXISTS `compromise_record`;

CREATE TABLE `compromise_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `SENDER_TYPE` char(1) DEFAULT NULL COMMENT '发送方类型。0- 申请人,1- 被申请人,2- 仲裁秘书-3 仲裁员',
  `CONTENT` text COMMENT '内容',
  `CONTENT_TYPE` char(1) DEFAULT NULL COMMENT '调节类型 0-和解 1-调解',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='和解记录表';

/*Data for the table `compromise_record` */

insert  into `compromise_record`(`ID`,`CASE_ID`,`SENDER_TYPE`,`CONTENT`,`CONTENT_TYPE`,`CREATER_ID`,`CREATE_TIME`) values (1,'1','1','内容',NULL,'1','2017-11-10 11:53:34'),(2,'1','0','内容',NULL,'1','2017-11-13 17:47:19'),(3,'CASE20171111185391908734','0','我们和解吧',NULL,'1','2017-11-13 18:14:29'),(4,'CASE20171111185391908734','1','不和解',NULL,'1','2017-11-13 18:14:41'),(5,'CASE20171111185391908734','2','和解挺好的',NULL,'1','2017-11-13 18:15:01'),(6,'CASE20171111185391908734','2','你们达成了和解',NULL,'2','2017-11-15 11:48:33');

/*Table structure for table `litigant_agent` */

DROP TABLE IF EXISTS `litigant_agent`;

CREATE TABLE `litigant_agent` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT '编号',
  `LITIGANT_ID` varchar(32) DEFAULT NULL COMMENT '当事人ID',
  `AGENT_ID` varchar(32) DEFAULT NULL COMMENT '代理人ID',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 0-正常，1-注销',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_DATE` varchar(8) DEFAULT NULL,
  `CREATE_TIME` varchar(6) DEFAULT NULL,
  `UPDATE_ID` varchar(32) DEFAULT NULL,
  `UPDATE_DATE` varchar(8) DEFAULT NULL,
  `UPDATE_TIME` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `litigant_agent` */

insert  into `litigant_agent`(`ID`,`LITIGANT_ID`,`AGENT_ID`,`STATUS`,`CREATER_ID`,`CREATE_DATE`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_DATE`,`UPDATE_TIME`) values ('1','1','2','0','1','2017-2-2','','',NULL,NULL),('15','15','2121',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('16','16','1212',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `litigant_info` */

DROP TABLE IF EXISTS `litigant_info`;

CREATE TABLE `litigant_info` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT '当事人ID',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `NAME` varchar(12) DEFAULT NULL,
  `VOCATION` varchar(256) DEFAULT NULL COMMENT '职业',
  `CARD_ID` int(11) DEFAULT NULL,
  `ADDRESS` varchar(256) DEFAULT NULL COMMENT '地址',
  `UNIFIED_SOCIAL_CODE` varchar(32) DEFAULT NULL COMMENT '统一社会征用码',
  `BUSI_IMG_ID` varchar(32) DEFAULT NULL COMMENT '营业执照照片ID',
  `CERT_OFFICE_IMG_ID` varchar(32) DEFAULT NULL COMMENT '法人代表任职证明照片地址',
  `TYPE` char(1) DEFAULT NULL COMMENT '类型',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL COMMENT '修改人',
  `UPDATE_TIME` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `BIRTHDAY` varchar(8) DEFAULT NULL,
  `CERT_DUTIES` varchar(32) DEFAULT NULL,
  `CERT_NAME` varchar(32) DEFAULT NULL,
  `ETHNIC` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='当事人基本信息表';

/*Data for the table `litigant_info` */

insert  into `litigant_info`(`ID`,`USER_ID`,`NAME`,`VOCATION`,`CARD_ID`,`ADDRESS`,`UNIFIED_SOCIAL_CODE`,`BUSI_IMG_ID`,`CERT_OFFICE_IMG_ID`,`TYPE`,`CREATER_ID`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_TIME`,`BIRTHDAY`,`CERT_DUTIES`,`CERT_NAME`,`ETHNIC`) values ('1','1','徐奕豪1','layer',11111111,'11111111',NULL,NULL,NULL,'0','1','2017-11-09 15:00:56',NULL,NULL,NULL,NULL,NULL,NULL),('15','20','狄仁杰',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('16','21','狄仁杰1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2','2','徐奕豪2','layer',11111111,'11111111',NULL,NULL,NULL,'0','1','2017-11-09 15:00:56',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `mail_record` */

DROP TABLE IF EXISTS `mail_record`;

CREATE TABLE `mail_record` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SUBJUCT` varchar(255) NOT NULL COMMENT '邮件标题',
  `CONTENT` longtext COMMENT '邮件内容',
  `ATTACHMENT` text COMMENT '邮件附件（ID 或 文件名）',
  `MAIL_TO` varchar(1024) NOT NULL COMMENT '接收者',
  `CC` varchar(1024) NOT NULL COMMENT '抄送',
  `STAUTS` int(1) NOT NULL DEFAULT '0' COMMENT '发送状态：0-发送中，1-成功，2-失败',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `BUZZ_ID` varchar(255) DEFAULT NULL COMMENT '业务ID（比如冗余 案件ID）',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `mail_record` */

insert  into `mail_record`(`ID`,`SUBJUCT`,`CONTENT`,`ATTACHMENT`,`MAIL_TO`,`CC`,`STAUTS`,`USER_ID`,`BUZZ_ID`,`CREATE_TIME`) values ('20171109165562333550','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 16:55:23.617000'),('20171109165877411831','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 16:58:02.516000'),('20171109165989472845','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 16:59:31.806000'),('20171109170090877025','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 17:00:18.855000'),('20171109182153044608','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 18:21:04.757000'),('20171109182253044609','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 18:22:58.936000'),('20171109185568153184','来自谭泉的测试邮件','请见附件',',E:\\仲裁平台表设计.zip,E:\\2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 18:55:59.972000'),('20171109220398925043','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 22:03:56.815000'),('20171109220790983198','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',0,NULL,NULL,'2017-11-09 22:07:59.186000'),('20171109221296894104','来自sonta的测试邮件','请见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 22:12:51.444000'),('20171109222423858555','来自谭泉的邮件','见附件',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 22:24:51.662000'),('20171109222823858556','来自谭泉的富文本邮件','<font color=\'red\'>测试富文本</font>',',仲裁平台表设计.zip,2016113016144800000803_20171107.txt','tan.quan@seata.cn','718001160@qq.com,tan.quan@ielpm.com',1,NULL,NULL,'2017-11-09 22:28:38.329000');

/*Table structure for table `manager_info` */

DROP TABLE IF EXISTS `manager_info`;

CREATE TABLE `manager_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `DUTIES` char(1) DEFAULT NULL COMMENT '职务 0-立案秘书，1-立案部长，2-仲裁秘书，3-仲裁部长，4-主任',
  `SPECIALTY` varchar(256) DEFAULT NULL COMMENT '专长',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 0-正常，1-注销',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建者ID',
  `CREATE_DATE` varchar(8) DEFAULT NULL COMMENT '创建日期',
  `CREATE_TIME` varchar(6) DEFAULT NULL COMMENT '创建时间',
  `UPDATE_ID` varchar(32) DEFAULT NULL COMMENT '编辑者ID',
  `UPDATE_DATE` varchar(8) DEFAULT NULL COMMENT '更新日期',
  `UPDATE_TIME` varchar(6) DEFAULT NULL COMMENT '更新时间',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `manager_info` */

insert  into `manager_info`(`ID`,`DUTIES`,`SPECIALTY`,`STATUS`,`CREATER_ID`,`CREATE_DATE`,`CREATE_TIME`,`UPDATE_ID`,`UPDATE_DATE`,`UPDATE_TIME`,`USER_ID`) values (1,'2','0','0','1',NULL,NULL,NULL,NULL,NULL,'1'),(2,'0','0','0','1',NULL,NULL,NULL,NULL,NULL,'2'),(3,'2','0','0','1',NULL,NULL,NULL,NULL,NULL,'3'),(4,'2','0','0','1',NULL,NULL,NULL,NULL,NULL,'4'),(5,'2','0','0','1',NULL,NULL,NULL,NULL,NULL,'5'),(8,'0','0','0','1',NULL,NULL,NULL,NULL,NULL,'7'),(9,'1','0','0','1',NULL,NULL,NULL,NULL,NULL,'8'),(10,'2','0','0','1',NULL,NULL,NULL,NULL,NULL,'9'),(11,'3','0','0','1',NULL,NULL,NULL,NULL,NULL,'10'),(12,'4','0','0','1',NULL,NULL,NULL,NULL,NULL,'11');

/*Table structure for table `message_record` */

DROP TABLE IF EXISTS `message_record`;

CREATE TABLE `message_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(256) DEFAULT NULL,
  `MESSAGE_BODY` text NOT NULL,
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `RELEASE_TYPE` char(1) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `message_record` */

insert  into `message_record`(`ID`,`TITLE`,`MESSAGE_BODY`,`CREATER_ID`,`RELEASE_TYPE`,`CREATE_TIME`) values (7,'小胖1','1233','1',NULL,'2017-11-07 19:12:22'),(8,'小胖1','1233','1',NULL,'2017-11-07 19:42:30'),(9,'小胖1','1233','1',NULL,'2017-11-07 19:45:14'),(10,'小胖1','1233','1',NULL,'2017-11-07 19:58:49'),(11,'小胖1','1233','1',NULL,'2017-11-07 20:39:52'),(12,'小胖1','1233',NULL,NULL,NULL);

/*Table structure for table `message_user` */

DROP TABLE IF EXISTS `message_user`;

CREATE TABLE `message_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MESSAGE_ID` int(11) NOT NULL COMMENT '消息id',
  `USER_ID` varchar(32) NOT NULL,
  `STATUS` char(1) NOT NULL DEFAULT '0' COMMENT '消息状态 0-未读 1-已读',
  `DEL_FLAG` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志 0-未删除 1-已删除',
  `CREATER_ID` varchar(32) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='消息用户关联表';

/*Data for the table `message_user` */

insert  into `message_user`(`ID`,`MESSAGE_ID`,`USER_ID`,`STATUS`,`DEL_FLAG`,`CREATER_ID`,`CREATE_TIME`) values (2,7,'1','1','0','1','2017-11-07 19:12:22'),(3,10,'1','0','0','1','2017-11-07 19:58:49'),(4,10,'2','0','1','1','2017-11-07 19:58:49'),(6,11,'1','1','0','1','2017-11-07 20:39:52'),(7,11,'2','0','1','1','2017-11-07 20:39:52'),(9,12,'1','0','0','1',NULL);

/*Table structure for table `pay_order` */

DROP TABLE IF EXISTS `pay_order`;

CREATE TABLE `pay_order` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `RECEIVABLE_AMT` decimal(30,0) NOT NULL COMMENT '应收总金额（元）',
  `ITEMS` longtext NOT NULL COMMENT '收费项[{''no'':''收费项目编号'',''price'':''单价（元）'',''quantity'':''数量''}]',
  `UNIT_NO` varchar(255) DEFAULT NULL COMMENT '客户端执收单位编码',
  `PN_NO` varchar(255) DEFAULT NULL COMMENT '客户端执收单位收费系统产生的通知书号码',
  `PAYER_NAME` varchar(255) DEFAULT NULL COMMENT '缴费单位/人名称',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CHECK_DIGIT_NO` varchar(255) DEFAULT NULL COMMENT '号码校验码',
  `CHECK_DIGIT_ALL` varchar(255) DEFAULT NULL COMMENT '全书校验码',
  `CHARGE_ITEM_COUNT` int(5) DEFAULT NULL COMMENT '收费项目数',
  `CHANNEL_VOUCHER_NO` varchar(255) DEFAULT NULL COMMENT '渠道追踪单号',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID ',
  `BUZZ_ID` varchar(255) DEFAULT NULL COMMENT '业务ID（冗余）',
  `STATUS` int(5) NOT NULL DEFAULT '0' COMMENT '订单状态：0-处理中，1-成功，2-失败，3-取消订单',
  `CANCEL_TIME` timestamp NULL DEFAULT NULL COMMENT '取消订单时间',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pay_order` */

/*Table structure for table `pay_rl_co` */

DROP TABLE IF EXISTS `pay_rl_co`;

CREATE TABLE `pay_rl_co` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SYNC_TYPE` int(1) DEFAULT NULL COMMENT '数据同步类型：1-新增，2-修改',
  `CO_NO` varchar(12) DEFAULT NULL COMMENT '单位编码',
  `PARENT_CO_NO` varchar(12) DEFAULT NULL COMMENT '上级单位编码',
  `CO_NAME` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `REGION_CODE` varchar(9) DEFAULT NULL COMMENT '所属区域编码',
  `REGION_NAME` varchar(100) DEFAULT NULL COMMENT '所属区域名称',
  `ADDR` varchar(100) DEFAULT NULL COMMENT '地址',
  `CONTACT_NAME` varchar(20) DEFAULT NULL COMMENT '联系人',
  `CONTACT_TEL` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `REMARK` varchar(500) DEFAULT NULL COMMENT '备注',
  `STATUS` int(1) DEFAULT NULL COMMENT '状态：0-禁用，1-启用',
  `SYNC_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '同步时间',
  PRIMARY KEY (`ID`),
  KEY `CO_NO_INDEX` (`CO_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='瑞联-单位信息表';

/*Data for the table `pay_rl_co` */

/*Table structure for table `pay_rl_items` */

DROP TABLE IF EXISTS `pay_rl_items`;

CREATE TABLE `pay_rl_items` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SYNC_TYPE` varchar(1) DEFAULT '1' COMMENT '数据同步类型：1－新增，2－修改，3－删除',
  `ITEM_NO` varchar(32) DEFAULT NULL COMMENT '项目编码',
  `ITEM_NAME` varchar(150) DEFAULT NULL COMMENT '项目名称',
  `MANANGER_TYPE` varchar(1) DEFAULT '1' COMMENT '管理方式：1–财政专户管理,2 –预算资金管理',
  `CHARGE_MAX` decimal(10,0) DEFAULT NULL COMMENT '收费标准上限（元）',
  `CHARGE_MIN` decimal(10,0) DEFAULT NULL COMMENT '收费标准下限（元）',
  `CHARGE_UNIT` varchar(50) DEFAULT NULL COMMENT '计量单位',
  `ITEM_TYPE_NO` varchar(2) DEFAULT NULL COMMENT '收费项目类别码',
  `ITEM_TYPE_NAME` varchar(50) DEFAULT NULL COMMENT '收费项目类别名称',
  `CHARGE_IN_ACCOUT` varchar(50) DEFAULT NULL COMMENT '收费项目缴入账号',
  `CHARGE_IN_BANK_CODE` varchar(14) DEFAULT NULL COMMENT '收费项目归属账号所属银行代码',
  `APPROVE_LEVEL` int(1) DEFAULT NULL COMMENT '批准级次',
  `APPROVE_NO` varchar(500) DEFAULT NULL COMMENT '批准文号',
  `IS_FREE` int(1) DEFAULT NULL COMMENT '是否减免收费',
  `BUDGET_SUBJECT_CODE` varchar(12) DEFAULT NULL COMMENT '预算科目外码',
  `BUDGET_SUBJECT_NAME` varchar(255) DEFAULT NULL COMMENT '预算科目名称',
  `CHARGE_TARGET` int(1) DEFAULT NULL COMMENT '收费对象',
  `CHARGE_TERM` int(10) DEFAULT NULL COMMENT '缴费期限',
  `LATE_FEE_RATE` decimal(10,0) DEFAULT NULL COMMENT '滞纳金率',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `SYNC_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '同步时间',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ITEM_NO_INDEX` (`ITEM_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='3.4.3 收费项目信息';

/*Data for the table `pay_rl_items` */

/*Table structure for table `pay_rl_region` */

DROP TABLE IF EXISTS `pay_rl_region`;

CREATE TABLE `pay_rl_region` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `REGION_CODE` varchar(20) NOT NULL COMMENT '区域代码',
  `REGION_NAME` varchar(255) NOT NULL COMMENT '区域名称',
  `SYNC_TYPE` varchar(1) DEFAULT NULL COMMENT '同步类型：1-新增，3-禁用',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pay_rl_region` */

/*Table structure for table `quiz_record` */

DROP TABLE IF EXISTS `quiz_record`;

CREATE TABLE `quiz_record` (
  `ID` int(11) DEFAULT NULL COMMENT '编号',
  `CASE_ID` varchar(32) DEFAULT NULL COMMENT '案件ID',
  `QUIZ_OBJECT` varchar(32) DEFAULT NULL COMMENT '提问对象',
  `QUIZ_CONTENT` text COMMENT '提问内容',
  `QUIZ_ANSWER` text COMMENT '提问回答',
  `RESPONDENT_ANSWER` text COMMENT '被申请人回答',
  `ANSWER_TIME` timestamp NULL DEFAULT NULL COMMENT '回答时间',
  `RESPONDENT_ANSWER_TIME` timestamp NULL DEFAULT NULL COMMENT '被申请人回答时间',
  `STATUS` char(1) DEFAULT NULL COMMENT '回答状态。0-待回答(草稿),1-已回答',
  `RESPONDENT_STATUS` char(1) DEFAULT NULL COMMENT '申请人回答状态。0-待回答(草稿),1-已回答',
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='提问记录表';

/*Data for the table `quiz_record` */

insert  into `quiz_record`(`ID`,`CASE_ID`,`QUIZ_OBJECT`,`QUIZ_CONTENT`,`QUIZ_ANSWER`,`RESPONDENT_ANSWER`,`ANSWER_TIME`,`RESPONDENT_ANSWER_TIME`,`STATUS`,`RESPONDENT_STATUS`,`CREATER_ID`,`CREATE_TIME`) values (1,'1','2','问题1','问题回答','被请求回答','2017-11-10 11:43:48','2017-11-10 11:43:51','0','1','2','2017-11-10 11:44:13');

/*Table structure for table `sms_record` */

DROP TABLE IF EXISTS `sms_record`;

CREATE TABLE `sms_record` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `PHONE_NO` varchar(20) NOT NULL COMMENT '手机号',
  `TPL_ID` varchar(32) NOT NULL COMMENT '短信模板编号',
  `TPL_CNT` text NOT NULL COMMENT '短信模板内容',
  `TPL_PARAMS` text COMMENT '短信模板参数',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `BUZZ_ID` varchar(32) DEFAULT NULL COMMENT '业务ID(冗余)',
  `CHANNEL_CODE` varchar(32) NOT NULL COMMENT '发送渠道编号',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '发送状态：0-发送中，1-成功，2-失败',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sms_record` */

insert  into `sms_record`(`ID`,`PHONE_NO`,`TPL_ID`,`TPL_CNT`,`TPL_PARAMS`,`USER_ID`,`BUZZ_ID`,`CHANNEL_CODE`,`STATUS`,`CREATE_TIME`) values ('20171108223330419387','15673237766','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'123123123','101',0,'2017-11-08 22:33:33.267000'),('20171113224747901423','1391234','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-13 22:47:26.725000'),('20171114095632419917','1391234','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 09:56:22.318000'),('20171114110092110476','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:00:22.034000'),('20171114111740968993','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:17:41.352000'),('20171114111840968994','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:18:38.649000'),('20171114111840968995','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:18:42.691000'),('20171114112428174746','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:24:26.508000'),('20171114113301850486','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:33:41.338000'),('20171114113970418895','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:39:54.961000'),('20171114114070418896','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:40:12.537000'),('20171114114170418897','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:41:22.062000'),('20171114114370418898','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:43:32.197000'),('20171114114370418899','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:43:45.924000'),('20171114114870418900','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 11:48:54.093000'),('20171114144190808880','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 14:41:54.392000'),('20171114144884424405','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 14:48:38.365000'),('20171114144984424406','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 14:49:33.749000'),('20171114144984424407','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 14:49:59.653000'),('20171114152084424408','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:20:09.859000'),('20171114152084424409','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:20:17.974000'),('20171114152184424410','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:21:59.035000'),('20171114152184424411','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:21:59.481000'),('20171114152384424412','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:23:16.288000'),('20171114153644479149','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:36:27.499000'),('20171114153644479150','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 15:36:34.360000'),('20171114162544479151','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 16:25:12.587000'),('20171114162544479152','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 16:25:36.613000'),('20171114163044479153','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 16:30:09.182000'),('20171114164355855348','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 16:43:35.123000'),('20171114170055855349','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 17:00:17.298000'),('20171114170055855350','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-14 17:00:25.278000'),('20171115103543849010','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 10:35:11.503000'),('20171115103643849011','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 10:36:56.837000'),('20171115103743849012','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 10:37:49.230000'),('20171115104969533899','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 10:49:12.664000'),('20171115151004570483','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 15:10:17.824000'),('20171115151004570484','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 15:10:42.940000'),('20171115155726806198','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 15:57:17.900000'),('20171115162740961964','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:27:39.401000'),('20171115163040961965','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:30:12.495000'),('20171115163040961966','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:30:56.873000'),('20171115163140961967','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:31:22.216000'),('20171115163440961968','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:34:09.325000'),('20171115163540961969','1','1001','您申请的验证码为{code}，{validMin}分钟内有效。如果短信非本人发出，请忽略。','{\"code\":\"345221\",\"validMin\":\"10\"}',NULL,'1','101',1,'2017-11-15 16:35:06.343000');

/*Table structure for table `sys_data_dic` */

DROP TABLE IF EXISTS `sys_data_dic`;

CREATE TABLE `sys_data_dic` (
  `DIC_KEY` varchar(32) NOT NULL COMMENT '字典key',
  `DIC_GROUP` varchar(32) NOT NULL COMMENT '字典key对应的分组',
  `DIC_VALUE` varchar(2048) NOT NULL COMMENT '字典key对应的值',
  `DIC_DESCR` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`DIC_KEY`,`DIC_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='系统配置数据字典表';

/*Data for the table `sys_data_dic` */

insert  into `sys_data_dic`(`DIC_KEY`,`DIC_GROUP`,`DIC_VALUE`,`DIC_DESCR`,`CREATE_TIME`,`UPDATE_TIME`) values ('CASE_ACCEPT_FEE_ITEM_KEY','PAY','10001','缴费通知书收费项-案件受理费项目编号',NULL,NULL),('CASE_SERVICE_FEE_ITEM_KEY','PAY','10002','缴费通知书收费项-案件服务费项目编号',NULL,NULL),('REGION_CODE','PAY','400400','缴费通知书-区域编码',NULL,NULL),('UNIT_NO','PAY','100000','缴费通知书-客户端执收单位编码',NULL,NULL);

/*Table structure for table `sys_file` */

DROP TABLE IF EXISTS `sys_file`;

CREATE TABLE `sys_file` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `FILE_ORIGN_NAME` varchar(244) NOT NULL COMMENT '文件原名',
  `FILE_SIZE` bigint(20) NOT NULL DEFAULT '0' COMMENT '文件大小',
  `FILE_EXT` varchar(10) NOT NULL COMMENT '文件后缀',
  `SYS_PATH` varchar(255) NOT NULL COMMENT '保存路径',
  `BUZZ_TYPE` varchar(255) DEFAULT 'common' COMMENT '文件用途（common通用）',
  `CREATE_ID` varchar(32) DEFAULT NULL COMMENT '创建用户ID',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETED_FLAG` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识：0-未删除，1-已删除',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文件数据表';

/*Data for the table `sys_file` */

insert  into `sys_file`(`ID`,`FILE_ORIGN_NAME`,`FILE_SIZE`,`FILE_EXT`,`SYS_PATH`,`BUZZ_TYPE`,`CREATE_ID`,`CREATE_TIME`,`UPDATE_TIME`,`DELETED_FLAG`) values ('16695def6993433c9ee9cfe507fe5742','仲裁平台表设计.zip',1165,'zip','1000000000000001\\C_0002\\zip\\16695def6993433c9ee9cfe507fe5742.zip','C_0002','1000000000000001','2017-11-10 11:05:17.639000',NULL,0),('2b04cadae39b46f085ae3041fb226631','网络仲裁原型1028.zip',8611249,'zip','1000000000000001/C_0002/zip/2b04cadae39b46f085ae3041fb226631.zip','C_0002','1000000000000001','2017-11-08 15:10:51.332000',NULL,0),('4102f0a97b9a45edb6e4c644ee7ad811','仲裁平台表设计.zip',1165,'zip','1000000000000001\\C_0002\\zip\\4102f0a97b9a45edb6e4c644ee7ad811.zip','C_0002','1000000000000001','2017-11-13 23:04:58.545000',NULL,0),('58a8f91fb84b463e9066767c46be7309','网络仲裁原型1028.zip',8611249,'zip','1000000000000001/C_0002/zip/58a8f91fb84b463e9066767c46be7309.zip','C_0002','1000000000000001','2017-11-08 15:09:39.254000',NULL,0),('59de162ef9f344e4ab7d6f74f580d2b1','网络仲裁原型1028.zip',8611249,'zip','1000000000000001/C_0002/zip/59de162ef9f344e4ab7d6f74f580d2b1.zip','C_0002','1000000000000001','2017-11-08 15:10:22.358000',NULL,0),('8051c4a590594fb3a2817505d23d8066','仲裁平台表设计.zip',1165,'zip','1000000000000001/C_0002/zip/8051c4a590594fb3a2817505d23d8066.zip','C_0002','1000000000000001','2017-11-08 15:04:45.090000',NULL,0),('bb657c3f963a4f5bb688c49e2e21c8bc','网络仲裁原型1028.zip',8611249,'zip','1000000000000001/C_0002/zip/bb657c3f963a4f5bb688c49e2e21c8bc.zip','C_0002','1000000000000001','2017-11-08 16:15:09.113000',NULL,0);

/*Table structure for table `sys_sequence` */

DROP TABLE IF EXISTS `sys_sequence`;

CREATE TABLE `sys_sequence` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SNAME` varchar(255) NOT NULL COMMENT '序列名称',
  `SMIN` int(8) NOT NULL DEFAULT '0' COMMENT '最小值',
  `SMAX` int(8) NOT NULL COMMENT '最大值',
  `SCURRENT` int(8) NOT NULL COMMENT '当前值',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_sequence` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `USER_NO` varchar(20) DEFAULT NULL COMMENT '用户编号',
  `USER_TYPE` int(2) DEFAULT '0' COMMENT '用户类型：0-用户端，1-管理员端',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名',
  `USER_PWD` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态：0-不可用，1-正常',
  `REGISTER_IP` varchar(50) NOT NULL COMMENT '注册IP',
  `LOGIN_TIMES` int(6) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `LAST_LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `LAST_LOGIN_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '最后登录时间',
  `LAST_SELECT_ROLE` int(2) NOT NULL DEFAULT '0' COMMENT '最后登录的身份：0-申请人，1-被申请人，2-代理人',
  `NICK_NAME` varchar(255) DEFAULT NULL COMMENT '昵称',
  `HEADPHOTO` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `LOGIN_TYPE` int(2) NOT NULL DEFAULT '0' COMMENT '登录类型：0-用户名，1-qq登录，2-微信登录，3-微博登录',
  `REAL_AUTH` int(5) NOT NULL DEFAULT '0' COMMENT '是否进行了实名认证：0-否，1-是',
  `PWD_WRONG_TIMES` int(5) DEFAULT '0' COMMENT '登录密码错误次数',
  `BELOCKED` int(5) NOT NULL DEFAULT '0' COMMENT '是否锁定：0-否，1-是）',
  `CURR_THIRD_OAUTH_ID` varchar(64) DEFAULT NULL COMMENT '当前登录的三方帐号关联ID',
  `CREATE_ID` varchar(32) DEFAULT NULL COMMENT '创建人ID',
  `UPDATE_ID` varchar(32) DEFAULT NULL COMMENT '更新人ID',
  `CREATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `DELETED_FLAG` int(1) NOT NULL DEFAULT '0' COMMENT '删除标识：0-未删除，1-已删除',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `SYS_USER_NAME_UNIQUE_INDEX` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户总表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`ID`,`USER_NO`,`USER_TYPE`,`USER_NAME`,`USER_PWD`,`STATUS`,`REGISTER_IP`,`LOGIN_TIMES`,`LAST_LOGIN_IP`,`LAST_LOGIN_TIME`,`LAST_SELECT_ROLE`,`NICK_NAME`,`HEADPHOTO`,`LOGIN_TYPE`,`REAL_AUTH`,`PWD_WRONG_TIMES`,`BELOCKED`,`CURR_THIRD_OAUTH_ID`,`CREATE_ID`,`UPDATE_ID`,`CREATE_TIME`,`UPDATE_TIME`,`DELETED_FLAG`) values ('1','1',1,'admin','$2a$10$dMzPvkjwc30Zqca8gWt05eGENaZFxuT/wfccqFUsnxwftBppmwtEe',1,'1',1,'1','2017-11-07 19:36:15.000000',1,'1','1',1,1,1,1,'1','1','1','2017-11-07 19:35:46.000000','2017-11-07 19:35:39.000000',1),('2','2',2,'2','684a4c09c79c1a5687de27a824523cea',2,'2',2,'2','2017-11-07 19:36:31.000000',2,'2','2',2,2,2,2,'2','2','2','2017-11-07 19:36:39.000000','2017-11-07 19:36:42.000000',2);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `ID` varchar(32) NOT NULL DEFAULT '',
  `PHONE` varchar(32) DEFAULT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `SEX` char(1) DEFAULT NULL,
  `CURRENT_ROLE` char(1) DEFAULT NULL,
  `OPENID` varchar(32) DEFAULT NULL,
  `CREATER_ID` varchar(32) DEFAULT NULL,
  `CREATE_DATE` varchar(8) DEFAULT NULL,
  `CREATE_TIME` varchar(6) DEFAULT NULL,
  `UPDATE_DATE` varchar(8) DEFAULT NULL,
  `UPDATE_TIME` varchar(6) DEFAULT NULL,
  `UPDATE_ID` varchar(32) DEFAULT NULL,
  `BANK_CARD` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `CARD_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_info` */

insert  into `user_info`(`ID`,`PHONE`,`NAME`,`SEX`,`CURRENT_ROLE`,`OPENID`,`CREATER_ID`,`CREATE_DATE`,`CREATE_TIME`,`UPDATE_DATE`,`UPDATE_TIME`,`UPDATE_ID`,`BANK_CARD`,`EMAIL`,`CARD_ID`) values ('1','18523234544','徐奕豪',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'441521199802138213'),('10','13838384381','仲裁部长',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('11','13838384381','主任',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('2','18566666666','侯龙',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'441521199802138213'),('3','18699999999','周慧杰',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'441521199802138213'),('4','18899999999','陈炎辉',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'441521199802138213'),('5','18288889999','吴潘',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'441521199802138213'),('6','13838384381','李MM',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('7','13838384381','立案秘书',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('8','13838384381','立案部长',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('9','13838384381','仲裁秘书',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `withdraw_record` */

DROP TABLE IF EXISTS `withdraw_record`;

CREATE TABLE `withdraw_record` (
  `ID` varchar(32) NOT NULL COMMENT '编号',
  `CASE_ID` varchar(600) DEFAULT NULL COMMENT '案件id',
  `REQUEST_ID` int(11) DEFAULT NULL COMMENT '请求id',
  `FACT` longtext COMMENT '事实',
  `REASON` longtext COMMENT '理由',
  `APPLICATION` longtext COMMENT '申请事项',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态  0-待生成  1-已生成',
  `CREATE_ID` varchar(32) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `withdraw_record` */

insert  into `withdraw_record`(`ID`,`CASE_ID`,`REQUEST_ID`,`FACT`,`REASON`,`APPLICATION`,`STATUS`,`CREATE_ID`,`CREATE_TIME`) values ('1','1',1,'欠我100','还了我90，还请我吃了一次中餐','撤回仲裁申请书','1','1','2017-11-13 12:12:12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
