-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Nov 2015 pada 09.50
-- Versi Server: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baylung`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `drugs`
--

CREATE TABLE IF NOT EXISTS `drugs` (
  `id_drug` int(11) NOT NULL,
  `drugname` varchar(225) NOT NULL,
  `price` int(11) NOT NULL,
  `miligram` double NOT NULL,
  `drug_explaination` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `drugs`
--

INSERT INTO `drugs` (`id_drug`, `drugname`, `price`, `miligram`, `drug_explaination`) VALUES
(1, 'Amoxicillin', 500, 500, ''),
(2, 'Amoxicillin Syrup', 5800, 125, ''),
(3, 'Cefadroxyl', 5800, 50, ''),
(4, 'Cefadroxyl syrup', 11000, 125, ''),
(5, 'Ciprofloxacin', 350, 500, ''),
(6, 'Azitromisin', 12500, 0, ''),
(7, 'Ambroxol', 170, 0, ''),
(8, 'Acethylcysteine', 1500, 0, ''),
(9, 'Aminofilin', 90, 0, ''),
(10, 'Salbutamol', 110, 2, ''),
(11, 'Teofilin', 250, 150, ''),
(12, 'Antasid', 110, 0, ''),
(13, 'lanzoprasol', 630, 0, ''),
(14, 'asam mefernamat', 265, 0, ''),
(15, 'paracetamol', 270, 500, ''),
(16, 'paracetamol syrup', 3100, 0, ''),
(17, 'Asam Trameksamat', 300, 0, ''),
(18, 'Vit C', 120, 0, ''),
(19, 'Amboclipin', 200, 5, ''),
(20, 'Dexamethazon', 120, 0.5, ''),
(21, 'Ceterizin', 420, 0, ''),
(22, 'Diazepam', 85, 2, ''),
(23, 'Salbutamol inhaler', 115000, 0, ''),
(24, 'Salbutamol respuler', 12000, 0, ''),
(25, 'loratadun', 460, 10, ''),
(26, 'Metilprednisolon', 690, 4, ''),
(27, 'furosemid', 135, 40, ''),
(28, 'kaspartat', 700, 300, ''),
(29, 'Kdikloferak', 880, 0, ''),
(30, 'Metoclopramide', 130, 0, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `linguistic_variable`
--

CREATE TABLE IF NOT EXISTS `linguistic_variable` (
  `id_linguistic` int(11) NOT NULL,
  `linguistic_name` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `linguistic_variable`
--

INSERT INTO `linguistic_variable` (`id_linguistic`, `linguistic_name`) VALUES
(1, 'itchy on alergen'),
(2, 'sneeze on alergen'),
(3, 'have family members who have alergy'),
(4, 'Alergy'),
(5, 'Headache'),
(6, 'Increasing body temperature'),
(7, 'sore throat'),
(8, '\r\nloss of appetite'),
(9, 'Rash on skin'),
(10, 'Whezzing'),
(11, 'Cough with uncertain frequency'),
(12, 'very hard to breathe'),
(13, 'sticky mucus'),
(14, 'Family member have asthma'),
(15, 'Asthma'),
(16, 'excessive mucus'),
(17, 'family member have bronchitis'),
(18, 'Bronchitis'),
(19, 'Yellow Mucus'),
(20, 'scattered infiltrates'),
(21, 'Pneumonia'),
(22, 'X-ray shows lung lengthwise'),
(23, 'Hipersonor'),
(24, 'fever'),
(25, 'polution'),
(26, 'smoking'),
(27, 'Emphysema'),
(28, 'Old age'),
(29, 'Ribs'' gap widened'),
(30, 'Chronic Obstructive Pulmonary Disease'),
(31, 'positive virus on mucus after wake up'),
(32, 'positive virus on mucus in first clinic visit'),
(33, 'positive virus on mucus in second clinic visit'),
(34, 'BTA Positive'),
(35, 'Cough more than 2 weeks'),
(36, 'Infiltrat gather on top of the lungs'),
(37, 'Bloody cough'),
(38, 'Significant weight loss'),
(39, 'TBC'),
(40, 'Only white on X-Ray'),
(41, 'yellowish white fluid is found'),
(42, 'pleural effusion'),
(43, 'Injury on chest'),
(44, 'black X-ray'),
(45, 'Pneumothorax'),
(46, 'cough on alergen'),
(47, 'Pain all over the body'),
(48, 'use mask'),
(49, 'deal with polution in the daily live'),
(50, 'flatten diaphragma'),
(51, 'broken rib sttabbed lung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rules`
--

CREATE TABLE IF NOT EXISTS `rules` (
  `id_rule` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `CF` double NOT NULL,
  `priority` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rules`
--

INSERT INTO `rules` (`id_rule`, `id_linguistic`, `CF`, `priority`) VALUES
(1, 4, 1, 1),
(2, 24, 0.5, 2),
(3, 24, 0.6, 3),
(4, 24, 0.3, 4),
(5, 24, 0.8, 5),
(6, 24, 0.7, 6),
(7, 15, 1, 7),
(8, 15, 0.8, 8),
(9, 15, 0.6, 9),
(10, 18, 1, 10),
(11, 18, 1, 11),
(12, 21, 1, 12),
(13, 21, 0.8, 13),
(14, 25, 0.9, 14),
(15, 25, 0.3, 15),
(17, 27, 1, 17),
(18, 27, 0.9, 18),
(19, 30, 1, 19),
(20, 34, 1, 20),
(21, 34, 1, 21),
(22, 34, 1, 22),
(23, 39, 1, 23),
(24, 39, 1, 24),
(25, 39, 0.5, 25),
(26, 42, 0.8, 26),
(27, 42, 1, 27),
(28, 45, 1, 28),
(29, 45, 0.5, 28);

-- --------------------------------------------------------

--
-- Struktur dari tabel `rule_relation`
--

CREATE TABLE IF NOT EXISTS `rule_relation` (
  `id_relation` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `id_rule` int(11) NOT NULL,
  `connector` tinyint(1) NOT NULL,
  `not` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rule_relation`
--

INSERT INTO `rule_relation` (`id_relation`, `id_linguistic`, `id_rule`, `connector`, `not`) VALUES
(1, 1, 1, 1, 0),
(2, 2, 1, 1, 0),
(3, 46, 1, 1, 0),
(4, 3, 1, 1, 0),
(5, 5, 2, 0, 0),
(6, 6, 3, 0, 0),
(7, 47, 4, 0, 0),
(8, 7, 5, 0, 0),
(9, 9, 6, 0, 0),
(10, 10, 7, 1, 0),
(11, 14, 7, 1, 0),
(12, 11, 8, 0, 0),
(13, 12, 8, 0, 0),
(14, 13, 9, 0, 0),
(15, 4, 9, 0, 0),
(16, 11, 10, 1, 0),
(17, 17, 10, 1, 0),
(18, 12, 11, 0, 0),
(19, 16, 11, 0, 0),
(20, 4, 11, 1, 0),
(21, 20, 12, 0, 0),
(22, 19, 13, 0, 0),
(23, 13, 13, 0, 0),
(24, 24, 13, 0, 0),
(25, 48, 14, 0, 1),
(26, 49, 14, 0, 0),
(27, 4, 14, 0, 0),
(28, 48, 15, 0, 0),
(29, 49, 15, 0, 0),
(30, 4, 15, 0, 0),
(31, 12, 17, 0, 0),
(32, 22, 17, 0, 0),
(33, 24, 18, 0, 0),
(34, 23, 18, 0, 0),
(35, 25, 18, 1, 0),
(36, 26, 18, 1, 0),
(37, 12, 19, 0, 0),
(38, 4, 19, 0, 0),
(39, 29, 19, 1, 0),
(40, 50, 19, 1, 0),
(41, 27, 19, 1, 0),
(42, 31, 20, 0, 0),
(43, 32, 20, 0, 0),
(44, 31, 21, 0, 0),
(45, 33, 21, 0, 0),
(46, 32, 22, 0, 0),
(47, 33, 22, 0, 0),
(48, 34, 23, 1, 0),
(49, 36, 23, 1, 0),
(50, 35, 24, 0, 0),
(51, 35, 24, 0, 0),
(52, 37, 24, 1, 0),
(53, 38, 25, 0, 0),
(54, 40, 26, 0, 0),
(55, 41, 27, 0, 0),
(56, 43, 28, 0, 0),
(57, 51, 28, 0, 0),
(58, 44, 28, 1, 0),
(59, 39, 29, 0, 0),
(60, 21, 29, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drugs`
--
ALTER TABLE `drugs`
  ADD PRIMARY KEY (`id_drug`);

--
-- Indexes for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  ADD PRIMARY KEY (`id_linguistic`);

--
-- Indexes for table `rules`
--
ALTER TABLE `rules`
  ADD PRIMARY KEY (`id_rule`);

--
-- Indexes for table `rule_relation`
--
ALTER TABLE `rule_relation`
  ADD PRIMARY KEY (`id_relation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `drugs`
--
ALTER TABLE `drugs`
  MODIFY `id_drug` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  MODIFY `id_linguistic` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT for table `rules`
--
ALTER TABLE `rules`
  MODIFY `id_rule` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `rule_relation`
--
ALTER TABLE `rule_relation`
  MODIFY `id_relation` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=61;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
