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
  `ship_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ship_idx` (`ship_id`),
  CONSTRAINT `fk_ship` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
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
-- Table structure for table `ship`
--

DROP TABLE IF EXISTS `ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ship` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) DEFAULT NULL,
                        `location` varchar(45) NOT NULL,
                        `status` int NOT NULL,
                        `origin` varchar(45) DEFAULT NULL,
                        `destination` varchar(45) DEFAULT NULL,
                        `water_tank1` int DEFAULT NULL,
                        `water_tank2` int DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_status_idx` (`status`),
                        CONSTRAINT `fk_status` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship`
--

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES (1,'Titanic','Pakistan',1,NULL,NULL,NULL,NULL),(2,'Maria','Parijs',2,'Amsterdam','Paris',NULL,NULL);
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
                        `shipID` int DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `email_UNIQUE` (`email`),
                        UNIQUE KEY `username_UNIQUE` (`username`),
                        UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
                        UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
                        KEY `fk_roleIDx` (`roleID`),
                        KEY `ship_fk_idx` (`shipID`),
                        CONSTRAINT `role_fk` FOREIGN KEY (`roleID`) REFERENCES `role` (`id`),
                        CONSTRAINT `ship_fk` FOREIGN KEY (`shipID`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'pietjan@gmail.com','$2a$2a$10$VcdzH8Q.o4KEo6df.XesdOmXdXQwT5ugNQvu1Pl0390rmfOeA1bhS','Jaden',1,NULL),(2,'btynior@gmail.com','$2a$10$Hxv16Y5DtCRXcdbc3U5/zODRnN/o9boyOevGwRxsxsLigRvQ3ebb.','Vincent',2,NULL),(3,'john@gmail.com','$2a$10$uf9B9HRkQaoMPiYjBUX2V.h5xlxWg4IqiDojqBNJPkgogOgTnptwO','John',2,NULL),(4,'peter@gmail.com','$2a$10$sQiuq6I0s1yVDv1yGsMEHeup/ZRgxh2SFh4HlyhK463M3j6QJnmrm','Peter',3,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
                             `user_id` int NOT NULL,
                             `roleID` int NOT NULL,
                             PRIMARY KEY (`user_id`,`roleID`),
                             KEY `fk_roleIDx` (`roleID`),
                             CONSTRAINT `fk_role` FOREIGN KEY (`roleID`) REFERENCES `role` (`id`),
                             CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `watertank`
--

DROP TABLE IF EXISTS `watertank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `watertank` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `amount_in_liters` int NOT NULL,
                             `ship_id` int DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fk_watertank` (`ship_id`),
                             CONSTRAINT `fk_watertank` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `watertank`
--

LOCK TABLES `watertank` WRITE;
/*!40000 ALTER TABLE `watertank` DISABLE KEYS */;
INSERT INTO `watertank` VALUES (1,38,1),(2,44,1);
/*!40000 ALTER TABLE `watertank` ENABLE KEYS */;
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

-- Dump completed on 2022-11-20 17:09:05
