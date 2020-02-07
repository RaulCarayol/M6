-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Temps de generació: 07-02-2020 a les 18:22:55
-- Versió del servidor: 10.1.13-MariaDB
-- Versió de PHP: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `m6`
--
CREATE DATABASE IF NOT EXISTS `m6` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `m6`;

-- --------------------------------------------------------

--
-- Estructura de la taula `alumnes`
--

CREATE TABLE `alumnes` (
  `nombre` varchar(100) NOT NULL,
  `fechaDeNacimiento` varchar(25) DEFAULT NULL,
  `direccioPostal` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `codiPostal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Bolcant dades de la taula `alumnes`
--

INSERT INTO `alumnes` (`nombre`, `fechaDeNacimiento`, `direccioPostal`, `dni`, `codiPostal`) VALUES
('Manolo', '12/12/2012', 'calle escondida', '12345678r', 43209),
('George', '20/05/1999', 'carrer amargura', '12745673t', 43204);

-- --------------------------------------------------------

--
-- Estructura de la taula `poblaciones`
--

CREATE TABLE `poblaciones` (
  `nombre` varchar(50) NOT NULL,
  `CP` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcant dades de la taula `poblaciones`
--

INSERT INTO `poblaciones` (`nombre`, `CP`) VALUES
('Reus', 43204),
('Tarragona', 43209);

--
-- Indexos per taules bolcades
--

--
-- Index de la taula `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `codiPostal` (`codiPostal`);

--
-- Index de la taula `poblaciones`
--
ALTER TABLE `poblaciones`
  ADD PRIMARY KEY (`CP`);

--
-- Restriccions per taules bolcades
--

--
-- Restriccions per la taula `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `fk_codiPostal_CP` FOREIGN KEY (`codiPostal`) REFERENCES `poblaciones` (`CP`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
