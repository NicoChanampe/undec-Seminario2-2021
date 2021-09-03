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
-- Table structure for table `Lista_de_panes`
--

DROP TABLE IF EXISTS `Lista_de_panes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lista_de_panes` (
  `idLista_pk` int(11) NOT NULL AUTO_INCREMENT,
  `idPan_fk` int(11) NOT NULL,
  `idPedido_fk` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`idLista_pk`),
  KEY `Lista_de_panes_FK` (`idPan_fk`),
  KEY `Lista_de_panes_FK_1` (`idPedido_fk`),
  CONSTRAINT `Lista_de_panes_FK` FOREIGN KEY (`idPan_fk`) REFERENCES `Panes` (`idPan_pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Lista_de_panes_FK_1` FOREIGN KEY (`idPedido_fk`) REFERENCES `Pedidos` (`idPedido_pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lista_de_panes`
--

LOCK TABLES `Lista_de_panes` WRITE;
/*!40000 ALTER TABLE `Lista_de_panes` DISABLE KEYS */;
INSERT INTO `Lista_de_panes` VALUES (1,1,1,2);
/*!40000 ALTER TABLE `Lista_de_panes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Panes`
--

DROP TABLE IF EXISTS `Panes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Panes` (
  `idPan_pk` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `contenido` varchar(75) DEFAULT NULL,
  `pesoEnGramos` int(11) DEFAULT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`idPan_pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Panes`
--

LOCK TABLES `Panes` WRITE;
/*!40000 ALTER TABLE `Panes` DISABLE KEYS */;
INSERT INTO `Panes` VALUES (1,'Pan dulce comun',NULL,500,550);
/*!40000 ALTER TABLE `Panes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedidos`
--

DROP TABLE IF EXISTS `Pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pedidos` (
  `idPedido_pk` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(16) NOT NULL,
  `cantidadPanes` int(11) NOT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `costoTotal` float NOT NULL,
  `idCliente_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPedido_pk`),
  UNIQUE KEY `Pedidos_UN` (`codigo`),
  KEY `Pedidos_FK` (`idCliente_fk`),
  CONSTRAINT `Pedidos_FK` FOREIGN KEY (`idCliente_fk`) REFERENCES `Usuarios` (`idUsuario_pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedidos`
--

LOCK TABLES `Pedidos` WRITE;
/*!40000 ALTER TABLE `Pedidos` DISABLE KEYS */;
INSERT INTO `Pedidos` VALUES (1,'PD-0000001-2021',2,'2021-12-15',1100,1);
/*!40000 ALTER TABLE `Pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `idUsuario_pk` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `mailDeCuenta` varchar(40) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario_pk`),
  UNIQUE KEY `Usuarios_UN` (`dni`),
  UNIQUE KEY `Usuarios_UNI` (`mailDeCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'Santiago Nicolas','Chanampe','39886847','San Vicente 420','3825','mailPrueba@gmail.com','contraseña');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
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

-- Dump completed on 2021-09-03 18:49:15
