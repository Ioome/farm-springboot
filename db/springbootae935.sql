-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springbootae935
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/springbootae935/upload/picture1.jpg'),(2,'picture2','http://localhost:8080/springbootae935/upload/picture2.jpg'),(3,'picture3','http://localhost:8080/springbootae935/upload/picture3.jpg'),(4,'picture4','http://localhost:8080/springbootae935/upload/picture4.jpg'),(5,'picture5','http://localhost:8080/springbootae935/upload/picture5.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussgonggaoxinxi`
--

DROP TABLE IF EXISTS `discussgonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussgonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='公告信息评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussgonggaoxinxi`
--

LOCK TABLES `discussgonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `discussgonggaoxinxi` DISABLE KEYS */;
INSERT INTO `discussgonggaoxinxi` VALUES (1,'2030-12-20 01:49:21',1,1,'评论内容1','回复内容1'),(2,'2030-12-20 01:49:21',2,2,'评论内容2','回复内容2'),(3,'2030-12-20 01:49:21',3,3,'评论内容3','回复内容3'),(4,'2030-12-20 01:49:21',4,4,'评论内容4','回复内容4'),(5,'2030-12-20 01:49:21',5,5,'评论内容5','回复内容5'),(6,'2030-12-20 01:49:21',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussgonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussqukuai`
--

DROP TABLE IF EXISTS `discussqukuai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussqukuai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='区块评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussqukuai`
--

LOCK TABLES `discussqukuai` WRITE;
/*!40000 ALTER TABLE `discussqukuai` DISABLE KEYS */;
INSERT INTO `discussqukuai` VALUES (1,'2030-12-20 01:49:21',1,1,'评论内容1','回复内容1'),(2,'2030-12-20 01:49:21',2,2,'评论内容2','回复内容2'),(3,'2030-12-20 01:49:21',3,3,'评论内容3','回复内容3'),(4,'2030-12-20 01:49:21',4,4,'评论内容4','回复内容4'),(5,'2030-12-20 01:49:21',5,5,'评论内容5','回复内容5'),(6,'2030-12-20 01:49:21',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussqukuai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusszhiwu`
--

DROP TABLE IF EXISTS `discusszhiwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusszhiwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='植物评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusszhiwu`
--

LOCK TABLES `discusszhiwu` WRITE;
/*!40000 ALTER TABLE `discusszhiwu` DISABLE KEYS */;
INSERT INTO `discusszhiwu` VALUES (1,'2030-12-20 01:49:21',1,1,'评论内容1','回复内容1'),(2,'2030-12-20 01:49:21',2,2,'评论内容2','回复内容2'),(3,'2030-12-20 01:49:21',3,3,'评论内容3','回复内容3'),(4,'2030-12-20 01:49:21',4,4,'评论内容4','回复内容4'),(5,'2030-12-20 01:49:21',5,5,'评论内容5','回复内容5'),(6,'2030-12-20 01:49:21',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discusszhiwu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusszhongzhi`
--

DROP TABLE IF EXISTS `discusszhongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusszhongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='种植评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusszhongzhi`
--

LOCK TABLES `discusszhongzhi` WRITE;
/*!40000 ALTER TABLE `discusszhongzhi` DISABLE KEYS */;
INSERT INTO `discusszhongzhi` VALUES (1,'2030-12-20 01:49:21',1,1,'评论内容1','回复内容1'),(2,'2030-12-20 01:49:21',2,2,'评论内容2','回复内容2'),(3,'2030-12-20 01:49:21',3,3,'评论内容3','回复内容3'),(4,'2030-12-20 01:49:21',4,4,'评论内容4','回复内容4'),(5,'2030-12-20 01:49:21',5,5,'评论内容5','回复内容5'),(6,'2030-12-20 01:49:21',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discusszhongzhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoxinxi`
--

DROP TABLE IF EXISTS `gonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonggaobiaoti` varchar(200) NOT NULL COMMENT '公告标题',
  `gonggaoleixing` varchar(200) NOT NULL COMMENT '公告类型',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `neirong` longtext COMMENT '内容',
  `faburiqi` date DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoxinxi`
--

LOCK TABLES `gonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `gonggaoxinxi` DISABLE KEYS */;
INSERT INTO `gonggaoxinxi` VALUES (1,'2030-12-20 01:49:21','公告标题1','公告类型1','http://localhost:8080/springbootae935/upload/gonggaoxinxi_tupian1.jpg','内容1','2030-12-20'),(2,'2030-12-20 01:49:21','公告标题2','公告类型2','http://localhost:8080/springbootae935/upload/gonggaoxinxi_tupian2.jpg','内容2','2030-12-20'),(4,'2030-12-20 01:49:21','公告标题4','公告类型4','http://localhost:8080/springbootae935/upload/gonggaoxinxi_tupian4.jpg','内容4','2030-12-20'),(5,'2030-12-20 01:49:21','公告标题5','公告类型5','http://localhost:8080/springbootae935/upload/gonggaoxinxi_tupian5.jpg','内容5','2030-12-20'),(6,'2030-12-20 01:49:21','公告标题6','公告类型6','http://localhost:8080/springbootae935/upload/gonggaoxinxi_tupian6.jpg','内容6','2030-12-20');
/*!40000 ALTER TABLE `gonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huanjing`
--

DROP TABLE IF EXISTS `huanjing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huanjing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianhao` varchar(200) DEFAULT NULL COMMENT '编号',
  `tudimingcheng` varchar(200) DEFAULT NULL COMMENT '土地名称',
  `zhiwumingcheng` varchar(200) DEFAULT NULL COMMENT '植物名称',
  `fenlei` varchar(200) DEFAULT NULL COMMENT '分类',
  `zhiwutupian` varchar(200) DEFAULT NULL COMMENT '植物图片',
  `zhongzhiriqi` varchar(200) DEFAULT NULL COMMENT '种植日期',
  `dangqianzhuangtai` varchar(200) DEFAULT NULL COMMENT '当前状态',
  `huanjingwendu` varchar(200) NOT NULL COMMENT '环境温度',
  `wendujianyi` varchar(200) DEFAULT NULL COMMENT '温度建议',
  `wenduguanli` varchar(200) DEFAULT NULL COMMENT '温度管理',
  `kongqishidu` varchar(200) NOT NULL COMMENT '空气湿度',
  `shidujianyi` varchar(200) DEFAULT NULL COMMENT '湿度建议',
  `turangguanli` varchar(200) DEFAULT NULL COMMENT '土壤管理',
  `qita` varchar(200) DEFAULT NULL COMMENT '其它',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1608432827022 DEFAULT CHARSET=utf8 COMMENT='环境';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huanjing`
--

LOCK TABLES `huanjing` WRITE;
/*!40000 ALTER TABLE `huanjing` DISABLE KEYS */;
INSERT INTO `huanjing` VALUES (1,'2030-12-20 01:49:21','编号1','土地名称1','植物名称1','分类1','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian1.jpg','种植日期1','当前状态1','环境温度1','温度建议1','制热','空气湿度1','湿度建议1','干燥','其它1','用户名1','手机1',1),(2,'2030-12-20 01:49:21','编号2','土地名称2','植物名称2','分类2','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian2.jpg','种植日期2','当前状态2','环境温度2','温度建议2','制热','空气湿度2','湿度建议2','干燥','其它2','用户名2','手机2',2),(3,'2030-12-20 01:49:21','编号3','土地名称3','植物名称3','分类3','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian3.jpg','种植日期3','当前状态3','环境温度3','温度建议3','制热','空气湿度3','湿度建议3','干燥','其它3','用户名3','手机3',3),(4,'2030-12-20 01:49:21','编号4','土地名称4','植物名称4','分类4','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian4.jpg','种植日期4','当前状态4','环境温度4','温度建议4','制热','空气湿度4','湿度建议4','干燥','其它4','用户名4','手机4',4),(5,'2030-12-20 01:49:21','编号5','土地名称5','植物名称5','分类5','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian5.jpg','种植日期5','当前状态5','环境温度5','温度建议5','制热','空气湿度5','湿度建议5','干燥','其它5','用户名5','手机5',5),(6,'2030-12-20 01:49:21','编号6','土地名称6','植物名称6','分类6','http://localhost:8080/springbootae935/upload/huanjing_zhiwutupian6.jpg','种植日期6','当前状态6','环境温度6','温度建议6','制热','空气湿度6','湿度建议6','干燥','其它6','用户名6','手机6',6),(1608432827021,'2030-12-20 02:53:47','编号5','土地名称5','南瓜','瓜类','http://localhost:8080/springbootae935/upload/1608432790751.jpg','2030-12-21','生长中','26°','温度建议4','制热','400','湿度建议4','加湿',NULL,'001','13823888881',1);
/*!40000 ALTER TABLE `huanjing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `huanshui`
--

DROP TABLE IF EXISTS `huanshui`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `huanshui` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianhao` varchar(200) DEFAULT NULL COMMENT '编号',
  `tudimingcheng` varchar(200) DEFAULT NULL COMMENT '土地名称',
  `zhiwumingcheng` varchar(200) DEFAULT NULL COMMENT '植物名称',
  `zhiwutupian` varchar(200) DEFAULT NULL COMMENT '植物图片',
  `zhongzhiriqi` varchar(200) DEFAULT NULL COMMENT '种植日期',
  `huanshuiriqi` date DEFAULT NULL COMMENT '换水日期',
  `dangqianzhuangtai` varchar(200) DEFAULT NULL COMMENT '当前状态',
  `xiacihuanshui` date DEFAULT NULL COMMENT '下次换水',
  `qita` varchar(200) DEFAULT NULL COMMENT '其它',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1608432839693 DEFAULT CHARSET=utf8 COMMENT='换水';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huanshui`
--

LOCK TABLES `huanshui` WRITE;
/*!40000 ALTER TABLE `huanshui` DISABLE KEYS */;
INSERT INTO `huanshui` VALUES (1,'2030-12-20 01:49:21','编号1','土地名称1','植物名称1','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian1.jpg','种植日期1','2030-12-20','生长中','2030-12-20','其它1','用户名1','手机1',1),(2,'2030-12-20 01:49:21','编号2','土地名称2','植物名称2','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian2.jpg','种植日期2','2030-12-20','生长中','2030-12-20','其它2','用户名2','手机2',2),(3,'2030-12-20 01:49:21','编号3','土地名称3','植物名称3','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian3.jpg','种植日期3','2030-12-20','生长中','2030-12-20','其它3','用户名3','手机3',3),(4,'2030-12-20 01:49:21','编号4','土地名称4','植物名称4','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian4.jpg','种植日期4','2030-12-20','生长中','2030-12-20','其它4','用户名4','手机4',4),(5,'2030-12-20 01:49:21','编号5','土地名称5','植物名称5','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian5.jpg','种植日期5','2030-12-20','生长中','2030-12-20','其它5','用户名5','手机5',5),(6,'2030-12-20 01:49:21','编号6','土地名称6','植物名称6','http://localhost:8080/springbootae935/upload/huanshui_zhiwutupian6.jpg','种植日期6','2030-12-20','生长中','2030-12-20','其它6','用户名6','手机6',6),(1608432839692,'2030-12-20 02:53:59','编号5','土地名称5','南瓜','http://localhost:8080/springbootae935/upload/1608432790751.jpg','2030-12-21','2030-12-25','生长中','2021-01-04','1','001','13823888881',1);
/*!40000 ALTER TABLE `huanshui` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `picture` varchar(200) NOT NULL COMMENT '图片',
  `content` longtext NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='新闻资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'2030-12-20 01:49:21','我市已建成14个市级林业保障性苗圃','http://localhost:8080/springbootae935/upload/1608432891449.png','<p class=\"ql-align-justify\">市林业局消息，去年以来，我市启动建设了一批采用现代化智能育苗技术的市级林业保障性苗圃，目前已建成14个，保障了我市国土绿化提升行动等生态工程的用苗需求。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">在位于大足区西山林场的保障性苗圃，一棵棵小树苗长势优良。目前大足已建成保障性苗圃1000亩，重点培育了女贞、香樟、楠木等20余种苗木，统一采用了轻基质无纺布育苗袋进行培育，年出土苗木可达100万株。</p><p class=\"ql-align-justify\">大足区雨林林业开发有限公司苗木生产管理部技术工程师王登洪说，无纺布最大的好处就是栽在土壤里面自然溶解，起到环保的作用 ，移栽过后的成活率可以达到90%以上。</p><p class=\"ql-align-justify\">与此同时，智能化技术也运用在了育苗中。位于渝北区的华蓥山林场保障性苗圃，是我市首个智能化育苗基地。一大早，林场的工作人员便来到大棚温室，打开手机APP上的一体化灌溉系统，分区域为15万株小树苗浇水。这个系统还能根据苗木的品种和生长时期，配制所需的不同营养成分溶液，均匀、定时、定量输送到植物根系区域。</p><p class=\"ql-align-justify\">渝北区华蓥山林场场长王强表示，同时高效水肥灌溉和精准调控，可以节水节肥，使苗木生长规模化和高效化，过去培育树苗施肥浇水，全凭经验、靠感觉，现在一个人就能管整个苗圃基地。</p><p><br></p>'),(2,'2030-12-20 01:49:21','华蓥山林场建成重庆首个智能化育苗基地','http://localhost:8080/springbootae935/upload/1608432919008.jpg','<p>格容器的智能滴箭灌溉以及对圃地栽培的苗木进行智能滴灌。同时，还实现了对育苗基地气象因子、土壤和容器基质环境因子以及苗木的生长表现的实时动态监测。如今，工作人员只要打开手机上的APP肥水一体化灌溉系统，分区域点击浇水，一棵棵小树苗就能够喝上水了。</p><p>“通过这套系统，培育树苗既省时又省力，还能水肥精准供应、按需定量分配，实现了智能化管理。”华蓥山林场场长王强介绍，过去，培育树苗施肥浇水全凭经验、靠感觉，靠的是两条腿在大棚小棚之间来回跑，查看棚内温度计、湿度计上的数字，忙得喘不过气来。</p><p>现在，一个人就能管整个苗圃基地，游刃有余，极大地减少了管理成本。同时，该系统可以节水节肥并完成大面积灌溉和施肥，达到精准供给和“少量多餐”的水肥利用模式，从而提高苗木生长量与品质。</p>'),(3,'2030-12-20 01:49:21','智能苗圃：让学生自己“说”，才能让教学成果最优化','http://localhost:8080/springbootae935/upload/1608432940882.jpeg','<p class=\"ql-align-justify\"><strong>分数已无法考核学习成果，评价制成判定新方向</strong></p><p class=\"ql-align-justify\">传统教育有明确的“功利性”——<strong>多数人希望通过接受教育得到前往名校学习，以在未来获得更好的工作机会。</strong>因此，被用来考核学生对知识的掌握程度的“考试分数”，就成为大众交口称赞的方式。</p><p class=\"ql-align-justify\">随着时代发展，<strong>传统教育已无法满足“将学生培养成创新科技人才”的目标。</strong>国家教育咨询委员会委员，中国教育学会会长钟秉林表示“要促进高中学校特色发展。高中学校深化课程改革，开设特色课程，多样化发展。”社会教育模式发生变化，过去“分数论英雄”的模式很难正确判断学生掌握一门知识的程度。</p><p><br></p>'),(4,'2030-12-20 01:49:21','退休老人玩高科技 苗圃智能增温增氧','http://localhost:8080/springbootae935/upload/1608432983460.jpg','<p>	<a href=\"http://www.yuanlin.com/\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: black;\">中国园林网</a>6月12日消息：在四季园小区，有一位退休老人，为充分利用小区绿化空地，他在绿地上建了一个“苗圃”，而且这些苗都是无偿提供给居民。3年来，他前后为20多位居民提供了上百棵苗。</p><p>	<strong>“苗圃”植物80多种，还有濒危的</strong><a href=\"http://www.yuanlin.com/b2b/sell.html?keyword=%BA%EC%B6%B9%C9%BC\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: black;\"><strong>红豆杉</strong></a><strong>、铁皮石斛</strong></p><p>	这位退休老人名叫陶林实，今年65岁。他的“苗圃”有三四分地，分为两块区域，一块是资源圃，里面的植物都是“母株”；一块是成苗圃，这里的植物都来自资源圃的“母株”，“少部分是‘母株’种子播种，大部分是从‘母株’上剪枝后扦插的。”</p><p>	别看地方小，陶老的“苗圃”里有80多种植物，草本绣球、<a href=\"http://www.yuanlin.com/b2b/sell.html?keyword=%D4%C2%BC%BE\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: black;\">月季</a>、蛇舌草、大丽花、大岩洞、菖蒲、艾草、蜀葵、滴水观音、美人蕉……</p><p>	陶林实说，他的“苗圃”中，比较珍贵的有红豆杉、铁皮石斛等，它们是濒危植物。“红豆杉种了10多棵，前不久有人连招呼都没跟我打就挖走了，现在只剩下两棵了。</p>'),(5,'2030-12-20 01:49:21','智能温室不仅能种菜，还可以搞这些！','http://localhost:8080/springbootae935/upload/1608433002861.jpg','<p>以前，我们见到的温室都是用来种菜或者育苗的，但随着中国现代农业科技的进步，智能温室在我国的农业生产中已经得到广泛应用，以及温室种类的不断发展与功能的不断延伸，各类以智能温室设施为载体，以恒温环境为卖点，以全时全季休闲游玩、自然教育为理念的休闲观光温室正在成为农业发展的一个新的引擎，让智能温室发挥最大潜能为农业提供更大的价值支撑。</p><p><br></p>'),(6,'2030-12-20 01:49:21','小学生学习创客教育课程《智能苗圃》作品展示 ','http://localhost:8080/springbootae935/upload/1608433040488.jpeg','<p>通过创客教育课程《智能苗圃》可以让学生利用八爪鱼互动教学软件与智能苗圃主题包，借助主控板、土壤湿度传感器、温度传感器、光敏传感器以及无色透明亚克力板，搭建一套智能苗圃模型，进行培育植物实验，学习用编程控制智能苗圃内植物生长条件从而完成智能化培育植物的任务。</p><p>想要了解更多的八爪鱼</p>');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qukuai`
--

DROP TABLE IF EXISTS `qukuai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qukuai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianhao` varchar(200) NOT NULL COMMENT '编号',
  `tudimingcheng` varchar(200) NOT NULL COMMENT '土地名称',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `guimo` varchar(200) DEFAULT NULL COMMENT '规模',
  `mianji` int(11) DEFAULT NULL COMMENT '面积',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `shihezuowu` varchar(200) DEFAULT NULL COMMENT '适合作物',
  `xiangqing` longtext COMMENT '详情',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bianhao` (`bianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='区块';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qukuai`
--

LOCK TABLES `qukuai` WRITE;
/*!40000 ALTER TABLE `qukuai` DISABLE KEYS */;
INSERT INTO `qukuai` VALUES (1,'2030-12-20 01:49:21','编号1','土地名称1','http://localhost:8080/springbootae935/upload/qukuai_tupian1.jpg','小',1,'空闲','适合作物1','<p>详情1</p>','2030-12-20 02:51:27',2),(2,'2030-12-20 01:49:21','编号2','土地名称2','http://localhost:8080/springbootae935/upload/qukuai_tupian2.jpg','中',4,'空闲','适合作物2','<p>详情2</p>','2030-12-20 02:51:36',3),(3,'2030-12-20 01:49:21','编号3','土地名称3','http://localhost:8080/springbootae935/upload/qukuai_tupian3.jpg','大',3,'已使用','适合作物3','<p>详情3</p>','2030-12-20 02:51:43',4),(4,'2030-12-20 01:49:21','编号4','土地名称4','http://localhost:8080/springbootae935/upload/qukuai_tupian4.jpg','中',4,'已使用','适合作物4','<p>详情4</p>','2030-12-20 02:51:51',5),(5,'2030-12-20 01:49:21','编号5','土地名称5','http://localhost:8080/springbootae935/upload/qukuai_tupian5.jpg','大',5,'空闲','适合作物5','详情5','2030-12-20 02:53:24',7);
/*!40000 ALTER TABLE `qukuai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,1,'abo','users','管理员','swhpxfxh2lh2qgaj8d4tej997pntn4p4','2030-12-20 02:51:07','2030-12-19 19:54:12'),(2,1,'001','yonghu','用户','6j2ggmqilk9j38pruozss2ckdx7bq4ue','2030-12-20 02:52:51','2030-12-19 19:52:52');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2030-12-20 01:49:21');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuming` varchar(200) NOT NULL COMMENT '用户名',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) NOT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  PRIMARY KEY (`id`),
  UNIQUE KEY `yonghuming` (`yonghuming`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (1,'2030-12-20 01:49:21','001','001','小吴','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang1.jpg','13823888881'),(2,'2030-12-20 01:49:21','用户2','123456','姓名2','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang2.jpg','13823888882'),(3,'2030-12-20 01:49:21','用户3','123456','姓名3','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang3.jpg','13823888883'),(4,'2030-12-20 01:49:21','用户4','123456','姓名4','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang4.jpg','13823888884'),(5,'2030-12-20 01:49:21','用户5','123456','姓名5','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang5.jpg','13823888885'),(6,'2030-12-20 01:49:21','用户6','123456','姓名6','男','http://localhost:8080/springbootae935/upload/yonghu_touxiang6.jpg','13823888886');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhiwu`
--

DROP TABLE IF EXISTS `zhiwu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhiwu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhiwumingcheng` varchar(200) NOT NULL COMMENT '植物名称',
  `fenlei` varchar(200) DEFAULT NULL COMMENT '分类',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `shengzhangzhouqi` varchar(200) DEFAULT NULL COMMENT '生长周期',
  `yingyangjiazhi` varchar(200) DEFAULT NULL COMMENT '营养价值',
  `shifeipinzhong` varchar(200) DEFAULT NULL COMMENT '施肥品种',
  `guangzhaozhouqi` varchar(200) DEFAULT NULL COMMENT '光照周期',
  `turangyaoqiu` varchar(200) DEFAULT NULL COMMENT '土壤要求',
  `wendujianyi` varchar(200) DEFAULT NULL COMMENT '温度建议',
  `shidujianyi` varchar(200) DEFAULT NULL COMMENT '湿度建议',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhiwumingcheng` (`zhiwumingcheng`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='植物';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhiwu`
--

LOCK TABLES `zhiwu` WRITE;
/*!40000 ALTER TABLE `zhiwu` DISABLE KEYS */;
INSERT INTO `zhiwu` VALUES (1,'2030-12-20 01:49:21','荷兰豆','豆类','http://localhost:8080/springbootae935/upload/zhiwu_tupian1.jpg','生长周期1','营养价值1','氮肥','光照周期1','土壤要求1','温度建议1','湿度建议1','备注1'),(2,'2030-12-20 01:49:21','黄瓜','瓜类','http://localhost:8080/springbootae935/upload/zhiwu_tupian2.jpg','生长周期2','营养价值2','钾肥','光照周期2','土壤要求2','温度建议2','湿度建议2','备注2'),(3,'2030-12-20 01:49:21','西红柿','茄果类','http://localhost:8080/springbootae935/upload/zhiwu_tupian3.jpg','生长周期3','营养价值3','氮肥','光照周期3','土壤要求3','温度建议3','湿度建议3','备注3'),(4,'2030-12-20 01:49:21','南瓜','瓜类','http://localhost:8080/springbootae935/upload/zhiwu_tupian4.jpg','生长周期4','营养价值4','钾肥','光照周期4','土壤要求4','温度建议4','湿度建议4','备注4'),(5,'2030-12-20 01:49:21','植物名称5','牙苗类','http://localhost:8080/springbootae935/upload/zhiwu_tupian5.jpg','生长周期5','营养价值5','复合肥','光照周期5','土壤要求5','温度建议5','湿度建议5','备注5'),(6,'2030-12-20 01:49:21','植物名称6','牙苗类','http://localhost:8080/springbootae935/upload/zhiwu_tupian6.jpg','生长周期6','营养价值6','复合肥','光照周期6','土壤要求6','温度建议6','湿度建议6','备注6');
/*!40000 ALTER TABLE `zhiwu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhongzhi`
--

DROP TABLE IF EXISTS `zhongzhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhongzhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bianhao` varchar(200) DEFAULT NULL COMMENT '编号',
  `tudimingcheng` varchar(200) DEFAULT NULL COMMENT '土地名称',
  `guimo` varchar(200) DEFAULT NULL COMMENT '规模',
  `mianji` int(11) DEFAULT NULL COMMENT '面积',
  `zhuangtai` varchar(200) DEFAULT NULL COMMENT '状态',
  `shihezuowu` varchar(200) DEFAULT NULL COMMENT '适合作物',
  `zhiwumingcheng` varchar(200) DEFAULT NULL COMMENT '植物名称',
  `fenlei` varchar(200) DEFAULT NULL COMMENT '分类',
  `shengzhangzhouqi` varchar(200) DEFAULT NULL COMMENT '生长周期',
  `wendujianyi` varchar(200) DEFAULT NULL COMMENT '温度建议',
  `shidujianyi` varchar(200) DEFAULT NULL COMMENT '湿度建议',
  `zhiwutupian` varchar(200) DEFAULT NULL COMMENT '植物图片',
  `zhongzhiriqi` date DEFAULT NULL COMMENT '种植日期',
  `shougeriqi` date DEFAULT NULL COMMENT '收割日期',
  `dangqianzhuangtai` varchar(200) DEFAULT NULL COMMENT '当前状态',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `yonghuming` varchar(200) DEFAULT NULL COMMENT '用户名',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1608432801558 DEFAULT CHARSET=utf8 COMMENT='种植';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhongzhi`
--

LOCK TABLES `zhongzhi` WRITE;
/*!40000 ALTER TABLE `zhongzhi` DISABLE KEYS */;
INSERT INTO `zhongzhi` VALUES (1,'2030-12-20 01:49:21','编号1','土地名称1','规模1',1,'状态1','适合作物1','植物名称1','分类1','生长周期1','温度建议1','湿度建议1','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian1.jpg','2030-12-20','2030-12-20','生长中','备注1','用户名1','手机1',1),(2,'2030-12-20 01:49:21','编号2','土地名称2','规模2',2,'状态2','适合作物2','植物名称2','分类2','生长周期2','温度建议2','湿度建议2','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian2.jpg','2030-12-20','2030-12-20','生长中','备注2','用户名2','手机2',2),(3,'2030-12-20 01:49:21','编号3','土地名称3','规模3',3,'状态3','适合作物3','植物名称3','分类3','生长周期3','温度建议3','湿度建议3','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian3.jpg','2030-12-20','2030-12-20','生长中','备注3','用户名3','手机3',3),(4,'2030-12-20 01:49:21','编号4','土地名称4','规模4',4,'状态4','适合作物4','植物名称4','分类4','生长周期4','温度建议4','湿度建议4','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian4.jpg','2030-12-20','2030-12-20','生长中','备注4','用户名4','手机4',4),(5,'2030-12-20 01:49:21','编号5','土地名称5','规模5',5,'状态5','适合作物5','植物名称5','分类5','生长周期5','温度建议5','湿度建议5','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian5.jpg','2030-12-20','2030-12-20','生长中','备注5','用户名5','手机5',5),(6,'2030-12-20 01:49:21','编号6','土地名称6','规模6',6,'状态6','适合作物6','植物名称6','分类6','生长周期6','温度建议6','湿度建议6','http://localhost:8080/springbootae935/upload/zhongzhi_zhiwutupian6.jpg','2030-12-20','2030-12-20','生长中','备注6','用户名6','手机6',6),(1608432801557,'2030-12-20 02:53:21','编号5','土地名称5','大',5,'空闲','适合作物5','南瓜','瓜类','生长周期4','温度建议4','湿度建议4','http://localhost:8080/springbootae935/upload/1608432790751.jpg','2030-12-21','2021-01-08','生长中',NULL,'001','13823888881',1);
/*!40000 ALTER TABLE `zhongzhi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2030-12-27 21:06:18
