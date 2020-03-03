-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Temps de generació: 03-03-2020 a les 20:15:05
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

CREATE TABLE `alumnos` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaDeNacimiento` date NOT NULL,
  `direccioPostal` varchar(50) NOT NULL,
  `codiPostal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `alumnos`
--

INSERT INTO `alumnos` (`dni`, `nombre`, `fechaDeNacimiento`, `direccioPostal`, `codiPostal`) VALUES
('X1234567R', 'Guido Gonzalez', '1992-12-17', 'Av. Dr. Vilaseca', 43202);

-- --------------------------------------------------------

--
-- Estructura de la taula `movimientos`
--

CREATE TABLE `movimientos` (
  `ID` int(11) NOT NULL,
  `partida_id` int(11) NOT NULL,
  `moviments` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `movimientos`
--

INSERT INTO `movimientos` (`ID`, `partida_id`, `moviments`) VALUES
(1, 7, 'X X X X   X X   X      X                         O O O O  O O O O'),
(2, 7, 'X X X X   X X   X      X                    O    O O   O  O O O O'),
(3, 7, 'X X X X   X X   X             X             O    O O   O  O O O O'),
(4, 7, 'X X X X   X X   X             X      O           O O   O  O O O O'),
(5, 7, 'X X X X   X X   X                    X           O O   O  O O O O'),
(6, 7, 'X X X X   X X   X                    X        O  O O      O O O O'),
(7, 7, 'X X X X   X X   X                             X  O O      O O O O'),
(8, 7, 'X X X X   X X   X                             X  O O O    O O   O'),
(9, 7, 'X X X X   X X   X                                O O X    O O   O'),
(10, 7, 'X X X X   X X   X                                O O O    O     O'),
(11, 7, 'X X X X   X     X  X                             O O O    O     O'),
(12, 7, 'X X X X   X     X  X                      O      O   O    O     O'),
(13, 7, 'X X X X   X     X           X             O      O   O    O     O'),
(14, 7, 'X X X X   X     X           X             O O    O        O     O'),
(15, 7, 'X X X X   X     X                    X    O O    O        O     O'),
(16, 7, 'X X X X   X     X                    O    O      O        O     O'),
(17, 7, 'X X X X         X  X                 O    O      O        O     O'),
(18, 7, 'X X X X         X  X        O             O      O        O     O'),
(19, 7, 'X X X X         X           X             O      O        O     O'),
(20, 7, 'X X X X         X           X      O             O        O     O'),
(21, 7, 'X X X X         X                  X             O        O     O'),
(22, 7, 'X X X X         X                  X             O     O  O      '),
(23, 7, 'X X X X         X                           X    O     O  O      '),
(24, 7, 'X X X X         X                           X O  O        O      '),
(25, 7, 'X X X X         X                             O  O   X    O      '),
(26, 7, 'X X X X         X                    O           O   X    O      '),
(27, 7, 'X X X X         X                    O           O        O   X  '),
(28, 7, 'X X X X         X           O                    O        O   X  '),
(35, 9, 'X X X X  X   X X  X                             O O O O  O O O O'),
(36, 9, 'X X X X  X   X X  X                        O    O   O O  O O O O'),
(37, 9, 'X X X X  X   X X         X                 O    O   O O  O O O O'),
(38, 14, 'X X X X  X   X X    X                           O O O O  O O O O'),
(39, 14, 'X X X X  X   X X    X                      O    O O   O  O O O O'),
(40, 14, 'X X X X  X   X X             X             O    O O   O  O O O O'),
(41, 14, 'X X X X  X   X X             X             O   OO O      O O O O'),
(42, 14, 'X X X X  X   X X                      X    O   OO O      O O O O'),
(43, 14, 'X X X X  X   X X                    O X        OO O      O O O O'),
(44, 14, 'X X X X      X X  X                 O X        OO O      O O O O'),
(45, 14, 'X X X X      X X  X                 O X  O     OO        O O O O'),
(46, 14, 'X X X X      X X           X        O X  O     OO        O O O O'),
(47, 14, 'X X X X      X X           X O        X  O     OO        O O O O'),
(48, 14, 'X X X X      X X             O      X X  O     OO        O O O O'),
(49, 14, 'X X X X      X X             O      X O  O      O        O O O O'),
(50, 14, 'X X X X      X X             O        O  O   X  O        O O O O'),
(51, 14, 'X X X X      X X    O                 O  O   X  O        O O O O'),
(52, 14, 'X X X X        X    O X               O  O   X  O        O O O O'),
(53, 14, 'X X X X      O X      X               O  O   X  O        O O O O'),
(54, 14, 'X X X X      O X      X               O  O      O     X  O O O O'),
(55, 14, 'X X X X      O X      X               O  O      O   O X  O O   O'),
(56, 14, 'X X X X      O X      X               O  O      O   O    O O X O'),
(57, 14, 'X X X X      O X      X               O  O   O  O        O O X O'),
(58, 15, 'X X X X  X   X X    X                           O O O O  O O O O'),
(59, 15, 'X X X X  X   X X    X                          OO O O    O O O O'),
(60, 15, 'X X X X      X X  X X                          OO O O    O O O O'),
(61, 15, 'X X X X      X X  X X                        O OO O      O O O O'),
(62, 15, 'X X X X      X X  X        X                 O OO O      O O O O'),
(63, 15, 'X X X X      X X  X        X          O      O  O O      O O O O'),
(64, 15, 'X X X X      X X  X                 X O      O  O O      O O O O'),
(65, 15, 'X X X X      X X  X            O    X        O  O O      O O O O'),
(66, 15, 'X X X X      X X  X            O             X  O O      O O O O'),
(67, 15, 'X X X X      X X  X   O                      X  O O      O O O O'),
(68, 15, 'X X X X      X X  X   O                         O O   X  O O O O'),
(69, 15, 'X X X X      X O  X                             O O   X  O O O O'),
(70, 15, 'X X X X      X O  X                             O O      O O X O'),
(71, 15, 'X X X O      X    X                             O O      O O X O');

-- --------------------------------------------------------

--
-- Estructura de la taula `partidas`
--

CREATE TABLE `partidas` (
  `ID` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `ganador` varchar(1) DEFAULT NULL,
  `num_movimientos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `partidas`
--

INSERT INTO `partidas` (`ID`, `fecha_inicio`, `ganador`, `num_movimientos`) VALUES
(6, '2020-02-27 17:16:59', NULL, 0),
(7, '2020-02-27 17:22:24', NULL, 0),
(9, '2020-02-28 19:23:40', NULL, 3),
(10, '2020-03-03 17:32:52', NULL, 0),
(11, '2020-03-03 19:01:00', NULL, 0),
(12, '2020-03-03 19:03:01', NULL, 0),
(13, '2020-03-03 19:06:17', NULL, 0),
(14, '2020-03-03 19:09:57', NULL, 20),
(15, '2020-03-03 20:07:53', NULL, 14);

-- --------------------------------------------------------

--
-- Estructura de la taula `poblaciones`
--

CREATE TABLE `poblaciones` (
  `CP` int(5) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Bolcant dades de la taula `poblaciones`
--

INSERT INTO `poblaciones` (`CP`, `nombre`) VALUES
(43202, 'Reus'),
(43206, 'Reus'),
(43217, 'Barcelona');

--
-- Indexos per taules bolcades
--

--
-- Index de la taula `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `FK_CodPos` (`codiPostal`);

--
-- Index de la taula `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `partida_id` (`partida_id`);

--
-- Index de la taula `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`ID`);

--
-- Index de la taula `poblaciones`
--
ALTER TABLE `poblaciones`
  ADD PRIMARY KEY (`CP`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT per la taula `partidas`
--
ALTER TABLE `partidas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Restriccions per taules bolcades
--

--
-- Restriccions per la taula `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `FK_CodPos` FOREIGN KEY (`codiPostal`) REFERENCES `poblaciones` (`CP`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriccions per la taula `movimientos`
--
ALTER TABLE `movimientos`
  ADD CONSTRAINT `FK_movimientos_partida` FOREIGN KEY (`partida_id`) REFERENCES `partidas` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
