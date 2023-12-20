CREATE DATABASE  IF NOT EXISTS `bdapuestas`;
USE `bdapuestas`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bdapuestas
-- ------------------------------------------------------
-- Server version	8.0.35








--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `idusuarios` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios`)
) ;


-- Dump completed on 2023-11-23  9:30:33

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;

CREATE TABLE `equipos` (
  `idequipos` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idequipos`)
);




--
-- Table structure for table `partidos`
--

DROP TABLE IF EXISTS `partidos`;

CREATE TABLE `partidos` (
  `idpartidos` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `goles_visitantes` int DEFAULT NULL,
  `goles_local` int DEFAULT NULL,
  `equipo_local` int DEFAULT NULL,
  `equipo_visitante` int DEFAULT NULL,
  PRIMARY KEY (`idpartidos`),
  KEY `equipo_local_idx` (`equipo_local`),
  KEY `equipo_visitante_idx` (`equipo_visitante`),
  CONSTRAINT `equipo_local` FOREIGN KEY (`equipo_local`) REFERENCES `equipos` (`idequipos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `equipo_visitante` FOREIGN KEY (`equipo_visitante`) REFERENCES `equipos` (`idequipos`) ON DELETE CASCADE ON UPDATE CASCADE
) ;



--
-- Table structure for table `apuestas`
--

DROP TABLE IF EXISTS `apuestas`;

CREATE TABLE `apuestas` (
  `idapuestas` int NOT NULL AUTO_INCREMENT,
  `valor` float DEFAULT NULL,
  `goles_visitante` int DEFAULT NULL,
  `goles_local` int DEFAULT NULL,
  `usuario` int DEFAULT NULL,
  `partido` int DEFAULT NULL,
  PRIMARY KEY (`idapuestas`),
  KEY `apostador_idx` (`usuario`),
  KEY `partido_idx` (`partido`),
  CONSTRAINT `apostador` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`idusuarios`),
  CONSTRAINT `partido` FOREIGN KEY (`partido`) REFERENCES `partidos` (`idpartidos`) ON DELETE CASCADE ON UPDATE CASCADE
); 



CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `bdapuestas`.`apuestas_altas` AS
    SELECT 
        `bdapuestas`.`apuestas`.`valor` AS `valor`,
        `bdapuestas`.`apuestas`.`usuario` AS `usuario`
    FROM
        `bdapuestas`.`apuestas`
    WHERE
        (`bdapuestas`.`apuestas`.`valor` >= 100);
        
DELIMITER $$        
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_max_min_media_apuestas`(
	OUT apuestamax INT,
    OUT apuestamin INT,
    OUT apuestamedia DECIMAL(15, 2)
)
BEGIN
  SELECT 
    MAX(valor),
    MIN(valor),
    AVG(valor)
    FROM bdapuestas.apuestas
    INTO apuestamax, apuestamin, apuestamedia;
END
$$