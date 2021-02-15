--
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
CREATE TABLE `airplane` (
  `airplane_id` bigint NOT NULL,
  `flown_hours` bigint NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `registration_code` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`airplane_id`),
  UNIQUE KEY `UK_chue503wos3kwm5w49i2bav3g` (`registration_code`)
) ENGINE=InnoDB;

--
-- Dumping data for table `airplane`
--

INSERT INTO `airplane` VALUES (5,15000,'Boeing','747-8','D-AAAA'),(6,20000,'Boeing','747-400','D-BBBB'),(7,10000,'Airbus','A380','A7-AAA'),(8,8000,'Airbus','A350-1000','A7-BBB');

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
CREATE TABLE `airport` (
  `airport_id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `iata_code` varchar(3) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`airport_id`),
  UNIQUE KEY `UK_j4nn5inm55h1u68kgmvvlqjyu` (`iata_code`)
) ENGINE=InnoDB;

--
-- Dumping data for table `airport`
--

INSERT INTO `airport` VALUES (9,'Munich','Germany','MUC','Franz Josef Strauss International Airport'),(10,'Doha','Qatar','DOH','Hamad International Airport'),(11,'Madrid','Spain','MAD','Adolfo Suárez Madrid-Barajas Airport'),(12,'Malé','Maldives','MLE','Malé International Airport'),(13,'Bangkok','Thailand','BKK','Suvarnabhumi Airport');

--
-- Table structure for table `crewmember`
--

DROP TABLE IF EXISTS `crewmember`;
CREATE TABLE `crewmember` (
  `employee_id` bigint NOT NULL,
  `employee_code` varchar(7) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surnames` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_9skwbhjxl6i0k10brc0rcihfn` (`employee_code`)
) ENGINE=InnoDB;

--
-- Dumping data for table `crewmember`
--

INSERT INTO `crewmember` VALUES (20,'2345874','Carmen','Torres Navarro','Lufthansa','Pilot'),(21,'4367231','Daniel','Acevedo Fuentes','Lufthansa','Co-pilot'),(22,'1234567','Laura','Ruiz Herranz','Lufthansa','Flight Attendant'),(25,'2214587','Jorge','Caballero Aparicio','Qatar Airways','Pilot'),(26,'8574233','Miguel','Romero Izquierdo','Qatar Airways','Co-pilot'),(27,'6658796','Ana','Calle Hidalgo','Qatar Airways','Flight Attendant');

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `flight_id` bigint NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `departure_date_time` datetime(6) DEFAULT NULL,
  `duration` double NOT NULL,
  `flight_code` varchar(5) DEFAULT NULL,
  `airplane_id` bigint NOT NULL,
  `arrival_airport_id` bigint NOT NULL,
  `departure_airport_id` bigint NOT NULL,
  PRIMARY KEY (`flight_id`),
  UNIQUE KEY `UK_j7j29duht4oswo8ylojjd5x1f` (`flight_code`),
  KEY `FKb8t4272gfgo1feyyidvscbjm0` (`airplane_id`),
  KEY `FKkrj4hx7srh822cuxlgiuiavyd` (`arrival_airport_id`),
  KEY `FKm9em9ffkiex7wu2nktxv80sg9` (`departure_airport_id`),
  CONSTRAINT `FKb8t4272gfgo1feyyidvscbjm0` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`),
  CONSTRAINT `FKkrj4hx7srh822cuxlgiuiavyd` FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`airport_id`),
  CONSTRAINT `FKm9em9ffkiex7wu2nktxv80sg9` FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`airport_id`)
) ENGINE=InnoDB;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` VALUES (19,'Lufthansa','2020-11-01 11:00:00.000000',2.5,'LH950',5,9,11),(23,'Lufthansa','2020-11-01 19:00:00.000000',12,'LH850',6,13,9),(24,'Qatar Airways','2020-11-05 00:00:00.000000',7,'QR150',7,10,11),(28,'Qatar Airways','2020-11-05 14:00:00.000000',5,'QR674',8,12,10),(29,'Qatar Airways','2020-11-01 04:00:00.000000',6.1,'QR836',8,13,10);

--
-- Table structure for table `flight_crewmember`
--

DROP TABLE IF EXISTS `flight_crewmember`;
CREATE TABLE `flight_crewmember` (
  `crewmember_employee_id` bigint NOT NULL,
  `flight_flight_id` bigint NOT NULL,
  PRIMARY KEY (`crewmember_employee_id`,`flight_flight_id`),
  KEY `FK2sndtus2tvnxpvkikwi1by3w2` (`flight_flight_id`),
  CONSTRAINT `FK2sndtus2tvnxpvkikwi1by3w2` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FK3ttqknff9k9w6o4l98wyat62y` FOREIGN KEY (`crewmember_employee_id`) REFERENCES `crewmember` (`employee_id`)
) ENGINE=InnoDB;

--
-- Dumping data for table `flight_crewmember`
--

INSERT INTO `flight_crewmember` VALUES (20,19),(21,19),(22,19),(20,23),(21,23),(22,23),(25,24),(26,24),(27,24),(25,28),(26,28),(27,28),(25,29),(26,29),(27,29);

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` VALUES (30);

--
-- Table structure for table `mechanic`
--

DROP TABLE IF EXISTS `mechanic`;
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
) ENGINE=InnoDB;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` VALUES (1,'7654321','Juan','Luque Aguilar','Airbus',2015,'University Degree'),(2,'7651234','Vicente','Costero Bermejo','Airbus',2010,'Master Degree'),(3,'6648392','Fernando','Montesinos Moreno','Boeing',2018,'Master Degree'),(4,'3456884','Manuel','Castillo Ortiz','Boeing',2017,'University Degree');


--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
CREATE TABLE `revision` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `revision_type` varchar(255) DEFAULT NULL,
  `spent_hours` double NOT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `airplane_id` bigint NOT NULL,
  `airport_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb2svmctq1fcm3yl5mjv1y5ylp` (`employee_id`),
  KEY `FKhvmxyy9yqdnjvhdd078mi146a` (`airplane_id`),
  KEY `FKrb37eisqmcx75fr60v1je6vmo` (`airport_id`),
  CONSTRAINT `FKb2svmctq1fcm3yl5mjv1y5ylp` FOREIGN KEY (`employee_id`) REFERENCES `mechanic` (`employee_id`),
  CONSTRAINT `FKhvmxyy9yqdnjvhdd078mi146a` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`),
  CONSTRAINT `FKrb37eisqmcx75fr60v1je6vmo` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`airport_id`)
) ENGINE=InnoDB;

--
-- Dumping data for table `revision`
--

INSERT INTO `revision` VALUES (14,'annual revision description','2020-12-23 09:00:00.000000','annual',50,'2020-12-21 07:00:00.000000',1,7,10),(15,'monthly revision description','2020-12-30 07:00:00.000000','monthly',20,'2020-12-29 11:00:00.000000',2,7,10),(16,'monthly revision description','2020-12-28 05:00:00.000000','monthly',20,'2020-12-27 09:00:00.000000',2,8,10),(17,'monthly revision description','2020-12-29 03:00:00.000000','monthly',20,'2020-12-28 07:00:00.000000',3,5,9),(18,'monthly revision description','2020-12-22 03:00:00.000000','monthly',20,'2020-12-21 07:00:00.000000',4,6,9);
