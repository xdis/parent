# 博客主站-文章表
CREATE TABLE `blog_article` (
  `ART_ID` varchar(32) NOT NULL COMMENT '文章ID',
  `ART_NAME` varchar(255) NOT NULL COMMENT '文章标题',
  `ART_SHORT` varchar(255) DEFAULT NULL COMMENT '文章摘要',
  `ART_CONTENT` longtext COMMENT '文章内容',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '创建时间',
  `LAST_MODE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后修改时间',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1可用',
  `APPROVE_STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '审核状态：0待审核1审核通过-1审核失败',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `CORPUS_ID` varchar(32) NOT NULL COMMENT '所属文集编号',
  `READ_TIMES` int(8) NOT NULL DEFAULT '0' COMMENT '阅读次数',
  `COMMENT_TIMES` int(8) NOT NULL DEFAULT '0' COMMENT '评价次数',
  `ADMIRE_TIMES` int(8) NOT NULL DEFAULT '0' COMMENT '被赞次数',
  `PUBLISH_STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '0草稿1发布',
  `PUBLISH_TIME` timestamp NULL DEFAULT '2016-01-01 00:00:00' COMMENT '发布时间',
  `ART_SHORT_PIC` varchar(255) DEFAULT NULL COMMENT '文章摘要图片',
  `EDITOR_TYPE` int(1) NOT NULL DEFAULT '0' COMMENT '富文本编辑器类型：0summernot,1',
  `ART_ORI_CONTENT` longtext COMMENT '富文本转义之前的内容',
  PRIMARY KEY (`ART_ID`)
);

# 博客主站-文章标签表
CREATE TABLE `blog_article_tag` (
  `ART_ID` varchar(32) NOT NULL COMMENT '文章ID',
  `TAG_ID` varchar(32) NOT NULL COMMENT '文章标签ID',
  PRIMARY KEY (`ART_ID`,`TAG_ID`)
);

# 博客主站-文集表
CREATE TABLE `blog_corpus` (
  `COR_ID` varchar(32) NOT NULL COMMENT '文集编号',
  `COR_NAME` varchar(255) NOT NULL COMMENT '文集名称',
  `USER_ID` varchar(32) NOT NULL COMMENT '文集拥有者',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '创建时间',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1正常',
  `LAST_MOD_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后修改时间',
  PRIMARY KEY (`COR_ID`)
);

# 博客主站-资源表
CREATE TABLE `blog_resource` (
  `RES_ID` varchar(32) NOT NULL COMMENT '资源ID',
  `RES_NAME` varchar(255) NOT NULL COMMENT '资源名称',
  `P_RES_ID` varchar(32) NOT NULL COMMENT '父资源编号',
  `RES_TYPE` int(1) NOT NULL DEFAULT '1' COMMENT '资源类型：1菜单2按钮3数据',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1正常',
  `RES_INDEX` int(4) NOT NULL DEFAULT '1' COMMENT '显示顺序',
  `RES_URL` varchar(255) NOT NULL COMMENT '资源URL',
  `PERMISSION` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `RES_ICON` varchar(255) DEFAULT NULL COMMENT '资源图标',
  PRIMARY KEY (`RES_ID`)
);

# 博客主站-角色表
CREATE TABLE `blog_role` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(255) NOT NULL COMMENT '角色名称',
  `ROLE_CODE` varchar(255) NOT NULL COMMENT '角色代码',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1正常',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '创建时间',
  `LAST_MOD_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后修改时间',
  PRIMARY KEY (`ROLE_ID`)
);

# 博客主站-角色资源表
CREATE TABLE `blog_role_resource` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色编号',
  `RES_ID` varchar(32) NOT NULL COMMENT '资源编号',
  PRIMARY KEY (`ROLE_ID`,`RES_ID`)
);

# 博客主站-标签表
CREATE TABLE `blog_tag` (
  `TAG_ID` varchar(32) NOT NULL COMMENT '标签ID',
  `TAG_NAME` varchar(32) NOT NULL COMMENT '标签名',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  `INDEX` int(5) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`TAG_ID`)
);

# 博客主站-用户表
CREATE TABLE `blog_user` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户编号',
  `USER_TEL` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `USER_MAIL` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `USER_ACCOUNT` varchar(255) DEFAULT NULL COMMENT '用户自定义账号',
  `USER_PWD` varchar(64) NOT NULL COMMENT '用户密码',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态 0不可用1正常',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '注册时间',
  `REGISTER_IP` varchar(50) NOT NULL COMMENT '注册IP',
  `LOGIN_TIMES` int(6) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `LAST_LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `LAST_LOGIN_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后登录时间',
  `NICK_NAME` varchar(255) DEFAULT NULL COMMENT '昵称',
  `HEADPHOTO_URL` varchar(255) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`USER_ID`),
  KEY `USER_TEL_INDEX` (`USER_TEL`),
  KEY `USER_MAIL_INDEX` (`USER_MAIL`),
  KEY `USER_ACCOUNT_INDEX` (`USER_ACCOUNT`)
);

# 博客主站-用户配置表
CREATE TABLE `blog_user_config` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `CONFIG_KEY` varchar(255) NOT NULL COMMENT '键',
  `CONFIG_VALUE` varchar(255) NOT NULL COMMENT '值',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LAST_MOD_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  PRIMARY KEY (`USER_ID`,`CONFIG_KEY`)
);

# 博客主站-用户角色表
CREATE TABLE `blog_user_role` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户编号',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
);

# 后台管理系统-字典表
CREATE TABLE `s_data_dic` (
  `DIC_GROUP` varchar(50) NOT NULL COMMENT '字典分组',
  `DIC_KEY` varchar(50) NOT NULL COMMENT '字典名',
  `DIC_VALUE` varchar(2048) NOT NULL COMMENT '字典值',
  `DIC_DESC` varchar(255) DEFAULT NULL COMMENT '字典描述',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT '创建时间',
  `MOD_TIME` timestamp NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`DIC_GROUP`,`DIC_KEY`)
);

# 后台管理系统-资源表
CREATE TABLE `s_resource` (
  `RES_ID` varchar(32) NOT NULL COMMENT '资源ID',
  `RES_NAME` varchar(255) NOT NULL COMMENT '资源名称',
  `P_RES_ID` varchar(32) NOT NULL COMMENT '父资源编号',
  `RES_TYPE` int(1) NOT NULL DEFAULT '1' COMMENT '资源类型：1菜单2按钮3数据',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1正常',
  `RES_INDEX` int(4) NOT NULL DEFAULT '1' COMMENT '显示顺序',
  `RES_URL` varchar(255) DEFAULT NULL COMMENT '资源URL',
  `PERMISSION` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `RES_ICON` varchar(255) DEFAULT NULL COMMENT '资源图标',
  PRIMARY KEY (`RES_ID`)
);

# 后台管理系统-角色表
CREATE TABLE `s_role` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(255) NOT NULL COMMENT '角色名称',
  `ROLE_CODE` varchar(255) NOT NULL COMMENT '角色代码',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '状态：0不可用1正常',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '创建时间',
  `LAST_MOD_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后修改时间',
  PRIMARY KEY (`ROLE_ID`)
);

# 后台管理系统-角色资源表
CREATE TABLE `s_role_resource` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色编号',
  `RES_ID` varchar(32) NOT NULL COMMENT '资源编号',
  PRIMARY KEY (`ROLE_ID`,`RES_ID`)
);

# 后台管理系统-用户表
CREATE TABLE `s_user` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户编号',
  `USER_TEL` varchar(20) DEFAULT NULL COMMENT '用户手机号',
  `USER_MAIL` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `USER_ACCOUNT` varchar(255) DEFAULT NULL COMMENT '用户自定义账号',
  `USER_PWD` varchar(64) NOT NULL COMMENT '用户密码',
  `STATUS` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态 0不可用1正常',
  `CREATE_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '注册时间',
  `REGISTER_IP` varchar(50) NOT NULL COMMENT '注册IP',
  `LOGIN_TIMES` int(6) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `LAST_LOGIN_IP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `LAST_LOGIN_TIME` timestamp NOT NULL DEFAULT '2016-01-01 00:00:00' COMMENT '最后登录时间',
  `IS_LOCKED` int(1) NOT NULL DEFAULT '0' COMMENT '是否锁定（密码错误登录异常等情况使用）',
  `PWD_WRONG_TIMES` int(2) NOT NULL DEFAULT '0' COMMENT '当前登录密码错误次数',
  `NICK_NAME` varchar(32) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`USER_ID`),
  KEY `USER_TEL_INDEX` (`USER_TEL`),
  KEY `USER_MAIL_INDEX` (`USER_MAIL`),
  KEY `USER_ACCOUNT_INDEX` (`USER_ACCOUNT`)
);

# 后台管理系统-用户角色表
CREATE TABLE `s_user_role` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户编号',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
);
