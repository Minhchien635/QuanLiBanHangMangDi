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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `mahd` varchar(10) NOT NULL,
  `mamon` varchar(5) NOT NULL,
  `soluong` int DEFAULT NULL,
  PRIMARY KEY (`mahd`,`mamon`),
  KEY `FK_Mon` (`mamon`),
  CONSTRAINT `FK_HoaDon` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`ma`),
  CONSTRAINT `FK_Mon` FOREIGN KEY (`mamon`) REFERENCES `mon` (`ma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES ('00000000at','buhdo',3),('00000000at','cbhd2',2),('00000000at','cfsua',2),('00000001at','buhdo',1),('00000001at','cbhd2',2),('00000001ba','cafe',1),('00000001ba','cbhd1',1),('00000001ba','cbhd2',1),('00000001ba','cfsua',1),('00000002at','buhki',1),('00000003ba','cbhd1',1),('00000004at','buhki',4),('00000005at','cafe',1),('00000005at','cbhd1',1),('00000006at','buhdo',1),('00000007at','buhdo',2),('00000007at','cbhd1',2),('00000008at','buhdo',2),('00000009at','buhdo',3),('00000010at','cafe',1),('00000011at','buhki',1),('00000011at','cbhd1',2),('00000011at','cbhd2',1),('00000012at','buhki',1),('00000013at','cbhd1',1),('00000014at','buhdo',4),('00000014at','cafe',1),('00000015at','cbhd1',1),('00000016AT','cbhd1',1),('00000017BA','cbhd2',3),('00000018AT','cbhd1',1),('00000019AT','buhki',1),('00000020AT','buhdo',1),('00000020AT','cbhd1',2),('00000021AT','buhdo',1),('00000022AT','buhdo',1),('00000023AT','cbhd1',1),('00000024AT','buhdo',1),('00000025AT','buhdo',1),('00000026AT','cbhd1',1),('00000027AT','buhdo',1),('00000028AT','buhdo',1),('00000029AT','cbhd1',1),('00000030AT','buhdo',1),('00000031AT','buhdo',1),('00000031AT','cbhd1',1),('00000032AT','buhdo',1),('00000032AT','cafe',1),('00000032AT','cbhd1',1),('00000033AT','bulga',1),('00000034AT','cbhd2',1),('00000035AT','thitg',1),('00000036AT','buhki',1),('00000038AT','cafe',1),('00000039AT','buthe',1),('00000040AT','buhdo',3),('00000040AT','cbhd1',1),('00000041AT','buhki',1),('00000042AT','cbhd1',1),('00000043AT','buhdo',1),('00000044AT','cfsua',1),('00000045AT','buhdo',1),('00000046AT','buhdo',1),('00000047AT','cbhd1',1),('00000048AT','buhdo',1),('00000049AT','cfsua',1),('00000050AT','cbhd2',1),('00000051AT','cbhd1',1),('00000052AT','cfsua',1),('00000053AT','cfsua',1),('00000054AT','cbhd2',1),('00000055AT','buhdo',4),('00000056AT','cbhd1',1);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-10 18:20:27
