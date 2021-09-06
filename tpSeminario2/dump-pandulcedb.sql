-- MySQL dump 10.16  Distrib 10.1.48-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: pandulcedb
-- ------------------------------------------------------
-- Server version	10.1.48-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lista_de_panes`
--

DROP TABLE IF EXISTS `lista_de_panes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_de_panes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `panesid` int(11) NOT NULL,
  `pedidosid` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Lista_de_panes_FK` (`panesid`),
  KEY `Lista_de_panes_FK_1` (`pedidosid`),
  CONSTRAINT `Lista_de_panes_FK` FOREIGN KEY (`panesid`) REFERENCES `panes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Lista_de_panes_FK_1` FOREIGN KEY (`pedidosid`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_de_panes`
--

LOCK TABLES `lista_de_panes` WRITE;
/*!40000 ALTER TABLE `lista_de_panes` DISABLE KEYS */;
INSERT INTO `lista_de_panes` VALUES (1,1,1,2);
/*!40000 ALTER TABLE `lista_de_panes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panes`
--

DROP TABLE IF EXISTS `panes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `contenido` varchar(75) DEFAULT NULL,
  `pesoengramos` int(11) DEFAULT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panes`
--

LOCK TABLES `panes` WRITE;
/*!40000 ALTER TABLE `panes` DISABLE KEYS */;
INSERT INTO `panes` VALUES (1,'Pan dulce comun',NULL,500,550);
/*!40000 ALTER TABLE `panes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(16) NOT NULL,
  `cantidadPanes` int(11) NOT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `costoTotal` float NOT NULL,
  `usuariosid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Pedidos_UN` (`codigo`),
  KEY `Pedidos_FK` (`usuariosid`),
  CONSTRAINT `Pedidos_FK` FOREIGN KEY (`usuariosid`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'PD-0000001-2021',2,'2021-12-15',1100,1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `mailDeCuenta` varchar(40) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Usuarios_UN` (`dni`),
  UNIQUE KEY `Usuarios_UNI` (`mailDeCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Santiago Nicolas','Chanampe','39886847','San Vicente 420','3825','mailPrueba@gmail.com','contraseña');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pandulcedb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-06 10:36:39
