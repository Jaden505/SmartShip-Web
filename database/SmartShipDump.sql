CREATE DATABASE  IF NOT EXISTS `smartship` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smartship`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: smartship
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `alarm`
--

DROP TABLE IF EXISTS `alarm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alarm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `parameter` varchar(255) DEFAULT NULL,
  `setted_up_value` double DEFAULT NULL,
  `ship_id` varchar(255) DEFAULT NULL,
  `value_since_last_update` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alarm_ship_fk_idx` (`ship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarm`
--

LOCK TABLES `alarm` WRITE;
/*!40000 ALTER TABLE `alarm` DISABLE KEYS */;
INSERT INTO `alarm` VALUES (2,'engine 1','Engine temperature',0,'0',0);
/*!40000 ALTER TABLE `alarm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `engine`
--

DROP TABLE IF EXISTS `engine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `engine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `kw_critical` int DEFAULT NULL,
  `kw_good` int DEFAULT NULL,
  `kw_warning` int DEFAULT NULL,
  `rpm_critical` int DEFAULT NULL,
  `rpm_good` int DEFAULT NULL,
  `rpm_warning` int DEFAULT NULL,
  `id_ship` int DEFAULT NULL,
  `temperature` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `engine`
--

LOCK TABLES `engine` WRITE;
/*!40000 ALTER TABLE `engine` DISABLE KEYS */;
/*!40000 ALTER TABLE `engine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parameter` varchar(30) NOT NULL,
  `category` varchar(30) NOT NULL,
  `valueSinceLastUpdate` double(5,2) NOT NULL,
  `settedUpValue` double(5,2) NOT NULL,
  `ship_id` varchar(255) NOT NULL,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `temperature` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ship_fk_idx` (`ship_id`),
  CONSTRAINT `notification_ship_fk` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_MANAGER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensor_data`
--

DROP TABLE IF EXISTS `sensor_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sensor_data` (
  `sensor_id` varchar(255) NOT NULL,
  `gps_latitude` varchar(255) DEFAULT NULL,
  `gps_longtitude` varchar(255) DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL,
  `sensor_name` varchar(255) DEFAULT NULL,
  `ship` varchar(255) DEFAULT NULL,
  `speed` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `fk_sensor_ship_idx` (`ship`),
  CONSTRAINT `fk_sensor_ship` FOREIGN KEY (`ship`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_data`
--

LOCK TABLES `sensor_data` WRITE;
/*!40000 ALTER TABLE `sensor_data` DISABLE KEYS */;
INSERT INTO `sensor_data` VALUES ('bb7baec4-c049-45c5-81ce-2715801','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Direction','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7'),('bb7baec4-c049-45c5-81ce-27158016bfff','N52°3\'53.754','E3°40\'53.123','Fuel','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','T/H','15'),('bb7baec4-c049-45c5-81ce-2715801bff','N52°3\'53.754','E3°40\'53.123','Battery','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15'),('bb7baec4-c049-45c5-81ce-2715801e','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Speed','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7'),('bb7baec4-c049-45c5-81ce-2715801e6b','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68'),('bb7baec4-c049-45c5-81ce-2715801e6bfff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68'),('bb7baec4-c049-45c5-81ce-2715801e6bffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Level','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Quantity','L','350'),('bb7baec4-c049-45c5-81ce-2715801e6bffffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 RPM','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','RPM','RPM','65'),('bb7baec4-c049-45c5-81ce-2715801e6bfffffff','N52°3\'53.754','E3°40\'53.123','Battery','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','KW/H','15'),('bb7baec4-c049-45c5-81ce-271801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15'),('bb7baec4-c049-45c5-82ce-2715801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15');
/*!40000 ALTER TABLE `sensor_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship`
--

DROP TABLE IF EXISTS `ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ship` (
  `id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) NOT NULL,
  `status` int NOT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `destination` varchar(45) DEFAULT NULL,
  `water_tank1` int DEFAULT NULL,
  `water_tank2` int DEFAULT NULL,
  `gps_latitude` varchar(255) DEFAULT NULL,
  `gps_longtitude` varchar(255) DEFAULT NULL,
  `kw` int DEFAULT NULL,
  `rpm` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_status_idx` (`status`),
  CONSTRAINT `fk_status` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship`
--

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES ('07202515-a483-464c-b704-5671f104044b',NULL,'Hawai',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('1','Titanicc','Pakistan',1,'Titanicc','eaf',2,2,NULL,NULL,0,0),('2','Maria','Parijs',2,'Maria','Paris',1,0,NULL,NULL,0,0),('4','fea','eaf',1,'fea',NULL,2,0,NULL,NULL,0,0);
/*!40000 ALTER TABLE `ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'ACTIVE'),(2,'IDLE'),(3,'MAINTENANCE');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `roleID` int NOT NULL,
  `shipID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `fk_roleIDx` (`roleID`),
  KEY `ship_fk_idx` (`shipID`),
  CONSTRAINT `role_fk` FOREIGN KEY (`roleID`) REFERENCES `role` (`id`),
  CONSTRAINT `ship_fk` FOREIGN KEY (`shipID`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'raihan@gmail.com','$2a$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','Raihan',1,'1'),(2,'btynior@gmail.com','$2a$10$Hxv16Y5DtCRXcdbc3U5/zODRnN/o9boyOevGwRxsxsLigRvQ3ebb.','Vincent',2,'1'),(3,'john@gmail.com','$2a$10$uf9B9HRkQaoMPiYjBUX2V.h5xlxWg4IqiDojqBNJPkgogOgTnptwO','John',2,'2'),(4,'peter@gmail.com','$2a$10$sQiuq6I0s1yVDv1yGsMEHeup/ZRgxh2SFh4HlyhK463M3j6QJnmrm','Peter',3,'1'),(5,'maico@gmail.com','$2a$12$Jma1KATBy5s8TnyQ4oxBiOEeHZNH/dI32V98/veBavu1xbNGmxB6O\n$2a$12$Jma1KATBy5s8TnyQ4oxBiOEeHZNH/dI32V98/veBavu1xbNGmxB6O\n$2a$12$Jma1KATBy5s8TnyQ4oxBiOEeHZNH/dI32V98/veBavu1xbNGmxB6O\n','Maico',3,'2'),(14,'Johnny@gmail.com','$2a$10$smPKe6NO9ewVZFCq9ctGc.mq1cjwOTQaYTkOl5nbGbBFFrIRaUZ7C','Johny',1,'1'),(23,'maccie@gmail.com','$2a$10$UCZYXJwpVQN/aW7TmgMZCOekGZBrLQk/r.9S9BE48MKH.NPLRCose','maccie',1,'4');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'smartship'
--

--
-- Dumping routines for database 'smartship'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-13 20:02:34
