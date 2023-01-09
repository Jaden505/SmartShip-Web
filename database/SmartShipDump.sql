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
INSERT INTO `hibernate_sequence` VALUES (4);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_data`
--

DROP TABLE IF EXISTS `image_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image_data` (
                              `id` bigint NOT NULL,
                              `imagedata` longblob,
                              `name` varchar(255) DEFAULT NULL,
                              `type` varchar(255) DEFAULT NULL,
                              `user_id` int DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKi7geap9u2si719v50b85ar8y3` (`user_id`),
                              CONSTRAINT `FKi7geap9u2si719v50b85ar8y3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_data`
--

LOCK TABLES `image_data` WRITE;
/*!40000 ALTER TABLE `image_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_data` ENABLE KEYS */;
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
  `unit` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ship_fk_idx` (`ship_id`),
  CONSTRAINT `notification_ship_fk` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES (0,'Engine 1 Temperature','Motor',67.68,50.00,'07202515-a483-464c-b704-5671f104044b','2022-07-15 13:10:00','The temperature of Engine 1 has exceeded the given temperature.',67.68,NULL,NULL,NULL),(1,'Wind Speed','Sea Conditions ',7.00,9.00,'3001','2022-06-14 12:09:00','The speed of the ship is slower than your setted up value.',7,NULL,NULL,NULL),(2,'Depletion Rate','Fuel',15.00,10.00,'3002','2022-05-13 11:08:00','The depletion rate of the fuel is greater than your setted up value.',15,NULL,NULL,NULL),(3,'Percentage Left','Battery',15.00,20.00,'3003','2022-04-12 10:07:00','The battery has less percentage than your setted up value',15,NULL,NULL,NULL);
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_token`
--

DROP TABLE IF EXISTS `password_reset_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_token` (
                                        `id` bigint NOT NULL,
                                        `expiry_date` datetime(6) DEFAULT NULL,
                                        `token` varchar(255) DEFAULT NULL,
                                        `user_id` int NOT NULL,
                                        PRIMARY KEY (`id`),
                                        KEY `FKjthxr8d7rmlunj1uv3lt1xvl5` (`user_id`),
                                        CONSTRAINT `FKjthxr8d7rmlunj1uv3lt1xvl5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_token`
--

LOCK TABLES `password_reset_token` WRITE;
/*!40000 ALTER TABLE `password_reset_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_token` ENABLE KEYS */;
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
                               `sensor_group` varchar(255) DEFAULT NULL,
                               `sensor_name` varchar(255) DEFAULT NULL,
                               `ship_id` varchar(255) NOT NULL,
                               `speed` varchar(255) DEFAULT NULL,
                               `time` datetime(6) DEFAULT NULL,
                               `type` varchar(255) DEFAULT NULL,
                               `unit` varchar(255) DEFAULT NULL,
                               `value` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`sensor_id`),
                               KEY `fk_sensor_ship_idx` (`ship_id`),
                               CONSTRAINT `fk_sensor_ship` FOREIGN KEY (`ship_id`) REFERENCES `ship` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensor_data`
--

LOCK TABLES `sensor_data` WRITE;
/*!40000 ALTER TABLE `sensor_data` DISABLE KEYS */;
INSERT INTO `sensor_data` VALUES ('05VJZSGKERRMYXONKZIY','N52°3\'53.754','E3°40\'54.03299999999982','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:25:10.000000','Temperature','Celcius','67.02'),('0CPQ6T7PSACHRLTWAX3V','N52°3\'53.754','E3°40\'53.532999999999916','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:16:50.000000','Temperature','Celcius','67.86'),('0FZSYRM9CHQB0UR6BYWR','N52°3\'53.754','E3°40\'54.27299999999977','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:29:10.000000','Temperature','Celcius','67.92'),('0L3KE0FJ2S3T6RA4Q2XQ','N52°3\'53.754','E3°40\'53.492999999999924','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:16:10.000000','Temperature','Celcius','67.04'),('1KW4WHKJIHQR386NMQGP','N52°3\'53.754','E3°40\'54.00299999999982','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:24:40.000000','Temperature','Celcius','67.23'),('1PQ8ZPQYEP8GYPG1IZA3','N52°3\'53.754','E3°40\'53.70299999999988','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:19:40.000000','Temperature','Celcius','67.34'),('20B3TPPOYFGIVRNPYSTN','N52°3\'53.754','E3°40\'53.992999999999824','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:24:30.000000','Temperature','Celcius','67.19'),('25TT04VTG1U1ILKAA6G3','N52°3\'53.754','E3°40\'54.55299999999971','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:33:50.000000','Temperature','Celcius','67.95'),('29383I5DY46LX80IAEK5','N52°3\'53.754','E3°40\'54.25299999999977','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:28:50.000000','Temperature','Celcius','67.44'),('2IHU3OV5TJ2Q1EIUIJVB','N52°3\'53.754','E3°40\'53.40299999999994','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:14:40.000000','Temperature','Celcius','67.26'),('2LV8F69141ZO0Q1ZWADD','N52°3\'53.754','E3°40\'54.67299999999969','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:35:50.000000','Temperature','Celcius','67.58'),('2N260L8NZBVNUI0YK7GO','N52°3\'53.754','E3°40\'54.6229999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:35:00.000000','Temperature','Celcius','67.97'),('3029D4Y5U3IHSLKF6E2Y','N52°3\'53.754','E3°40\'54.18299999999979','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:27:40.000000','Temperature','Celcius','67.24'),('3H54X42RMWLED4BKKWYF','N52°3\'53.754','E3°40\'54.66299999999969','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:35:40.000000','Temperature','Celcius','67.32'),('3MY8B2TUH82BWAVVOJN2','N52°3\'53.754','E3°40\'54.53299999999972','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:33:30.000000','Temperature','Celcius','67.91'),('3TR5KBJ0839XI9G42WXQ','N52°3\'53.754','E3°40\'53.542999999999914','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:17:00.000000','Temperature','Celcius','67.72'),('3TSXE02PE1KYNHBBLQ4J','N52°3\'53.754','E3°40\'53.6129999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:18:10.000000','Temperature','Celcius','67.09'),('410AAY4968A2B3FBYOBD','N52°3\'53.754','E3°40\'53.52299999999992','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:16:40.000000','Temperature','Celcius','67.86'),('42NTDCDG77CYX3BG2VQX','N52°3\'53.754','E3°40\'53.86299999999985','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:22:20.000000','Temperature','Celcius','67.63'),('4523QX1MSLRR4NTCU4QV','N52°3\'53.754','E3°40\'54.242999999999775','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:28:40.000000','Temperature','Celcius','67.05'),('45KTIOMJW3HRC6BBR0SI','N52°3\'53.754','E3°40\'53.36299999999995','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:14:00.000000','Temperature','Celcius','67.68'),('4A8OT755E39K35RMJAVC','N52°3\'53.754','E3°40\'53.882999999999846','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:22:40.000000','Temperature','Celcius','67.88'),('4AUZPED7QUCKFZMCW7OF','N52°3\'53.754','E3°40\'53.742999999999874','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:20:20.000000','Temperature','Celcius','67.54'),('4K981R5VY25S29CAR5CY','N52°3\'53.754','E3°40\'54.71299999999968','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:36:30.000000','Temperature','Celcius','67.76'),('4W8ROXOEDVGJOEFNY5P6','N52°3\'53.754','E3°40\'53.482999999999926','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:16:00.000000','Temperature','Celcius','67.58'),('551TJILAGXQ0JMBFXW06','N52°3\'53.754','E3°40\'53.71299999999988','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:19:50.000000','Temperature','Celcius','67.18'),('5C9E9ZF4N3II6YNPYMHE','N52°3\'53.754','E3°40\'54.51299999999972','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:33:10.000000','Temperature','Celcius','67.21'),('5LNIPAKEQK0NWQ11DQC2','N52°3\'53.754','E3°40\'53.582999999999906','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:17:40.000000','Temperature','Celcius','67.54'),('5TUK329XFZHGMRBIKZ8J','N52°3\'53.754','E3°40\'53.842999999999854','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:22:00.000000','Temperature','Celcius','67.1'),('5V7ZVYRXAYFMW8A6L23D','N52°3\'53.754','E3°40\'54.46299999999973','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:32:20.000000','Temperature','Celcius','67.42'),('5YZLC12PBL6JKJ3KMA3F','N52°3\'53.754','E3°40\'54.1129999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:26:30.000000','Temperature','Celcius','67.28'),('643FRTUZTKKQEA8UJKHD','N52°3\'53.754','E3°40\'54.36299999999975','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:30:40.000000','Temperature','Celcius','67.66'),('6HM3JJ0EGJVCSDMSKKHH','N52°3\'53.754','E3°40\'54.1329999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:26:50.000000','Temperature','Celcius','67.65'),('6KTF3QZZ87LTTTNOPFZM','N52°3\'53.754','E3°40\'53.332999999999956','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:13:30.000000','Temperature','Celcius','67.79'),('6R16O4X2Q8QOTLV8KS5Y','N52°3\'53.754','E3°40\'54.28299999999977','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:29:20.000000','Temperature','Celcius','67.63'),('6UGLJWBGEOMN4QF3S0F6','N52°3\'53.754','E3°40\'54.68299999999969','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:36:00.000000','Temperature','Celcius','67.82'),('6Z1BR6YGBPTUEA9WHYMA','N52°3\'53.754','E3°40\'54.342999999999755','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:30:20.000000','Temperature','Celcius','67.21'),('717ND65GIZDJLU832QWU','N52°3\'53.754','E3°40\'53.942999999999834','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:23:40.000000','Temperature','Celcius','67.03'),('79INEHICRZ2Z9SFALWXQ','N52°3\'53.754','E3°40\'54.092999999999805','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:26:10.000000','Temperature','Celcius','67.62'),('7CP9YZFPRXCDMHHVPGBU','N52°3\'53.754','E3°40\'54.90299999999964','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:39:40.000000','Temperature','Celcius','67.25'),('7QKVR4IUUCG6ZOPN1TXU','N52°3\'53.754','E3°40\'53.57299999999991','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:17:30.000000','Temperature','Celcius','67.82'),('7S7K6DP9T8SA90UW8YHM','N52°3\'53.754','E3°40\'53.82299999999986','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:21:40.000000','Temperature','Celcius','67.63'),('82PKD7T5PCGWVTSNA75P','N52°3\'53.754','E3°40\'54.20299999999978','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:28:00.000000','Temperature','Celcius','67.68'),('84HO5PA78J6BQX58FJ4H','N52°3\'53.754','E3°40\'53.15299999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:10:30.000000','Temperature','Celcius','67.43'),('88AS1S1KBYEYXIK5W05X','N52°3\'53.754','E3°40\'54.6029999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:34:40.000000','Temperature','Celcius','67.35'),('8EBV39SQDR11NV7AEO8W','N52°3\'53.754','E3°40\'54.06299999999981','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:25:40.000000','Temperature','Celcius','67.02'),('8F70T7L3CY3PJVHL7F89','N52°3\'53.754','E3°40\'53.47299999999993','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:15:50.000000','Temperature','Celcius','67.14'),('8GZBH941VUXLLDGAFS88','N52°3\'53.754','E3°40\'53.832999999999856','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:21:50.000000','Temperature','Celcius','67.19'),('8MVJ3PXQ5PLV3B2G4EAB','N52°3\'53.754','E3°40\'53.66299999999989','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:19:00.000000','Temperature','Celcius','67.14'),('8PUO2FURGZA54O6DBB5K','N52°3\'53.754','E3°40\'53.892999999999844','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:22:50.000000','Temperature','Celcius','67.27'),('8S4P2S0MS8YKL1Q63O3L','N52°3\'53.754','E3°40\'53.16299999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:10:40.000000','Temperature','Celcius','67.42'),('90UTTL0IVR4RMIL3G5LQ','N52°3\'53.754','E3°40\'53.932999999999836','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:23:30.000000','Temperature','Celcius','67.08'),('94RCTHFI3YVAYOLF46PS','N52°3\'53.754','E3°40\'53.96299999999983','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:24:00.000000','Temperature','Celcius','67.1'),('9DGY7WLK0ATTDTG271AC','N52°3\'53.754','E3°40\'53.87299999999985','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:22:30.000000','Temperature','Celcius','67.79'),('9I8BFIUMO9RQAVIB2AC7','N52°3\'53.754','E3°40\'53.51299999999992','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:16:30.000000','Temperature','Celcius','67.14'),('9MO9IW3152NQVSZ03WUV','N52°3\'53.754','E3°40\'53.32299999999996','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:13:20.000000','Temperature','Celcius','67.48'),('9Q3P6PZQMKWQHIMMR9BK','N52°3\'53.754','E3°40\'53.142999999999994','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:10:20.000000','Temperature','Celcius','67.45'),('9VVH5G61LF7JCH7V9189','N52°3\'53.754','E3°40\'53.75299999999987','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:20:30.000000','Temperature','Celcius','67.56'),('9YUEHZIRV26IAOHMK1U2','N52°3\'53.754','E3°40\'53.592999999999904','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:17:50.000000','Temperature','Celcius','67.78'),('ABZV6V141ZE9YKQ6AJES','N52°3\'53.754','E3°40\'54.81299999999966','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:38:10.000000','Temperature','Celcius','67.56'),('AMDO7N309NG8HLBFEBNX','N52°3\'53.754','E3°40\'54.16299999999979','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:27:20.000000','Temperature','Celcius','67.44'),('AXOJPPC2LVV963KE6ZKQ','N52°3\'53.754','E3°40\'53.692999999999884','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:19:30.000000','Temperature','Celcius','67.15'),('AY1UQDPWFIJPGXKY2U7R','N52°3\'53.754','E3°40\'54.042999999999815','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:25:20.000000','Temperature','Celcius','67.46'),('B05VKEY7XRMSDQ6TTJHY','N52°3\'53.754','E3°40\'53.382999999999946','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:14:20.000000','Temperature','Celcius','67.78'),('bb7baec4-c049-45c5-81ce-2715801','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Direction','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7'),('bb7baec4-c049-45c5-81ce-27158016bfff','N52°3\'53.754','E3°40\'53.123','Fuel','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','T/H','15'),('bb7baec4-c049-45c5-81ce-2715801bff','N52°3\'53.754','E3°40\'53.123','Battery','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15'),('bb7baec4-c049-45c5-81ce-2715801e','N52°3\'53.754','E3°40\'53.123','Sea Conditions','Wind Speed','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Speed','kts','7'),('bb7baec4-c049-45c5-81ce-2715801e6b','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68'),('bb7baec4-c049-45c5-81ce-2715801e6bfff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68'),('bb7baec4-c049-45c5-81ce-2715801e6bffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Oil Level','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Quantity','L','350'),('bb7baec4-c049-45c5-81ce-2715801e6bffffff','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 RPM','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','RPM','RPM','65'),('bb7baec4-c049-45c5-81ce-2715801e6bfffffff','N52°3\'53.754','E3°40\'53.123','Battery','Depletion Rate','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','KW/H','15'),('bb7baec4-c049-45c5-81ce-271801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15'),('bb7baec4-c049-45c5-82ce-2715801e6bff','N52°3\'53.754','E3°40\'53.123','Fuel','Percentage Left','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Depletion rate','%','15'),('BEPRGZO2ODJAITM1YII9','N52°3\'53.754','E3°40\'54.42299999999974','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:31:40.000000','Temperature','Celcius','67.93'),('BIJHA77TKKO49AA69MSR','N52°3\'53.754','E3°40\'54.77299999999967','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:37:30.000000','Temperature','Celcius','67.85'),('BQOTCRWA3HCMKAZDF17L','N52°3\'53.754','E3°40\'53.65299999999989','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:18:50.000000','Temperature','Celcius','67.27'),('BRDMMWVYK3ZXJ6J6Q2I4','N52°3\'53.754','E3°40\'53.17299999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:10:50.000000','Temperature','Celcius','67.87'),('C9EYI35FY627RNN58U4A','N52°3\'53.754','E3°40\'53.37299999999995','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:14:10.000000','Temperature','Celcius','67.04'),('CMEUCLXYAK02VYCJATWK','N52°3\'53.754','E3°40\'54.73299999999968','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:36:50.000000','Temperature','Celcius','67.45'),('CMR871JOULZVP5P4E8R0','N52°3\'53.754','E3°40\'54.292999999999765','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:29:30.000000','Temperature','Celcius','67.4'),('CMXMNN71OOSRMLB9JV3G','N52°3\'53.754','E3°40\'54.26299999999977','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:29:00.000000','Temperature','Celcius','67.66'),('CW73U5BEX49JGJQJAJ5S','N52°3\'53.754','E3°40\'54.57299999999971','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:34:10.000000','Temperature','Celcius','67.04'),('DJ4R9XHB88V7Y8R1ZVYT','N52°3\'53.754','E3°40\'53.67299999999989','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:19:10.000000','Temperature','Celcius','67.63'),('DKC5GRLQ62OIT0WNHWG9','N52°3\'53.754','E3°40\'53.732999999999876','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:20:10.000000','Temperature','Celcius','67.96'),('DLITBVU2WWTB5QJB6QP1','N52°3\'53.754','E3°40\'54.08299999999981','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:26:00.000000','Temperature','Celcius','67.71'),('DWF4PV2CIOCP0HU412TW','N52°3\'53.754','E3°40\'54.1229999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:26:40.000000','Temperature','Celcius','67.77'),('DYQSE9GGFNCYASI70W2E','N52°3\'53.754','E3°40\'53.792999999999864','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:21:10.000000','Temperature','Celcius','67.4'),('EDY8XLW9OC3OUKEMACV4','N52°3\'53.754','E3°40\'53.6229999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:18:20.000000','Temperature','Celcius','67.21'),('EFLT3A3HSVWHEHTJ5PCR','N52°3\'53.754','E3°40\'53.90299999999984','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:23:00.000000','Temperature','Celcius','67.97'),('ESWTZ00PWFN369P0WZR2','N52°3\'53.754','E3°40\'53.132999999999996','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:10:10.000000','Temperature','Celcius','67.01'),('F4K2MZOBW1N6I75NQ591','N52°3\'53.754','E3°40\'53.30299999999996','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:13:00.000000','Temperature','Celcius','67.43'),('FP65JSQN5VDXVNIMHTTN','N52°3\'53.754','E3°40\'53.182999999999986','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:11:00.000000','Temperature','Celcius','67.39'),('FYFM4O1M3M5KK3N6XVKR','N52°3\'53.754','E3°40\'54.37299999999975','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:30:50.000000','Temperature','Celcius','67.46'),('G1D2PU4FJ2YRZXIPHXAM','N52°3\'53.754','E3°40\'53.22299999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:11:40.000000','Temperature','Celcius','67.16'),('G20EVHBIG6PL2KWNG76F','N52°3\'53.754','E3°40\'54.842999999999655','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:38:40.000000','Temperature','Celcius','67.56'),('G61QRF5M5LYOIWX7RXLA','N52°3\'53.754','E3°40\'53.282999999999966','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:12:40.000000','Temperature','Celcius','67.24'),('G7SVCA74TRGQJWKTA84K','N52°3\'53.754','E3°40\'53.632999999999896','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:18:30.000000','Temperature','Celcius','67.53'),('GHN4JOX264FNDKEOM9LB','N52°3\'53.754','E3°40\'54.1029999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:26:20.000000','Temperature','Celcius','67.79'),('GK27EBV3PPI9S00IRFWK','N52°3\'53.754','E3°40\'54.87299999999965','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:39:10.000000','Temperature','Celcius','67.28'),('GSHB1FFDLCTGBN8PXWXK','N52°3\'53.754','E3°40\'53.35299999999995','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:13:50.000000','Temperature','Celcius','67.18'),('H1Y6Q55N4W6T69ZFHMYX','N52°3\'53.754','E3°40\'54.41299999999974','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:31:30.000000','Temperature','Celcius','67.81'),('HCQAXEFIDGLU1IKCJQVN','N52°3\'53.754','E3°40\'54.32299999999976','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:30:00.000000','Temperature','Celcius','67.43'),('HDR8I6MGN1BUKZSY3L5G','N52°3\'53.754','E3°40\'53.45299999999993','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:15:30.000000','Temperature','Celcius','67.0'),('HXJXXGOMH7VQOXPAU5C9','N52°3\'53.754','E3°40\'53.41299999999994','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:14:50.000000','Temperature','Celcius','67.29'),('I2A0A83AG7OQEJ6HRYKY','N52°3\'53.754','E3°40\'54.30299999999976','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:29:40.000000','Temperature','Celcius','67.5'),('I6ZZF7339ZK6JTE75FHG','N52°3\'53.754','E3°40\'53.31299999999996','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:13:10.000000','Temperature','Celcius','67.88'),('I8VYQOA8N9OS6J1GCM2H','N52°3\'53.754','E3°40\'54.6329999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:35:10.000000','Temperature','Celcius','67.48'),('ICU6NXTN9X1T8B8MYRU4','N52°3\'53.754','E3°40\'53.72299999999988','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:20:00.000000','Temperature','Celcius','67.85'),('IG0CRTO7L4WCWKWP3WXM','N52°3\'53.754','E3°40\'54.72299999999968','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:36:40.000000','Temperature','Celcius','67.09'),('IKQ9XLU7L86RXJRT5RJX','N52°3\'53.754','E3°40\'54.31299999999976','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:29:50.000000','Temperature','Celcius','67.14'),('IPCDQN4O0IRXCUYJLZDH','N52°3\'53.754','E3°40\'53.392999999999944','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:14:30.000000','Temperature','Celcius','67.44'),('IQ7FTRIZF4XYF72QHLSC','N52°3\'53.754','E3°40\'54.91299999999964','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:39:50.000000','Temperature','Celcius','67.39'),('IRXVLG5SLD8JSXE987JZ','N52°3\'53.754','E3°40\'53.682999999999886','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:19:20.000000','Temperature','Celcius','67.08'),('J7B80MWWS4W4C1RUBBVT','N52°3\'53.754','E3°40\'53.56299999999991','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:17:20.000000','Temperature','Celcius','67.39'),('JGUFBYWCIPSS3RZJTLWX','N52°3\'53.754','E3°40\'53.432999999999936','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:15:10.000000','Temperature','Celcius','67.69'),('JLM99RBGQNPMQOG8DU26','N52°3\'53.754','E3°40\'54.692999999999685','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:36:10.000000','Temperature','Celcius','67.65'),('JTMGTT3RA7CI0KD0HLMB','N52°3\'53.754','E3°40\'53.80299999999986','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:21:20.000000','Temperature','Celcius','67.98'),('KETVMR3EMSAZEP6BOHH7','N52°3\'53.754','E3°40\'53.46299999999993','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:15:40.000000','Temperature','Celcius','67.92'),('KO95O72RS62Q9NEMBNF4','N52°3\'53.754','E3°40\'54.742999999999675','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:37:00.000000','Temperature','Celcius','67.64'),('KZR7QAV4S47BCYOA68CY','N52°3\'53.754','E3°40\'53.85299999999985','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:22:10.000000','Temperature','Celcius','67.82'),('LBMNMIQWQNQI276HNEHH','N52°3\'53.754','E3°40\'53.95299999999983','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:23:50.000000','Temperature','Celcius','67.87'),('LGZQK5WBX535RH0671GZ','N52°3\'53.754','E3°40\'54.76299999999967','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:37:20.000000','Temperature','Celcius','67.57'),('LWJWXOTREF3YBMXK2E7O','N52°3\'53.754','E3°40\'53.98299999999983','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:24:20.000000','Temperature','Celcius','67.01'),('M07F5ZP38R4F85SM6Y0Z','N52°3\'53.754','E3°40\'54.492999999999725','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:32:50.000000','Temperature','Celcius','67.46'),('MW6BE5YYJW09CGKAWRST','N52°3\'53.754','E3°40\'54.642999999999695','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:35:20.000000','Temperature','Celcius','67.55'),('N78X6XY0TR3OZUJ0UA4Q','N52°3\'53.754','E3°40\'53.25299999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:12:10.000000','Temperature','Celcius','67.77'),('N7TD0OF5C7L5GBZTQ4TA','N52°3\'53.754','E3°40\'54.40299999999974','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:31:20.000000','Temperature','Celcius','67.84'),('NSRWLMO77NTWM3VOILDV','N52°3\'53.754','E3°40\'54.142999999999795','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:27:00.000000','Temperature','Celcius','67.63'),('NVTNM27R8T1DM30AVUK6','N52°3\'53.754','E3°40\'54.35299999999975','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:30:30.000000','Temperature','Celcius','67.15'),('NXDUDE9ZJEDM6VXT6BFD','N52°3\'53.754','E3°40\'54.592999999999705','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:34:30.000000','Temperature','Celcius','67.65'),('O1A9422ZXC1WVUAKUO5X','N52°3\'53.754','E3°40\'54.07299999999981','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:25:50.000000','Temperature','Celcius','67.34'),('O4ZLKWDK42DJDK9L1AHC','N52°3\'53.754','E3°40\'53.342999999999954','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:13:40.000000','Temperature','Celcius','67.08'),('O90NMIGC49DJJ12UFL7N','N52°3\'53.754','E3°40\'54.80299999999966','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:38:00.000000','Temperature','Celcius','67.04'),('O976QZJJN521MDX47MVE','N52°3\'53.754','E3°40\'54.86299999999965','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:39:00.000000','Temperature','Celcius','67.23'),('P09FC49SI3SHSSZ4F88Z','N52°3\'53.754','E3°40\'54.85299999999965','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:38:50.000000','Temperature','Celcius','67.33'),('PBR1AQ2Q7IZKGK3KOP5Y','N52°3\'53.754','E3°40\'53.292999999999964','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:12:50.000000','Temperature','Celcius','67.32'),('PG2X0RJJNHDE2TXZMF6E','N52°3\'53.754','E3°40\'53.20299999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:11:20.000000','Temperature','Celcius','67.72'),('PNWE9JHSQQ4PNB1IH6YB','N52°3\'53.754','E3°40\'54.05299999999981','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:25:30.000000','Temperature','Celcius','67.93'),('PVI3NKPF3SKS3AUVS4DB','N52°3\'53.754','E3°40\'53.50299999999992','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:16:20.000000','Temperature','Celcius','67.74'),('PZEFGTSZJW643IB5YXV6','N52°3\'53.754','E3°40\'53.642999999999894','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:18:40.000000','Temperature','Celcius','67.18'),('PZNX31FZHHA7JVQJVGMO','N52°3\'53.754','E3°40\'53.192999999999984','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:11:10.000000','Temperature','Celcius','67.29'),('Q1BBKU2VA7EUKAQVRIP4','N52°3\'53.754','E3°40\'54.43299999999974','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:31:50.000000','Temperature','Celcius','67.66'),('QCMFMMODB0Q2FHLDS8IF','N52°3\'53.754','E3°40\'54.78299999999967','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:37:40.000000','Temperature','Celcius','67.94'),('QG9Q030NMB3O1R1GHNXQ','N52°3\'53.754','E3°40\'54.792999999999665','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:37:50.000000','Temperature','Celcius','67.37'),('QNZUZZNY7TU142RHT8JW','N52°3\'53.754','E3°40\'54.22299999999978','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:28:20.000000','Temperature','Celcius','67.27'),('RDFQD2NHKJW0X7DHAO5V','N52°3\'53.754','E3°40\'54.192999999999785','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:27:50.000000','Temperature','Celcius','67.99'),('RPJC4H31B8I5P11ZEZ06','N52°3\'53.754','E3°40\'54.15299999999979','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:27:10.000000','Temperature','Celcius','67.52'),('RRL7E6Y79JG0ILZS1MN3','N52°3\'53.754','E3°40\'53.442999999999934','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:15:20.000000','Temperature','Celcius','67.16'),('RSP86K2HXOV1IO5HLSNQ','N52°3\'53.754','E3°40\'53.55299999999991','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:17:10.000000','Temperature','Celcius','67.66'),('RZ8EZ99059G02OH2XCZH','N52°3\'53.754','E3°40\'54.47299999999973','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:32:30.000000','Temperature','Celcius','67.75'),('S6KTSXWUZIKZIIBFYCF8','N52°3\'53.754','E3°40\'54.83299999999966','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:38:30.000000','Temperature','Celcius','67.9'),('SH3VBRX7P5AH2680ZFAG','N52°3\'53.754','E3°40\'54.892999999999645','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:39:30.000000','Temperature','Celcius','67.88'),('SJHM7H37VNW6B1OTX6BW','N52°3\'53.754','E3°40\'53.76299999999987','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:20:40.000000','Temperature','Celcius','67.11'),('SNC4M387OY6JZ04W45TT','N52°3\'53.754','E3°40\'54.82299999999966','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','13.0','2022-07-15 13:38:20.000000','Temperature','Celcius','67.37'),('SNUNSWNJHLO07U1C52BZ','N52°3\'53.754','E3°40\'53.21299999999998','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:11:30.000000','Temperature','Celcius','67.57'),('SUUJXQF5ITLVCG71CDTE','N52°3\'53.754','E3°40\'54.17299999999979','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:27:30.000000','Temperature','Celcius','67.58'),('T24Y0G11RYWM0HFTCXN2','N52°3\'53.754','E3°40\'53.6029999999999','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:18:00.000000','Temperature','Celcius','67.91'),('TAZ9FPDUL55EERPVZ4PQ','N52°3\'53.754','E3°40\'54.52299999999972','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.0','2022-07-15 13:33:20.000000','Temperature','Celcius','67.87'),('TEKETV014VZ8DWJUQP60','N52°3\'53.754','E3°40\'53.92299999999984','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:23:20.000000','Temperature','Celcius','67.61'),('TN37UTPW0ER61KSM3N1L','N52°3\'53.754','E3°40\'54.33299999999976','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:30:10.000000','Temperature','Celcius','67.67'),('TOSHOUY2FLO9E337WT8W','N52°3\'53.754','E3°40\'54.50299999999972','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:33:00.000000','Temperature','Celcius','67.83'),('TPPIHHUCLKO4N0CXMXHD','N52°3\'53.754','E3°40\'54.45299999999973','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:32:10.000000','Temperature','Celcius','67.25'),('TQ6IA5RTW7RIAO7PB3CU','N52°3\'53.754','E3°40\'53.81299999999986','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:21:30.000000','Temperature','Celcius','67.48'),('U3TFC9BCUD8P24DVQ7S0','N52°3\'53.754','E3°40\'53.77299999999987','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:20:50.000000','Temperature','Celcius','67.79'),('U6NLLQ0S974MEVG7Y070','N52°3\'53.754','E3°40\'54.58299999999971','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:34:20.000000','Temperature','Celcius','67.63'),('U7MVDLRI6E6U7JKTOXJ7','N52°3\'53.754','E3°40\'54.70299999999968','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:36:20.000000','Temperature','Celcius','67.48'),('UIDXR2MO0W0I1SEINK6F','N52°3\'53.754','E3°40\'54.01299999999982','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:24:50.000000','Temperature','Celcius','67.23'),('UNMJV6HTY3ZZ6VGY8K6W','N52°3\'53.754','E3°40\'53.242999999999974','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:12:00.000000','Temperature','Celcius','67.26'),('V04VIQE5EQ52TY49TPZ2','N52°3\'53.754','E3°40\'53.26299999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:12:20.000000','Temperature','Celcius','67.85'),('V1JKS8MSV9IYRRGYD8CJ','N52°3\'53.754','E3°40\'53.91299999999984','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:23:10.000000','Temperature','Celcius','67.48'),('V4BRH70VO6GEP5O7KSCD','N52°3\'53.754','E3°40\'54.88299999999965','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:39:20.000000','Temperature','Celcius','67.71'),('V9CNSJXANLQTGF07WMGN','N52°3\'53.754','E3°40\'54.392999999999745','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:31:10.000000','Temperature','Celcius','67.5'),('VDHZWKHPLU8F72K3886D','N52°3\'53.754','E3°40\'54.38299999999975','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:31:00.000000','Temperature','Celcius','67.61'),('VFOFELU5435ZLJ4C2W5Y','N52°3\'53.754','E3°40\'54.02299999999982','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:25:00.000000','Temperature','Celcius','67.99'),('VM0F78E7J6WLIE8KJ6TC','N52°3\'53.754','E3°40\'53.123','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:10:00.000000','Temperature','Celcius','67.68'),('VWWO94X6NOAMVILX8F3X','N52°3\'53.754','E3°40\'53.97299999999983','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:24:10.000000','Temperature','Celcius','67.33'),('W44U70647MD9PIBF9MF7','N52°3\'53.754','E3°40\'53.782999999999866','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:21:00.000000','Temperature','Celcius','67.74'),('WGE32T7SU4NYJXOSBWH8','N52°3\'53.754','E3°40\'54.56299999999971','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:34:00.000000','Temperature','Celcius','67.54'),('WHFO35FHSY9TM2KH9FM2','N52°3\'53.754','E3°40\'53.232999999999976','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.3','2022-07-15 13:11:50.000000','Temperature','Celcius','67.32'),('X21Y7GGFGFAGDV74PX5Q','N52°3\'53.754','E3°40\'54.6129999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.6','2022-07-15 13:34:50.000000','Temperature','Celcius','67.64'),('X3OP0MWS1UB8608347S4','N52°3\'53.754','E3°40\'54.23299999999978','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.1','2022-07-15 13:28:30.000000','Temperature','Celcius','67.15'),('XFNCFINFLXNV0HBT0JQ5','N52°3\'53.754','E3°40\'54.21299999999978','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.7','2022-07-15 13:28:10.000000','Temperature','Celcius','67.5'),('XM1F9T5Q550Y4A1NWAM4','N52°3\'53.754','E3°40\'53.42299999999994','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:15:00.000000','Temperature','Celcius','67.86'),('XRKY7RDD34XS5UYNLVRZ','N52°3\'53.754','E3°40\'53.27299999999997','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.5','2022-07-15 13:12:30.000000','Temperature','Celcius','67.22'),('YUDI72C89CV41Y2CDLQK','N52°3\'53.754','E3°40\'54.75299999999967','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:37:10.000000','Temperature','Celcius','67.32'),('YXJ067UQ6EAW0M9CYOV3','N52°3\'53.754','E3°40\'54.48299999999973','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.4','2022-07-15 13:32:40.000000','Temperature','Celcius','67.22'),('Z17WGO9MXGH61CG45XB1','N52°3\'53.754','E3°40\'54.65299999999969','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.2','2022-07-15 13:35:30.000000','Temperature','Celcius','67.19'),('Z8AVPDNFNDKESC4GRLLA','N52°3\'53.754','E3°40\'54.542999999999715','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.9','2022-07-15 13:33:40.000000','Temperature','Celcius','67.09'),('ZV3BOU5TLY10HYSQENJ3','N52°3\'53.754','E3°40\'54.442999999999735','Motor','Engine 1 Temperature','07202515-a483-464c-b704-5671f104044b','12.8','2022-07-15 13:32:00.000000','Temperature','Celcius','67.66');
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
                        `status` int NOT NULL,
                        `gps_latitude` varchar(255) DEFAULT NULL,
                        `gps_longtitude` varchar(255) DEFAULT NULL,
                        `tank1` int DEFAULT NULL,
                        `tank2` int DEFAULT NULL,
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
INSERT INTO `ship` VALUES ('07202515-a483-464c-b704-5671f104044b','Serendipity',1,NULL,NULL,1599,1300),('3001','Imagination',2,NULL,NULL,NULL,NULL),('3002','Liberty',3,NULL,NULL,NULL,NULL),('3003','Wanderlust',2,NULL,NULL,NULL,NULL),('3004','Gale',1,NULL,NULL,NULL,NULL),('3005','Zephyr',2,NULL,NULL,NULL,NULL),('3006','Sapphire',2,NULL,NULL,NULL,NULL),('3007','Amazonite',1,NULL,NULL,NULL,NULL),('3008','Atlantis',3,NULL,NULL,NULL,NULL),('3009','Leviathan',2,NULL,NULL,NULL,NULL),('3010','Noah',1,NULL,NULL,NULL,NULL),('3011','Neptune',1,NULL,NULL,NULL,NULL),('3012','Wayfarer',3,NULL,NULL,NULL,NULL);
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
                        `address` varchar(255) DEFAULT NULL,
                        `city` varchar(255) DEFAULT NULL,
                        `country` varchar(255) DEFAULT NULL,
                        `dateofbirth` date DEFAULT NULL,
                        `firstname` varchar(255) DEFAULT NULL,
                        `gender` varchar(255) DEFAULT NULL,
                        `lastname` varchar(255) DEFAULT NULL,
                        `nationality` varchar(255) DEFAULT NULL,
                        `phonenumber` varchar(255) DEFAULT NULL,
                        `postalcode` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'john@gmail.com','$2a$10$uf9B9HRkQaoMPiYjBUX2V.h5xlxWg4IqiDojqBNJPkgogOgTnptwO','John',3,'07202515-a483-464c-b704-5671f104044b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'Johnny@gmail.com','$2a$10$smPKe6NO9ewVZFCq9ctGc.mq1cjwOTQaYTkOl5nbGbBFFrIRaUZ7C','Johny',3,'3009',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'raihan@gmail.com','$2a$10$md3lI5DHIeqKo3xgz4yUw.p4UN7KU0gmQS739/pzcTXAGcfHf8vA2','Raihan',1,'07202515-a483-464c-b704-5671f104044b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(45,'bartek@gmail.com','$2a$10$hv6etttPD2sy8or8c4VEO.bkg0iMnMaQ4FUAplofW50xHOpWA0KHq','Bartek',1,'3009',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,'vincent@gmail.com','$2a$10$W0cUD0RuJ29Qph5oJ9IVTOFeUxO/BfDwBvpTBXI.NNjEoGv9p26Xa','Vincent',1,'3005',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,'milos@gmail.com','$2a$10$krR3URtaD33wODltPAyaKOb3RV94/r26BrzSLFJsadLsizUDm.iEG','Milos',1,'3011',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(48,'jaden@gmail.com','$2a$10$A7F1dwfU.JTy3340gqh/t.1Xb3oXonh93bHBwnu6dRcgolADx.jeO','Jaden',1,'3002',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(49,'jolicoeur@gmail.com','$2a$10$BPWNB1iPK.W0yAtvQ6wFDuKYG4QarszJtvhpzbRBvIBLg5jP4APxu','Joli-Coeur',1,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,'alwine@gmail.com','$2a$10$M1Jz12TyqwUAtgefqN6wkO4N0hSOsIGA/z/TWDVmxPCP6oYf5FJ6O','Alwine',1,'3011',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,'khasim@gmail.com','$2a$10$A/Z0/9NP7Q2C0pjvh4bD0ud4l4qmwHyCK/FSQAO0vgQdJHnhljkzW','Khasim',1,'3012',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(52,'veronika@gmail.com','$2a$10$bG5weN5y9iR60oh/xLi8MuPxC/b1tvnFovbmMtAaMqLqCCvh1QEpO','Veronika',1,'07202515-a483-464c-b704-5671f104044b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(53,'karita@gmail.com','$2a$10$AWexB/A7eb0pb7wQYMymdO8Tq4YlUadrm/eNp6wYfsQZYKKkGrZ/W','Karita',1,'3008',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,'sameera@gmail.com','$2a$10$BmPrwEibWUPkdI64p6FFv.WiGB.fFaH.SwTVNQ1MfNc2QSYK5AkKq','Sameera',1,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,'manca@gmail.com','$2a$10$uQ09YS61TBH5ggxwACyMhueVswfrTN3Gk8M4vyQZOOdVa3VBpNHVi','Manca',1,'3002',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(56,'jamilah@gmail.com','$2a$10$6hk.PEs.Q11oTzjbuM0AxuQngZsAx4bMZBbLlJuE68FWzR1hROUYu','Jamilah',1,'07202515-a483-464c-b704-5671f104044b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(57,'egilmar@gmail.com','$2a$10$SvPRGVfCPjWcbiQV00Jlluq16SAbV8MTl5aX445NufkhT3fr5JkWW','Egilmar',2,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,'robin@gmail.com','$2a$10$Au1Ea8gju7QPnxE59uc1b.VARU/qdmuYofEb/uiqlxbQocKOJvdsO','Robin',2,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,'neo@gmail.com','$2a$10$kiEIJIRs.zSoVNV9uXqz..QKsjc1MS4PhAfHAznjAQtge2xfVJSwa','Neo',2,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,'anubis@gmail.com','$2a$10$8jXZQrF9iFkdrLNTnBd3s.JSIbtanH3MqTuPRlW9eQxnjQ66oZtjm','Anubis',2,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(61,'topher@gmail.com','$2a$10$3Jq3IAgb4g7Pc9oTRmCWIuaMQC9VJUnaBhz5j33s2Qdi.KcplMjtm','Topher',2,'3010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,'jantje@gmail.com','$2a$12$29cvB8MYYN0OjCKjZcjrteruMIJoIMccL4ylmj8bxGP5SiBKXQkIC','Jantje',2,'07202515-a483-464c-b704-5671f104044b','test','test','test',NULL,'test','Male','test',NULL,'test','test');
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

-- Dump completed on 2023-01-09 17:35:33
