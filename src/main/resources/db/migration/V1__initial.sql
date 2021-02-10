-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `airplane_id` bigint NOT NULL,
  `flown_hours` bigint NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `registration_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`airplane_id`),
  UNIQUE KEY `UK_chue503wos3kwm5w49i2bav3g` (`registration_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (5,15000,'Boeing','747-8','D-AAAA'),(6,20000,'Boeing','747-400','D-BBBB'),(7,10000,'Airbus','A380','A7-AAA'),(8,8000,'Airbus','A350-1000','A7-BBB');
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `airport_id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `iata_code` varchar(3) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`airport_id`),
  UNIQUE KEY `UK_j4nn5inm55h1u68kgmvvlqjyu` (`iata_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (9,'Munich','Germany','MUC','Franz Josef Strauss International Aiport'),(10,'Doha','Qatar','DOH','Hamad International Airport'),(11,'Madrid','Spain','MAD','Adolfo Suárez Madrid-Barajas Airport'),(12,'Malé','Maldives','MLE','Malé International Airport'),(13,'Bangkok','Thailand','BKK','Suvarnabhumi Airport');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crewmember`
--

DROP TABLE IF EXISTS `crewmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crewmember` (
  `employee_id` bigint NOT NULL,
  `employee_code` varchar(7) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surnames` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_9skwbhjxl6i0k10brc0rcihfn` (`employee_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crewmember`
--

LOCK TABLES `crewmember` WRITE;
/*!40000 ALTER TABLE `crewmember` DISABLE KEYS */;
INSERT INTO `crewmember` VALUES (20,'2345874','Carmen','Torres Navarro','Lufthansa','Pilot'),(21,'4367231','Daniel','Acevedo Fuentes','Lufthansa','Co-pilot'),(22,'1234567','Laura','Ruiz Herranz','Lufthansa','Flight Attendant'),(25,'2214587','Jorge','Caballero Aparicio','Qatar Airways','Pilot'),(26,'8574233','Miguel','Romero Izquierdo','Qatar Airways','Co-pilot'),(27,'6658796','Ana','Calle Hidalgo','Qatar Airways','Flight Attendant');
/*!40000 ALTER TABLE `crewmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `flight_id` bigint NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `departure_date_time` datetime(6) DEFAULT NULL,
  `duration` double NOT NULL,
  `flight_code` varchar(5) DEFAULT NULL,
  `airplane_id` bigint NOT NULL,
  `arrival_aiport_id` bigint NOT NULL,
  `departure_aiport_id` bigint NOT NULL,
  PRIMARY KEY (`flight_id`),
  UNIQUE KEY `UK_j7j29duht4oswo8ylojjd5x1f` (`flight_code`),
  KEY `FKb8t4272gfgo1feyyidvscbjm0` (`airplane_id`),
  KEY `FKkrj4hx7srh822cuxlgiuiavyd` (`arrival_aiport_id`),
  KEY `FKm9em9ffkiex7wu2nktxv80sg9` (`departure_aiport_id`),
  CONSTRAINT `FKb8t4272gfgo1feyyidvscbjm0` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`),
  CONSTRAINT `FKkrj4hx7srh822cuxlgiuiavyd` FOREIGN KEY (`arrival_aiport_id`) REFERENCES `airport` (`airport_id`),
  CONSTRAINT `FKm9em9ffkiex7wu2nktxv80sg9` FOREIGN KEY (`departure_aiport_id`) REFERENCES `airport` (`airport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (19,'Lufthansa','2020-11-01 11:00:00.000000',2.5,'LH950',5,9,11),(23,'Lufthansa','2020-11-01 19:00:00.000000',12,'LH850',6,13,9),(24,'Qatar Airways','2020-11-05 00:00:00.000000',7,'QR150',7,10,11),(28,'Qatar Airways','2020-11-05 14:00:00.000000',5,'QR674',8,12,10),(29,'Qatar Airways','2020-11-01 04:00:00.000000',6.1,'QR836',8,13,10);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_crewmember`
--

DROP TABLE IF EXISTS `flight_crewmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_crewmember` (
  `crewmember_employee_id` bigint NOT NULL,
  `flight_flight_id` bigint NOT NULL,
  PRIMARY KEY (`crewmember_employee_id`,`flight_flight_id`),
  KEY `FK2sndtus2tvnxpvkikwi1by3w2` (`flight_flight_id`),
  CONSTRAINT `FK2sndtus2tvnxpvkikwi1by3w2` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FK3ttqknff9k9w6o4l98wyat62y` FOREIGN KEY (`crewmember_employee_id`) REFERENCES `crewmember` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_crewmember`
--

LOCK TABLES `flight_crewmember` WRITE;
/*!40000 ALTER TABLE `flight_crewmember` DISABLE KEYS */;
INSERT INTO `flight_crewmember` VALUES (20,19),(21,19),(22,19),(20,23),(21,23),(22,23),(25,24),(26,24),(27,24),(25,28),(26,28),(27,28),(25,29),(26,29),(27,29);
/*!40000 ALTER TABLE `flight_crewmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','initial','SQL','V1__initial.sql',0,'root','2021-02-10 23:29:04',7,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
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
INSERT INTO `hibernate_sequence` VALUES (30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mechanic`
--

DROP TABLE IF EXISTS `mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mechanic` (
  `employee_id` bigint NOT NULL,
  `employee_code` varchar(7) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surnames` varchar(255) DEFAULT NULL,
  `enterprise` varchar(255) DEFAULT NULL,
  `incorporation_year` int NOT NULL,
  `previous_formation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_crnb4br2x1lp5fune6bv1drjh` (`employee_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mechanic`
--

LOCK TABLES `mechanic` WRITE;
/*!40000 ALTER TABLE `mechanic` DISABLE KEYS */;
INSERT INTO `mechanic` VALUES (1,'7654321','Juan','Luque Aguilar','Airbus',2015,'University Degree'),(2,'7651234','Vicente','Costero Bermejo','Airbus',2010,'Master Degree'),(3,'6648392','Fernando','Montesinos Moreno','Boeing',2018,'Master Degree'),(4,'3456884','Manuel','Castillo Ortiz','Boeing',2017,'University Degree');
/*!40000 ALTER TABLE `mechanic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `revision` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `revision_type` varchar(255) DEFAULT NULL,
  `spent_hours` double NOT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `airplane_id` bigint NOT NULL,
  `aiport_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb2svmctq1fcm3yl5mjv1y5ylp` (`employee_id`),
  KEY `FKhvmxyy9yqdnjvhdd078mi146a` (`airplane_id`),
  KEY `FKrb37eisqmcx75fr60v1je6vmo` (`aiport_id`),
  CONSTRAINT `FKb2svmctq1fcm3yl5mjv1y5ylp` FOREIGN KEY (`employee_id`) REFERENCES `mechanic` (`employee_id`),
  CONSTRAINT `FKhvmxyy9yqdnjvhdd078mi146a` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`),
  CONSTRAINT `FKrb37eisqmcx75fr60v1je6vmo` FOREIGN KEY (`aiport_id`) REFERENCES `airport` (`airport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
INSERT INTO `revision` VALUES (14,'annual revision description','2020-12-23 09:00:00.000000','annual',50,'2020-12-21 07:00:00.000000',1,7,10),(15,'monthly revision description','2020-12-30 07:00:00.000000','monthly',20,'2020-12-29 11:00:00.000000',2,7,10),(16,'monthly revision description','2020-12-28 05:00:00.000000','monthly',20,'2020-12-27 09:00:00.000000',2,8,10),(17,'monthly revision description','2020-12-29 03:00:00.000000','monthly',20,'2020-12-28 07:00:00.000000',3,5,9),(18,'monthly revision description','2020-12-22 03:00:00.000000','monthly',20,'2020-12-21 07:00:00.000000',4,6,9);
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-11  0:33:52
