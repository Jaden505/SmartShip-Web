CREATE DATABASE  IF NOT EXISTS `smartship` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `smartship`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartship
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
                               `id` int NOT NULL,
                               `ship_id` int DEFAULT NULL,
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
INSERT INTO `sensor_data` VALUES ('bb7baec4-c049-45c5-81ce-2715801','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Direction','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7',0,NULL),('bb7baec4-c049-45c5-81ce-27158016bfff','N52°3\'53.754','E3°40\'53.123','Fuel','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','T/H','15',0,NULL),('bb7baec4-c049-45c5-81ce-2715801bff','N52°3\'53.754','E3°40\'53.123','Battery','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Speed','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e6b','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e6bfff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e6bffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Level','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Quantity','L','350',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e6bffffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 RPM','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','RPM','RPM','65',0,NULL),('bb7baec4-c049-45c5-81ce-2715801e6bfffffff','N52°3\'53.754','E3°40\'53.123','Battery','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','KW/H','15',0,NULL),('bb7baec4-c049-45c5-81ce-271801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15',0,NULL),('bb7baec4-c049-45c5-82ce-2715801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15',0,NULL);
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
                        `gps_latitude` varchar(255) DEFAULT NULL,
                        `gps_longtitude` varchar(255) DEFAULT NULL,
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
INSERT INTO `ship` VALUES ('07202515-a483-464c-b704-5671f104044b','Serendipity','Amsterdam',1,'Europe','Kaapstad',NULL,NULL),('3001','Imagination','Rotterdam',2,'Europe','New York',NULL,NULL),('3002','Liberty','Berlijn',3,'Europe','Brussel',NULL,NULL),('3003','Wanderlust','Las Vegas',2,'America','Moscow',NULL,NULL),('3004','Gale','Washington DC',1,'America','Amsterdam',NULL,NULL),('3005','Zephyr','Antwerpen',2,'Europe','Zagreb',NULL,NULL),('3006','Sapphire','Paris',2,'Europe','Madrid',NULL,NULL),('3007','Amazonite','Las Angles',1,'America','Sydney',NULL,NULL),('3008','Atlantis','Kopenhagen',3,'Europe','Eindhoven',NULL,NULL),('3009','Leviathan','Mumbai',2,'Europe','Nairobi',NULL,NULL),('3010','Noah','Barcelona',1,'Europe','Marrakech',NULL,NULL),('3011','Neptune','Mexico-city',1,'America','Melbourne',NULL,NULL),('3012','Wayfarer','Brussel',3,'Europe','Tokyo',NULL,NULL);
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
                        `role_id` int NOT NULL,
                        `ship_id` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `email_UNIQUE` (`email`),
                        UNIQUE KEY `username_UNIQUE` (`username`),
                        UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
                        UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
                        UNIQUE KEY `UKh74ord48otcajdi21yrl7k4d1` (`username`),
                        UNIQUE KEY `UKoshmjvr6wht0bg9oivn75aajr` (`email`),
                        KEY `fk_user_role` (`role_id`),
                        KEY `fk_user_ship_idx` (`ship_id`),
                        CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT,
                        CONSTRAINT `fk_ship_user` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'john@gmail.com','$2a$10$uf9B9HRkQaoMPiYjBUX2V.h5xlxWg4IqiDojqBNJPkgogOgTnptwO','John',3,NULL),(14,'Johnny@gmail.com','$2a$10$smPKe6NO9ewVZFCq9ctGc.mq1cjwOTQaYTkOl5nbGbBFFrIRaUZ7C','Johny',3,NULL),(44,'raihan@gmail.com','$2a$10$md3lI5DHIeqKo3xgz4yUw.p4UN7KU0gmQS739/pzcTXAGcfHf8vA2','Raihan',1,'07202515-a483-464c-b704-5671f104044b'),(45,'bartek@gmail.com','$2a$10$hv6etttPD2sy8or8c4VEO.bkg0iMnMaQ4FUAplofW50xHOpWA0KHq','Bartek',1,'3009'),(46,'vincent@gmail.com','$2a$10$W0cUD0RuJ29Qph5oJ9IVTOFeUxO/BfDwBvpTBXI.NNjEoGv9p26Xa','Vincent',1,'3005'),(47,'milos@gmail.com','$2a$10$krR3URtaD33wODltPAyaKOb3RV94/r26BrzSLFJsadLsizUDm.iEG','Milos',1,'3011'),(48,'jaden@gmail.com','$2a$10$A7F1dwfU.JTy3340gqh/t.1Xb3oXonh93bHBwnu6dRcgolADx.jeO','Jaden',1,'3002'),(49,'jolicoeur@gmail.com','$2a$10$BPWNB1iPK.W0yAtvQ6wFDuKYG4QarszJtvhpzbRBvIBLg5jP4APxu','Joli-Coeur',1,'3010'),(50,'alwine@gmail.com','$2a$10$M1Jz12TyqwUAtgefqN6wkO4N0hSOsIGA/z/TWDVmxPCP6oYf5FJ6O','Alwine',1,'3011'),(51,'khasim@gmail.com','$2a$10$A/Z0/9NP7Q2C0pjvh4bD0ud4l4qmwHyCK/FSQAO0vgQdJHnhljkzW','Khasim',1,'3012'),(52,'veronika@gmail.com','$2a$10$bG5weN5y9iR60oh/xLi8MuPxC/b1tvnFovbmMtAaMqLqCCvh1QEpO','Veronika',1,'07202515-a483-464c-b704-5671f104044b'),(53,'karita@gmail.com','$2a$10$AWexB/A7eb0pb7wQYMymdO8Tq4YlUadrm/eNp6wYfsQZYKKkGrZ/W','Karita',1,'3008'),(54,'sameera@gmail.com','$2a$10$BmPrwEibWUPkdI64p6FFv.WiGB.fFaH.SwTVNQ1MfNc2QSYK5AkKq','Sameera',1,'3010'),(55,'manca@gmail.com','$2a$10$uQ09YS61TBH5ggxwACyMhueVswfrTN3Gk8M4vyQZOOdVa3VBpNHVi','Manca',1,'3002'),(56,'jamilah@gmail.com','$2a$10$6hk.PEs.Q11oTzjbuM0AxuQngZsAx4bMZBbLlJuE68FWzR1hROUYu','Jamilah',1,'07202515-a483-464c-b704-5671f104044b'),(57,'egilmar@gmail.com','$2a$10$SvPRGVfCPjWcbiQV00Jlluq16SAbV8MTl5aX445NufkhT3fr5JkWW','Egilmar',2,NULL),(58,'robin@gmail.com','$2a$10$Au1Ea8gju7QPnxE59uc1b.VARU/qdmuYofEb/uiqlxbQocKOJvdsO','Robin',2,NULL),(59,'neo@gmail.com','$2a$10$kiEIJIRs.zSoVNV9uXqz..QKsjc1MS4PhAfHAznjAQtge2xfVJSwa','Neo',2,NULL),(60,'anubis@gmail.com','$2a$10$8jXZQrF9iFkdrLNTnBd3s.JSIbtanH3MqTuPRlW9eQxnjQ66oZtjm','Anubis',2,NULL),(61,'topher@gmail.com','$2a$10$3Jq3IAgb4g7Pc9oTRmCWIuaMQC9VJUnaBhz5j33s2Qdi.KcplMjtm','Topher',2,NULL);
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

-- Dump completed on 2022-12-19 21:25:17
