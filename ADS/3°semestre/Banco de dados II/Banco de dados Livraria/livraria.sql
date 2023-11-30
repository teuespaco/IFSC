-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: livraria3
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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobre_nome` varchar(40) DEFAULT NULL,
  `telefone` varchar(11) NOT NULL,
  `endereço` varchar(90) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Alexandre',NULL,'123456789','SC'),(2,'Davi',NULL,'123456789','SC'),(3,'Diogenes',NULL,'123456789','SC'),(4,'Douglas',NULL,'123456789','SC'),(5,'Erick',NULL,'123456789','SC'),(6,'Gabriel',NULL,'123456789','SC'),(7,'Gustavo',NULL,'123456789','SC'),(8,'Hassan',NULL,'123456789','SC'),(9,'Jarbas',NULL,'123456789','SC'),(10,'Luan',NULL,'123456789','SC'),(11,'Manoel',NULL,'123456789','SC'),(12,'Pedro',NULL,'123456789','SC'),(13,'Ruam',NULL,'123456789','SC'),(14,'Samuel',NULL,'123456789','SC'),(15,'Thales',NULL,'123456789','SC'),(16,'Thiago',NULL,'123456789','SC'),(17,'Vinicius',NULL,'123456789','SC'),(18,'Wilson',NULL,'123456789','SC'),(19,'Yasmin',NULL,'123456789','SC'),(20,'Aldir cerutti Jr',NULL,'479999-9999','PR');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_livro`
--

DROP TABLE IF EXISTS `cliente_livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_livro` (
  `cliente_codigo` int NOT NULL,
  `livro_id` int NOT NULL,
  PRIMARY KEY (`cliente_codigo`,`livro_id`),
  KEY `fk_cliente_has_livro_livro1_idx` (`livro_id`),
  KEY `fk_cliente_has_livro_cliente1_idx` (`cliente_codigo`),
  CONSTRAINT `fk_cliente_has_livro_cliente1` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`),
  CONSTRAINT `fk_cliente_has_livro_livro1` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_livro`
--

LOCK TABLES `cliente_livro` WRITE;
/*!40000 ALTER TABLE `cliente_livro` DISABLE KEYS */;
INSERT INTO `cliente_livro` VALUES (3,1),(6,1),(11,1),(14,1),(17,1),(19,1),(3,2),(7,2),(8,2),(10,2),(11,2),(19,2),(1,3),(5,3),(6,3),(10,3),(13,3),(14,3),(16,3),(5,4),(10,4),(11,4),(14,4),(18,4),(2,5),(9,5),(10,5),(11,5),(13,5),(16,5),(17,5),(18,5),(5,6),(6,6),(11,6),(12,6),(14,6),(15,6),(16,6),(1,7),(2,7),(4,7),(7,7),(8,7),(10,7),(14,7),(18,7),(2,8),(3,8),(8,8),(11,8),(12,8),(1,9),(2,9),(4,9),(10,9),(1,10),(2,10),(5,10),(6,10),(8,10),(12,10),(16,10),(17,10),(19,10);
/*!40000 ALTER TABLE `cliente_livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editoras`
--

DROP TABLE IF EXISTS `editoras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editoras` (
  `Codigo` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Endereço` varchar(20) NOT NULL,
  `Telefone` varchar(11) NOT NULL,
  `Nome_do_gerente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editoras`
--

LOCK TABLES `editoras` WRITE;
/*!40000 ALTER TABLE `editoras` DISABLE KEYS */;
INSERT INTO `editoras` VALUES (1,'Editara A','SC','123456789','Gerente A'),(2,'Editara B','PR','123456789',NULL),(3,'Editara C','PR','123456789','Gerente C'),(4,'Editara D','PR','123456789','Gerente B'),(5,'Editara E','SC','123456789','Gerente E');
/*!40000 ALTER TABLE `editoras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(255) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `estoque` int NOT NULL,
  `editoras_Codigo` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_livro_editoras_idx` (`editoras_Codigo`),
  CONSTRAINT `fk_livro_editoras` FOREIGN KEY (`editoras_Codigo`) REFERENCES `editoras` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Nas pegadas da alemoa','Assunto 1','Autor 1',10,1),(2,'Vade Mecum Saraiva 2022','Assunto 2','Autor 2',9,2),(3,'Mais esperto que o diabo','Assunto 3','Autor 3',13,3),(4,'O poder da autorresponsabilidade','Assunto 4','Autor 4',18,4),(5,'Mulheres que correm com os lobos','Assunto 5','Autor 5',5,5),(6,'É assim que acaba','Assunto 6','Autor 6',10,1),(7,'Os sete maridos de Evelyn Hugo','Assunto 7','Autor 7',15,2),(8,'Amor & gelato','Assunto 8','Autor 8',4,3),(9,'Demon Slayer: Kimetsu No Yaiba','Assunto 9','Autor 9',9,4),(10,'Os dois morrem no final','Assunto 10','Autor 10',1,5);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'livraria3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-25 20:17:10
