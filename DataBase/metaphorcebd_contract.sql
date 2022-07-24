-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: metaphorcebd
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `ContractId` bigint NOT NULL AUTO_INCREMENT,
  `EmployeeId` int NOT NULL,
  `ContractTypeId` int NOT NULL,
  `DateFrom` datetime NOT NULL,
  `DateTo` datetime NOT NULL,
  `SalaryPerDay` decimal(10,0) NOT NULL,
  `IsActive` tinyint NOT NULL,
  `DateCreated` datetime NOT NULL,
  PRIMARY KEY (`ContractId`),
  KEY `employeeid_idx` (`EmployeeId`),
  KEY `contractType_idx` (`ContractTypeId`),
  CONSTRAINT `contractType` FOREIGN KEY (`ContractTypeId`) REFERENCES `contracttype` (`ContractTypeId`),
  CONSTRAINT `employeeid` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,1,1,'2022-07-23 00:00:00','2040-07-23 00:00:00',800,0,'2022-07-23 00:00:00'),(2,2,2,'2022-07-23 00:00:00','2024-07-23 00:00:00',600,1,'2022-07-23 00:00:00'),(3,3,3,'2022-07-23 00:00:00','2023-07-23 00:00:00',400,0,'2022-07-23 00:00:00'),(4,3,1,'2022-07-14 00:00:00','2022-07-23 00:00:00',2220,0,'2022-07-24 00:18:41'),(5,1,3,'2022-07-06 00:00:00','2022-07-21 00:00:00',111111,1,'2022-07-24 00:21:54'),(6,3,3,'2022-07-07 00:00:00','2022-07-29 00:00:00',200,1,'2022-07-24 04:38:22');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-24  9:17:11
