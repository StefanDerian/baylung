-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20 Jan 2016 pada 17.54
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

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
(30, 'Metoclopramide', 130, 0, ''),
(31, 'Antibiotik', 100, 10, ''),
(32, 'analgetik', 100, 10, ''),
(33, 'Ethambutol', 100, 100, ''),
(34, 'Pirasinamid', 100, 10, ''),
(35, 'Rifampisin', 100, 100, ''),
(36, 'INH', 100, 100, '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `drug_patent`
--

CREATE TABLE IF NOT EXISTS `drug_patent` (
  `id_drug` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `id_generic_drug` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `drug_patent`
--

INSERT INTO `drug_patent` (`id_drug`, `name`, `price`, `id_generic_drug`) VALUES
(1, 'Flason tab 4 mg 10sx10s', 143200, 26),
(2, 'Flason tab 8 mg 10sx10s', 230000, 26),
(3, 'Hexilon tab 16 mg 3 × 10''s', 168000, 26),
(4, 'Hexilon tab 4 mg 5 × 10''s ', 105000, 26),
(5, 'Hexilon tab 8 mg 3 × 10''s', 105000, 26),
(6, 'Gamesolone tab 8 mg 3 × 10''s ', 48500, 26),
(7, 'Intidrol tab 16 mg 2 × 10''s', 90000, 26),
(8, 'Intidrol tab 4 mg 5 × 10''s', 80000, 26),
(9, 'Medixon tab 16 mg 5 × 6''s', 162000, 26),
(10, 'Medixon tab 4 mg 10 × 10''s', 200000, 26),
(11, 'Medixon tab 8 mg 10 × 10''s', 308000, 26),
(12, 'Mesol tab 4 mg 3 × 10''s ', 60000, 26),
(13, 'Mesol tab 8 mg 3 × 10''s ', 105000, 26),
(14, 'Metrison tab 4 mg 100''s', 135000, 26),
(15, 'Prednicort caplet 8 mg 10''s', 150000, 26),
(16, 'Prednicort tab 4 mg 10''s', 90000, 26),
(17, 'Prolon 8 tab 8 mg 3 × 10''s ', 112500, 26),
(18, 'Sanexon tab 16 mg 5 × 6''s ', 139650, 26),
(19, 'Sanexon tab 4 mg 10 × 10''s', 179000, 26),
(20, 'Sanexon tab 8 mg 10 × 10''s', 275000, 26),
(21, 'Amoxsan cap 250 mg 10 × 10''s', 136840, 1),
(22, 'Amoxsan cap 500 mg 10 × 10''s', 280340, 1),
(23, 'Bufamoxy cap 500 mg 10 × 10''s ', 351120, 1),
(24, 'Kalmoxilin tab 500 mg 10 × 10''s', 190000, 1),
(25, 'Mestamox cap 250 mg 10 × 10''s  ', 133000, 1),
(26, 'Mestamox cap 500 mg 10 × 10''s ', 265500, 1),
(27, 'Novax caplet 500 mg 5 × 10''s', 125000, 1),
(28, 'Pehamoxil F tab 500 mg 5 × 10''s ', 44400, 1),
(29, 'Rindomox caplet 500 mg 10 × 10''s', 165000, 1),
(30, 'Widecillin cap 500 mg 10 × 10''s ', 240000, 1),
(31, 'Widecillin cap 500 mg 500''s', 510000, 1),
(32, 'Amoxillin cap 500 mg 100''s', 140800, 1),
(33, 'Berea tab 30 mg 10 × 10''s', 117040, 7),
(34, 'Cystelis tab 30 mg 10 × 10''s', 68000, 7),
(35, 'Galpect tab 30 mg 3 × 10''s', 20748, 7),
(36, 'Limoxin tab 30 mg 10 × 10''s', 85388, 7),
(37, 'Mucera tab 30 mg 10 × 10''s', 66000, 7),
(38, 'Mucos tab 30 mg', 80000, 7),
(39, 'Propect tab 30 mg 10 × 10''s', 75000, 7),
(40, 'Silopect tab 30 mg 100''s', 75000, 7),
(41, 'Farmadol tab 500 mg 10 × 10''s', 25000, 15),
(42, 'Ikacetamol syr 120 mg/5 mL 60 mL x 24 × 1''s ', 3850, 15),
(43, 'Pamol tab 500 mg v', 37000, 15),
(44, 'Panadol caplet 500 mg', 6900, 15),
(45, 'Progesic tab 500 mg 100''s ', 20500, 15),
(46, 'Progesic syr 250 mg/5 mL 60 mL x 1''s', 7250, 15),
(47, 'Sanmol Forte tab 650 mg 10 × 10''s', 25000, 15),
(48, 'Sanmol tab 500 mg 25 × 4''s', 21500, 15),
(49, 'Betarhin oral drops 10 mg/mL 30 mL x 1''s', 36000, 21),
(50, 'Betarhin syr 5 mg/5 mL 60 mL x 1''s', 33000, 21),
(51, 'Betarhin tab 10 mg 20''s', 60000, 21),
(52, 'Cerini FC caplet 10 mg 2 × 10''s', 54700, 21),
(53, 'Esculer FC tab 10 mg 3 × 10''s', 90000, 21),
(54, 'Cetinal chewable tab 10 mg 3 × 10''s', 130000, 21),
(55, 'Ryzen tab 10 mg 30''s', 157000, 21),
(56, 'Ryzen oral soln 5 mg/5 mL 75 mL x 1''s ', 102000, 21),
(57, 'Ryzen oral drops 10 mg/mL ', 87000, 21),
(58, 'Cetinal chewable tab 10 mg 3 × 10''s ', 130000, 21),
(59, 'Yarizine FC tab 10 mg 3 × 10''s ', 62000, 21),
(60, 'Yarizine syr 5 mg/5 mL 60 mL x 1''s', 25000, 21),
(61, 'Capritazin FC caplet 10 mg 3 × 10''s ', 69000, 21),
(62, 'Phyllocontin tab 225 mg', 95000, 9),
(63, 'Aminophyllin Indo Farma tab 200 mg 100', 8030, 9),
(64, 'Aminophyllin Indo Farma tab 200 mg 1000', 43440, 9),
(65, 'Albiotin cap 150 mg 3 × 10''s', 90000, 31),
(66, 'Albiotin cap 300 mg 3 × 10''s', 169000, 31),
(68, 'Ponstan FC tab 500 mg 10''s', 19555, 32),
(71, 'Benostan tab 500 mg 10 × 10''s ', 110000, 32),
(72, 'Mefinal cap 250 mg 10 × 10''s', 47500, 32),
(73, 'Mefinal FC caplet 500 mg 10 × 10''s', 105000, 32),
(74, 'Baquinor Forte FC caplet 500 mg 2 × 10''', 222800, 31),
(75, 'Lapiflox tab 250 mg 30''s ', 222800, 31),
(76, 'Bernoflox captab 500 mg	5 × 4''s', 209000, 31),
(77, 'Rifamtibi FC caplet 450 mg', 352000, 35),
(78, 'RIF 300 cap 300 mg 30''s', 98000, 35),
(79, 'Merimac FC caplet 450 mg 10 × 10''s', 315000, 35),
(80, 'Bacbutol tab 500 mg 160''s ', 205000, 33),
(81, 'Tibitol tab 250 mg 100''s', 42000, 33),
(82, 'Santibi Plus tab 10 × 10''s', 53000, 33),
(83, 'bacbutINH Forte tab 100''s', 185000, 36),
(84, 'INH-Ciba tab 300 mg 10 × 10''s ', 53000, 36),
(85, 'Beniazide tab 10 × 10''s', 40600, 36),
(86, 'Prazina tab 500 mg 100''s', 145000, 34),
(87, 'Pezeta-Ciba 500 tab 500 mg 10 × 10''s', 121000, 34),
(88, 'Neotibi caplet 500 mg 10 × 10''s', 120000, 34),
(89, 'Nufadoxin Forte tab 10 × 10''s ', 79650, 34);

-- --------------------------------------------------------

--
-- Struktur dari tabel `drug_relation`
--

CREATE TABLE IF NOT EXISTS `drug_relation` (
  `id_relation` int(11) NOT NULL,
  `id_drug` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `id_condition` int(11) NOT NULL,
  `not_in` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `drug_relation`
--

INSERT INTO `drug_relation` (`id_relation`, `id_drug`, `id_linguistic`, `id_condition`, `not_in`) VALUES
(1, 26, 15, 0, 0),
(2, 9, 15, 0, 0),
(3, 7, 15, 0, 0),
(4, 21, 15, 0, 0),
(5, 7, 18, 0, 0),
(6, 26, 18, 55, 1),
(7, 21, 18, 12, 0),
(8, 7, 21, 0, 0),
(9, 26, 21, 55, 1),
(10, 15, 21, 0, 0),
(11, 7, 30, 0, 0),
(12, 9, 30, 0, 0),
(13, 26, 30, 55, 1),
(14, 9, 18, 12, 0),
(15, 36, 39, 0, 0),
(16, 33, 39, 0, 0),
(17, 34, 39, 0, 0),
(18, 35, 39, 0, 0),
(19, 7, 39, 0, 0),
(20, 31, 42, 0, 0),
(21, 32, 42, 0, 0),
(22, 31, 45, 0, 0),
(23, 7, 45, 0, 0),
(24, 32, 45, 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `linguistic_variable`
--

CREATE TABLE IF NOT EXISTS `linguistic_variable` (
  `id_linguistic` int(11) NOT NULL,
  `linguistic_name` varchar(255) NOT NULL,
  `type` enum('disease','diagnostic','','') NOT NULL,
  `explaination` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `linguistic_variable`
--

INSERT INTO `linguistic_variable` (`id_linguistic`, `linguistic_name`, `type`, `explaination`) VALUES
(1, 'itchy on alergen', 'diagnostic', ''),
(2, 'sneeze on alergen', 'diagnostic', ''),
(3, 'have family members who have alergy', 'diagnostic', ''),
(4, 'Alergy', 'disease', ''),
(5, 'Headache', 'diagnostic', ''),
(6, 'Increasing body temperature', 'diagnostic', ''),
(7, 'sore throat', 'diagnostic', ''),
(8, '\r\nloss of appetite', 'diagnostic', ''),
(9, 'Rash on skin', 'diagnostic', ''),
(10, 'Whezzing', 'diagnostic', ''),
(11, 'Cough with uncertain frequency', 'diagnostic', ''),
(12, 'very hard to breathe', 'diagnostic', ''),
(13, 'sticky mucus', 'diagnostic', ''),
(14, 'Family member have asthma', 'diagnostic', ''),
(15, 'Asthma', 'disease', ''),
(16, 'excessive mucus', 'diagnostic', ''),
(17, 'family member have bronchitis', 'diagnostic', ''),
(18, 'Bronchitis', 'disease', ''),
(19, 'Yellow Mucus', 'diagnostic', ''),
(20, 'scattered infiltrates', 'diagnostic', ''),
(21, 'Pneumonia', 'disease', ''),
(22, 'X-ray shows lung lengthwise', 'diagnostic', ''),
(23, 'Hipersonor', 'diagnostic', ''),
(24, 'fever', 'disease', ''),
(25, 'polution', 'diagnostic', ''),
(26, 'smoking', 'diagnostic', ''),
(27, 'Emphysema', 'disease', ''),
(28, 'Old age', 'diagnostic', ''),
(29, 'Ribs'' gap widened', 'diagnostic', ''),
(30, 'Chronic Obstructive Pulmonary Disease', 'disease', ''),
(31, 'positive virus on mucus after wake up', 'diagnostic', ''),
(32, 'positive virus on mucus in first clinic visit', 'diagnostic', ''),
(33, 'positive virus on mucus in second clinic visit', 'diagnostic', ''),
(34, 'BTA Positive', 'diagnostic', ''),
(35, 'Cough more than 2 weeks', 'diagnostic', ''),
(36, 'Infiltrat gather on top of the lungs', 'diagnostic', ''),
(37, 'Bloody cough', 'diagnostic', ''),
(38, 'Significant weight loss', 'diagnostic', ''),
(39, 'TBC', 'disease', ''),
(40, 'Only white on X-Ray', 'diagnostic', ''),
(41, 'yellowish white fluid is found', 'diagnostic', ''),
(42, 'pleural effusion', 'disease', ''),
(43, 'Injury on chest', 'diagnostic', ''),
(44, 'black X-ray', 'diagnostic', ''),
(45, 'Pneumothorax', 'disease', ''),
(46, 'cough on alergen', 'diagnostic', ''),
(47, 'Pain all over the body', 'diagnostic', ''),
(48, 'use mask', 'diagnostic', ''),
(49, 'deal with polution in the daily live', 'diagnostic', ''),
(50, 'flatten diaphragma', 'diagnostic', ''),
(51, 'broken rib sttabbed lung', 'diagnostic', ''),
(52, 'BTAtype1', 'diagnostic', ''),
(53, 'BTAtype2', 'diagnostic', ''),
(54, 'BTAtype3', 'diagnostic', ''),
(55, 'high blood pressure', 'diagnostic', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rules`
--

CREATE TABLE IF NOT EXISTS `rules` (
  `id_rule` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `CF` double NOT NULL,
  `priority` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

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
(23, 39, 1, 23),
(24, 39, 1, 24),
(25, 39, 0.5, 25),
(26, 42, 0.8, 26),
(27, 42, 1, 27),
(28, 45, 1, 28),
(29, 45, 0.5, 28),
(30, 52, 1, 0),
(31, 53, 1, 0),
(32, 54, 1, 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

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
(60, 21, 29, 0, 0),
(61, 31, 30, 0, 0),
(62, 32, 30, 0, 0),
(63, 32, 31, 0, 0),
(64, 33, 31, 0, 0),
(65, 31, 32, 0, 0),
(66, 33, 32, 0, 0),
(67, 52, 20, 1, 0),
(68, 53, 20, 1, 0),
(69, 54, 20, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `drugs`
--
ALTER TABLE `drugs`
  ADD PRIMARY KEY (`id_drug`);

--
-- Indexes for table `drug_patent`
--
ALTER TABLE `drug_patent`
  ADD PRIMARY KEY (`id_drug`);

--
-- Indexes for table `drug_relation`
--
ALTER TABLE `drug_relation`
  ADD PRIMARY KEY (`id_relation`);

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
  MODIFY `id_drug` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `drug_patent`
--
ALTER TABLE `drug_patent`
  MODIFY `id_drug` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=90;
--
-- AUTO_INCREMENT for table `drug_relation`
--
ALTER TABLE `drug_relation`
  MODIFY `id_relation` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  MODIFY `id_linguistic` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `rules`
--
ALTER TABLE `rules`
  MODIFY `id_rule` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `rule_relation`
--
ALTER TABLE `rule_relation`
  MODIFY `id_relation` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=70;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
