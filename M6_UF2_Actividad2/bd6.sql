-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Temps de generació: 14-02-2020 a les 19:49:42
-- Versió del servidor: 10.1.13-MariaDB
-- Versió de PHP: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `bd6`
--
CREATE DATABASE IF NOT EXISTS `bd6` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd6`;

-- --------------------------------------------------------

--
-- Estructura de la taula `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaDeNacimiento` date NOT NULL,
  `direccioPostal` varchar(50) NOT NULL,
  `codiPostal` int(5) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `FK_CodPos` (`codiPostal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `alumnos`
--

INSERT INTO `alumnos` (`dni`, `nombre`, `fechaDeNacimiento`, `direccioPostal`, `codiPostal`) VALUES
('X1234567R', 'Guido Gonzalez', '1992-12-17', 'Av. Dr. Vilaseca', 43202);

-- --------------------------------------------------------

--
-- Estructura de la taula `poblaciones`
--

CREATE TABLE IF NOT EXISTS `poblaciones` (
  `CP` int(5) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`CP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `poblaciones`
--

INSERT INTO `poblaciones` (`CP`, `nombre`) VALUES
(43202, 'Reus'),
(43206, 'Reus'),
(43217, 'Barcelona');

--
-- Restriccions per taules bolcades
--

--
-- Restriccions per la taula `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `FK_CodPos` FOREIGN KEY (`codiPostal`) REFERENCES `poblaciones` (`CP`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
