-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlybanhang
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `mon`
--

DROP TABLE IF EXISTS `mon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon` (
  `ma` varchar(5) NOT NULL,
  `maloaimon` varchar(5) DEFAULT NULL,
  `tenmon` varchar(50) DEFAULT NULL,
  `giaban` int DEFAULT NULL,
  PRIMARY KEY (`ma`),
  KEY `FK_LoaiMon` (`maloaimon`),
  CONSTRAINT `FK_LoaiMon` FOREIGN KEY (`maloaimon`) REFERENCES `loaimon` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon`
--

LOCK TABLES `mon` WRITE;
/*!40000 ALTER TABLE `mon` DISABLE KEYS */;
INSERT INTO `mon` VALUES ('buhdo','bauot','Bánh Ướt Hà Đông',39000),('buhki','bauot','Bánh Ướt Hoàng Kim',59000),('bulga','bauot','Bánh Ướt Lòng Gà',39000),('buthe','mthem','Bánh Ướt Thêm',7000),('cafe','gkhat','Cà Phê Đá',15000),('cbhd1','combo','Combo Hà Đông 1',56000),('cbhd2','combo','Combo Hà Đông 2',59000),('cfsua','gkhat','Cà Phê Sữa Đá',18000),('coca','gkhat','Coca Cola',8000),('longa','mthem','Lòng Gà',19000),('thitg','mthem','Thịt Gà',22000);
/*!40000 ALTER TABLE `mon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-21 10:17:27
