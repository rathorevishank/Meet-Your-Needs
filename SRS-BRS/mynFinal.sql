CREATE DATABASE  IF NOT EXISTS `meet_your_need` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `meet_your_need`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: meet_your_need
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `uid_idx` (`user_id`),
  CONSTRAINT `uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(105) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Graphics & Design',NULL),(2,'Digital Marketing',NULL),(3,'Writing & Translation',NULL),(4,'Video & Animation',NULL),(5,'Music & Audio',NULL),(6,'Programming & Tec',NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL,
  `city_name` varchar(105) DEFAULT NULL,
  `pin_code` varchar(45) DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_id_idx` (`state_id`),
  KEY `csid_idx` (`state_id`),
  CONSTRAINT `csid` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Pune','411001',1),(2,'Ahmed Nagar','413201',1),(3,'Akola','444001',1),(4,'Amravati','442302',1),(5,'Mumbai','400001',1),(6,'Hyderabad','500001',2),(7,'Chittoor','517001',2),(8,'Voduru','534126',2),(9,'Devagiri','515871',2),(10,'Chikkepalli','515445',2),(11,'Lower Dibang Valley','792110',3),(12,'Dibang Valley	','792101',3),(13,'East Kameng','790102',3),(16,'Amgaon','781026',4),(17,'Malaybari','782403',4),(18,'Betna','781366',4),(19,'Indrapur','781032',4),(20,'Dispur','781005',4),(21,'Patna','800008',5),(22,'Aurangabad','824101',5),(23,'Gaya','823001',5),(24,'Muzaffarpur','843113',5),(25,'Arrah','802301',5),(26,'Ambikapur','497001',6),(27,'Bhilai','49006',6),(28,'Raipur','493661',6),(29,'Bilaspur','495001',6),(30,'Jagdalpur','494001',6),(31,'Vimannagar','411014',7),(32,'Laxminagar','110092',7),(33,'Dwarka','110037',7),(34,'Cp','110001',7),(35,'Rajivchowk','110001',7),(36,'Fatorda','403 602',8),(37,'Dona Paula','403004',8),(38,'Panaji','403001',8),(39,'Neura','403104',8),(40,'Ponda','403401',8),(41,'Ahemdabad','380006',9),(42,'Amraiwadi','380026',9),(43,'Bhavda','382433',9),(44,'Surat','392150',9),(45,'Tapi','394365',9),(46,'Faridabad','121002',10),(47,'Rohtak','124001',10),(48,'Hisar','125001',10),(49,'Sirsa','125054',10),(50,'Bhiwani','127021',10),(51,'Chhatrari','176324',11),(52,'Churi','176311',11),(53,'Pandol','175032',11),(54,'Balu','175121',11),(55,'Chowk','175033',11),(56,'Shaheedi Chowk Jammu','180001',12),(57,'Akalpur','180002',12),(58,'Bhadrod','180002',12),(59,'Srinagar','190001',12),(60,'Rajouri','185131',12),(61,'Bokaro','827001',13),(62,'Dhanbad','826001',13),(63,'Dumka','814101',13),(64,'Chatra','825401',13),(65,'Garhwa','822114',13),(66,'Bangalore','560030',14),(67,'Belgaum','591216',14),(68,'Bijapur','586102',14),(69,'Bidar','585401',14),(70,'Bellary','583124',14),(71,'Alappuzha','686102',15),(72,'Ernakulam','680667',15),(73,'Idukki','685501',15),(74,'	Kozhikode','673001',15),(75,'Wayanad','670644',15),(76,'Ashok Nagar','473446',16),(77,'	Bhopal','464993',16),(78,'Gwalior','474001	',16),(79,'Indore','452001',16),(80,'Jabalpur','482001',16),(81,'Chandel','795101',17),(82,'Imphal East','795003',17),(83,'Ukhrul','795142',17),(84,'	Senapati','795007',17),(85,'Imphal West','795001',17),(86,'East Garo Hills','783123',18),(87,'Jaintia Hills','793109',18),(88,'West Garo Hills','794001',18),(89,'West Khasi Hills	','793106',18),(90,'South Garo Hills','794102',18),(91,'Dimapur','797103',19),(92,'Kohima','797001',19),(93,'Mon','798602',19),(94,'Phek','797102',19),(95,'Longleng','798625',19),(96,'Dimapur','797103',20),(97,'Kohima','797001',20),(98,'Longleng','798625	',20),(99,'Mon','798602	',20),(100,'Phek','797102',20),(101,'Angul','759037',21),(102,'Baleswar','756001',21),(103,'Bargarh','768027',21),(104,'Puri','752001	',21),(105,'Sambalpur','768001	',21),(106,'Amritsar','143001',22),(107,'Barnala','148024	',22),(108,'Firozpur','142041	',22),(109,'Ludhiana','141001',22),(110,'Mohali','140103',22),(111,'Ajmer','305001',23),(112,'Alwar','321633',23),(113,'Chittorgarh','326501',23),(114,'Bundi','323803',23),(115,'Bikaner','334808',23),(116,'Gangtok','737101',24),(117,'	Dikchu','	737107',24),(118,'Tarku','	737134',24),(119,'Lower Dzongu','737116',24),(120,'	Sadam','737128',24),(121,'Chennai','600001',25),(122,'Dharmapuri','635111',25),(123,'	Kanchipuram','631606',25),(124,'Kanyakumari','	629901',25),(125,'	Nilgiris','643253',25),(126,'	Manikpur','	799273',26),(127,'Laxmipur','	799284',26),(128,'Baligaon','799285',26),(129,'	Sikaribari','799289',26),(130,'	Debbari','	799101',26),(131,'Varanashi','221001',27),(132,'Lucknow','226001',27),(133,'Allahabad','229413',27),(134,'	Ballia','277506',27),(135,'	Agra','283202',27),(136,'	Almora','263680',28),(137,'Nainital','244713',28),(138,'	Dehradun','247670',28),(139,'	Chamoli','246488',28),(140,'	Champawat','262580',28),(141,'	Haridwar','249411',28),(142,'Kolkata','	700108',29),(143,'Howrah','712408',29),(145,'Hooghly','712708',29),(146,'Malda','733142',29);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `company_name` varchar(105) DEFAULT NULL,
  `company_location` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,3,'knowIT','Pune'),(3,3,'MYN','Pune');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL,
  `payment_detail` varchar(105) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `transaction_id` int DEFAULT NULL,
  `mode_of_payment` varchar(45) DEFAULT NULL,
  `final_payment` double DEFAULT NULL,
  `initial_payment` double DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `porj_pay_idx` (`project_id`),
  CONSTRAINT `FKpr4verq7hue9q4xpa1pr8wt66` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progress`
--

DROP TABLE IF EXISTS `progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progress` (
  `progress_id` int NOT NULL,
  `progress_name` varchar(205) DEFAULT NULL,
  PRIMARY KEY (`progress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progress`
--

LOCK TABLES `progress` WRITE;
/*!40000 ALTER TABLE `progress` DISABLE KEYS */;
/*!40000 ALTER TABLE `progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `response_id` int DEFAULT NULL,
  `payment_id` int DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `tracking_id` int DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `payment_id_idx` (`payment_id`),
  KEY `resp_idx` (`response_id`),
  CONSTRAINT `payment_id` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`),
  CONSTRAINT `resp` FOREIGN KEY (`response_id`) REFERENCES `responses` (`response_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,1,NULL,'2023-03-12 16:34:31',NULL,NULL),(2,1,NULL,'2023-03-12 16:43:55',NULL,NULL),(3,1,NULL,'2023-03-12 18:05:22',NULL,NULL),(4,1,NULL,'2023-03-12 18:05:26',NULL,NULL),(5,2,NULL,'2023-03-12 18:06:18',NULL,NULL),(6,2,NULL,'2023-03-12 18:08:41',NULL,NULL),(7,2,NULL,'2023-03-12 18:09:08',NULL,NULL),(8,2,NULL,'2023-03-12 18:33:57',NULL,NULL),(9,6,NULL,'2023-03-12 18:34:11',NULL,NULL),(10,2,NULL,'2023-03-12 19:05:02',NULL,NULL),(11,6,NULL,'2023-03-12 19:23:58',NULL,NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_tracking`
--

DROP TABLE IF EXISTS `project_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_tracking` (
  `tracking_id` int NOT NULL,
  `client_comment` varchar(200) DEFAULT NULL,
  `pchange_date` datetime DEFAULT NULL,
  `progress_id` int DEFAULT NULL,
  `vendor_comment` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`tracking_id`),
  KEY `progress_id_idx` (`progress_id`),
  CONSTRAINT `progress_id` FOREIGN KEY (`progress_id`) REFERENCES `progress` (`progress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tracking`
--

LOCK TABLES `project_tracking` WRITE;
/*!40000 ALTER TABLE `project_tracking` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `qid` int NOT NULL,
  `question_text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'What is your favourite color'),(2,'In what city were you born?'),(3,'What is the name of your favorite pet?'),(4,'What high school did you attend?'),(5,'What was the name of your elementary school?'),(6,'What was the make of your first car?'),(7,'What was your favorite food as a child?');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `client_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `request_date` datetime DEFAULT NULL,
  `budget` double DEFAULT NULL,
  `status` int DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`request_id`),
  KEY `category_id_idx` (`category_id`),
  KEY `cat_id_idx` (`category_id`),
  KEY `cate_id_idx` (`category_id`),
  KEY `clientid_idx` (`client_id`),
  CONSTRAINT `cate_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `clientid` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,1,1,NULL,5000,1,'new',NULL,''),(18,3,2,'2023-03-05 00:00:00',4000,1,'Logo',NULL,'Logos often incorporate elements such as typography, color, shapes, and symbols to convey a particular message or brand identity. They may be used on a variety of marketing and promotional materials, including business cards, websites, advertisements, and product packaging.'),(19,3,3,'2023-03-05 00:00:00',2000,1,'SRS',NULL,'SRS stands for Software Requirements Specification. It is a document that outlines the functional and non-functional requirements of a software system that is being developed. The SRS document serves as a reference for software developers, testers, and other stakeholders involved in the development process.'),(20,3,4,'2023-03-05 00:00:00',5000,0,'logo animatin',NULL,'Animation refers to the process of creating the illusion of motion and change by displaying a sequence of static images that minimally differ from each other. These images, called frames, are played in rapid succession, creating the illusion of motion, much like a flipbook. Animation can be created using various techniques, such as traditional hand-drawn animation, computer-generated animation, stop-motion animation, and more.'),(21,3,6,'2023-03-05 00:00:00',6900,0,'MeetYourNeed',NULL,'A website is a collection of web pages that are hosted on a web server and can be accessed via the internet. Websites are typically designed to provide information about a particular topic, product, service, or organization. They can also be used for e-commerce, social networking, and other online activities.'),(22,3,2,'2023-03-06 00:00:00',1000,0,'insta marketing',NULL,'Marketing refers to the process of identifying, creating, promoting, and selling products or services to a target audience. The goal of marketing is to generate interest in the product or service and ultimately persuade potential customers to purchase it.'),(23,3,3,'2023-03-06 00:00:00',3100,0,'documentation',NULL,NULL),(24,3,2,'2023-03-06 00:00:00',8000,0,'another one',NULL,NULL),(25,3,6,'2023-03-12 00:00:00',8200,0,NULL,NULL,'kuch ni\n');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responses`
--

DROP TABLE IF EXISTS `responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responses` (
  `response_id` int NOT NULL AUTO_INCREMENT,
  `request_id` int DEFAULT NULL,
  `vendor_id` int DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`response_id`),
  KEY `req_id_idx` (`request_id`),
  KEY `vendor_id_idx` (`vendor_id`),
  KEY `vend_id_idx` (`vendor_id`),
  CONSTRAINT `req_id` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`),
  CONSTRAINT `vend_id` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responses`
--

LOCK TABLES `responses` WRITE;
/*!40000 ALTER TABLE `responses` DISABLE KEYS */;
INSERT INTO `responses` VALUES (1,18,1,NULL,NULL),(2,19,1,NULL,NULL),(3,20,1,NULL,NULL),(4,1,1,NULL,NULL),(5,18,1,NULL,NULL),(6,19,1,NULL,NULL),(7,1,1,NULL,NULL),(8,18,1,NULL,NULL),(9,1,1,NULL,'2023-03-12');
/*!40000 ALTER TABLE `responses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `role_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Vendor'),(3,'Client');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `category_id` int DEFAULT NULL,
  `skill_id` int NOT NULL,
  `skill_name` varchar(105) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`skill_id`),
  KEY `category_id_idx` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,1,'Logo Design',NULL),(1,2,'Game Art',NULL),(2,3,'Social Media Marketing',NULL),(2,4,'E-Commerce Marketing',NULL),(3,5,'Articles & Blog Posts',NULL),(3,6,'Scriptwriting',NULL),(4,7,'Video Editing',NULL),(4,8,'Logo Animation',NULL),(5,9,'Voice Over',NULL),(5,10,'Audio Editing',NULL),(6,11,'Website Development',NULL),(6,12,'Databases',NULL);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `state_id` int NOT NULL,
  `state_name` varchar(105) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Maharastra'),(2,'Andhra Pradesh'),(3,'Arunachal Pradesh'),(4,'Assam'),(5,'Bihar'),(6,'Chhattisgarh'),(7,'Delhi'),(8,'Goa'),(9,'Gujarat'),(10,'Haryana'),(11,'Himachal Pradesh'),(12,'Jammu & Kashmir'),(13,'Jharkhand'),(14,'Karnataka'),(15,'Kerala'),(16,'Madhya Pradesh'),(17,'Manipur'),(18,'Meghalaya'),(19,'Mizoram'),(20,'Nagaland'),(21,'Orissa'),(22,'Punjab'),(23,'Rajasthan'),(24,'Sikkim'),(25,'Tamil Nadu'),(26,'Tripura'),(27,'Uttar Pradesh'),(28,'Uttarakhand'),(29,'West Bengal');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `question_id` int DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `phone_no` varchar(45) DEFAULT NULL,
  `answer` varchar(205) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  `adhar_no` varchar(45) DEFAULT NULL,
  `address` varchar(205) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `first_name` varchar(105) DEFAULT NULL,
  `last_name` varchar(105) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_no_UNIQUE` (`phone_no`),
  UNIQUE KEY `adhar_no_UNIQUE` (`adhar_no`),
  KEY `role_id_idx` (`role_id`),
  KEY `question_id_idx` (`question_id`),
  KEY `city_id_idx` (`city_id`),
  KEY `state_id_idx` (`state_id`),
  CONSTRAINT `city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`),
  CONSTRAINT `question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`qid`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `state_id` FOREIGN KEY (`state_id`) REFERENCES `state` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'root','meet@mail.com',1,1,'2000-01-01 00:00:00','9000111222','yes',1,1,'1234567823456789','SB road','Indian','Dummy','Account',1),(2,'priya','priya@gmail.com',2,3,'1995-05-15 00:00:00','6565656565','yes',3,15,'1234567654321','JM road','Indian','Priya','Sinha',1),(3,'nidhi','nidhi@gmail.com',3,2,'1998-05-12 00:00:00','1212121212','yes',2,8,'1212345678921','Shivajinagar','Indian','Nidhi','Srivastava',1),(4,'deva','devanshu@mail.com',1,2,'1999-04-01 00:00:00','8885552220','one',26,1,'9879876546543210','SB road','Indian','Devanshu','Sinha',1),(10,'Sinha@123','sinha@gmail.com',NULL,2,'2023-03-03 05:30:00','7898741349','Ambikapur',26,6,NULL,'Gudri','Indian','Devanshu','Sinha',0),(14,'Sinha@123','dev@gmail.com',NULL,7,'2023-03-13 05:30:00','7898741340','blue',26,6,NULL,'gudri chowk','Indian','Devanshu','Sinha',0),(15,'Sinha@123','deva@gmail.com',2,4,'2023-03-22 05:30:00','7798741349','sbp',1,1,NULL,'SB Road','Indina','Devanshu','Sinha',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `vendor_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `portfolio` int DEFAULT NULL,
  PRIMARY KEY (`vendor_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `port_ven_idx` (`portfolio`),
  CONSTRAINT `port_ven` FOREIGN KEY (`portfolio`) REFERENCES `vendor_portfolio` (`portfolio_id`),
  CONSTRAINT `u_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (1,2,1);
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_feedback`
--

DROP TABLE IF EXISTS `vendor_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor_feedback` (
  `feedback_id` int NOT NULL AUTO_INCREMENT,
  `rating` int DEFAULT NULL,
  `comment` varchar(205) DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `proj_idx` (`project_id`),
  CONSTRAINT `proj` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_feedback`
--

LOCK TABLES `vendor_feedback` WRITE;
/*!40000 ALTER TABLE `vendor_feedback` DISABLE KEYS */;
INSERT INTO `vendor_feedback` VALUES (1,5,'this is a comment',1),(2,5,'this is a comment',2),(3,3,'comment for new project',3),(4,3,'new comm',6);
/*!40000 ALTER TABLE `vendor_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_portfolio`
--

DROP TABLE IF EXISTS `vendor_portfolio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor_portfolio` (
  `portfolio_id` int NOT NULL,
  `category_id` int DEFAULT NULL,
  `skill_id` int DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  `about` varchar(250) DEFAULT NULL,
  `price_per_hour` double DEFAULT NULL,
  `portfolio_file` mediumblob,
  `vendor_id` int DEFAULT NULL,
  PRIMARY KEY (`portfolio_id`),
  KEY `cat_id_idx` (`category_id`),
  KEY `skill_id_idx` (`skill_id`),
  KEY `FKfkrvsaqn80jtbwrrcigrpvvqy` (`vendor_id`),
  CONSTRAINT `cat_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `FKfkrvsaqn80jtbwrrcigrpvvqy` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`),
  CONSTRAINT `skill_id` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_portfolio`
--

LOCK TABLES `vendor_portfolio` WRITE;
/*!40000 ALTER TABLE `vendor_portfolio` DISABLE KEYS */;
INSERT INTO `vendor_portfolio` VALUES (1,6,11,'5','hi i am a website developer',200,NULL,1);
/*!40000 ALTER TABLE `vendor_portfolio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-13 10:40:58
