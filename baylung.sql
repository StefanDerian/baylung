-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2016 at 07:38 PM
-- Server version: 5.6.26
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
-- Table structure for table `drugs`
--

CREATE TABLE IF NOT EXISTS `drugs` (
  `id_drug` int(11) NOT NULL,
  `drugname` varchar(225) NOT NULL,
  `price` int(11) NOT NULL,
  `miligram` double NOT NULL,
  `drug_explaination` text NOT NULL,
  `rules` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drugs`
--

INSERT INTO `drugs` (`id_drug`, `drugname`, `price`, `miligram`, `drug_explaination`, `rules`) VALUES
(1, 'Amoxicillin', 500, 500, '', ''),
(2, 'Amoxicillin Syrup', 5800, 125, '', ''),
(3, 'Cefadroxyl', 5800, 50, '', ''),
(4, 'Cefadroxyl syrup', 11000, 125, '', ''),
(5, 'Ciprofloxacin', 350, 500, '', ''),
(6, 'Azitromisin', 12500, 0, '', ''),
(7, 'Ambroxol', 170, 0, 'Ambroxol is a metabolite of bromhexine<br> and is used similarly as a mucolytic.', ''),
(8, 'Acethylcysteine', 1500, 0, '', ''),
(9, 'Aminophyline', 90, 0, 'Aminophylline is a combination of theophylline and ethylenediamine.\r\nTheophylline relaxes bronchial smooth muscle. Suggested mechanisms are an increase in intracellular cAMP through inhibition of phosphodiesterase\r\n', ''),
(10, 'Salbutamol', 110, 2, '', ''),
(11, 'Teofilin', 250, 150, '', ''),
(12, 'Antasid', 110, 0, '', ''),
(13, 'lanzoprasol', 630, 0, '', ''),
(14, 'asam mefernamat', 265, 0, '', ''),
(15, 'paracetamol', 270, 500, '', ''),
(16, 'paracetamol syrup', 3100, 0, '', ''),
(17, 'Asam Trameksamat', 300, 0, '', ''),
(18, 'Vit C', 120, 0, '', ''),
(19, 'Amboclipin', 200, 5, '', ''),
(20, 'Dexamethazon', 120, 0.5, '', ''),
(21, 'Ceterizine', 420, 0, 'Cetirizine is a potent and highly selective antagonist of the peripheral histamine H1-receptor on effector cells in the GI tract, blood vessels and resp tract.', ''),
(22, 'Diazepam', 85, 2, '', ''),
(23, 'Salbutamol inhaler', 115000, 0, '', ''),
(24, 'Salbutamol respuler', 12000, 0, '', ''),
(25, 'loratadun', 460, 10, '', ''),
(26, 'Methylprednisolone', 690, 4, 'Methylprednisolone is a synthetic corticosteroid with mainly glucocorticoid activity and minimal mineralocorticoid properties. It decreases inflammation by suppression of migration of polymorphonuclear leukocytes and reversal of increased capillary permeability.', ''),
(27, 'furosemid', 135, 40, '', ''),
(28, 'kaspartat', 700, 300, '', ''),
(29, 'Kdikloferak', 880, 0, '', ''),
(30, 'Metoclopramide', 130, 0, '', ''),
(31, 'Antibiotik', 100, 10, '', ''),
(32, 'analgetik', 100, 10, '', ''),
(33, 'Ethambutol', 100, 100, 'Ethambutol appears to inhibit the synthesis of 1 or more metabolites in susceptible bacteria resulting in impairment of cellular metabolism, arrest of multiplication, and cell death. It is active against susceptible bacteria only when they are undergoing cell division.', ''),
(34, 'Pirasinamid', 100, 10, 'Its activity appears to partly depend on conversion of the drug to pyrazinoic acid (POA), which lowers the pH of the environment below that which is necessary for growth of Mycobacterium tuberculosis', ''),
(35, 'Rifampisin', 100, 100, 'Rifampicin suppresses initiation of chain formation for RNA synthesis in susceptible bacteria by binding to the ? subunit of DNA-dependent RNA polymerase, thus blocking RNA transcription.', ''),
(36, 'INH', 100, 100, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `drug_patent`
--

CREATE TABLE IF NOT EXISTS `drug_patent` (
  `id_drug` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `explaination` text NOT NULL,
  `id_generic_drug` int(11) NOT NULL,
  `rules` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drug_patent`
--

INSERT INTO `drug_patent` (`id_drug`, `name`, `price`, `explaination`, `id_generic_drug`, `rules`) VALUES
(1, 'Lameson tab 16 mg 100''s', 540000, 'Initially 4-48 mg daily, then gradually reduced to the lowest effective dose for maintenance. \r\nShould be taken with food.\r\n', 26, ''),
(2, 'Lanadexon caplet 500 mcg 10 × 10''s', 8500, 'Should be taken with food', 26, ''),
(3, 'Medrol tab 16 mg  30''s', 267425, 'Initially 4-48 mg daily. High-dose therapy: 160 mg/day for a wk followed by 64 mg every other day for 1 mth.\r\nShould be taken with food.\r\n', 26, ''),
(4, 'Somerol tab 4 mg  5 × 10''s', 100000, 'Should be taken with food', 26, ''),
(5, 'Metrison tab 4 mg 100''s', 135000, 'Adult Initially 4-48 mg/day as a single or in divided doses. Multiple sclerosis 160 mg/day for 1 wk, followed by 64 mg every other day for 1 mth. \r\nShould be taken with food.\r\n', 26, ''),
(21, 'Amoxsan cap 250 mg 10 × 10''s', 136840, '', 1, ''),
(22, 'Amoxsan cap 500 mg 10 × 10''s', 280340, '', 1, ''),
(23, 'Bufamoxy cap 500 mg 10 × 10''s ', 351120, '', 1, ''),
(24, 'Kalmoxilin tab 500 mg 10 × 10''s', 190000, '', 1, ''),
(25, 'Mestamox cap 250 mg 10 × 10''s  ', 133000, '', 1, ''),
(26, 'Mestamox cap 500 mg 10 × 10''s ', 265500, '', 1, ''),
(27, 'Novax caplet 500 mg 5 × 10''s', 125000, '', 1, ''),
(28, 'Pehamoxil F tab 500 mg 5 × 10''s ', 44400, '', 1, ''),
(29, 'Rindomox caplet 500 mg 10 × 10''s', 165000, '', 1, ''),
(30, 'Widecillin cap 500 mg 10 × 10''s ', 240000, '', 1, ''),
(31, 'Widecillin cap 500 mg 500''s', 510000, '', 1, ''),
(32, 'Amoxillin cap 500 mg 100''s', 140800, '', 1, ''),
(33, 'Extropect tab 30 mg 5 × 10''s', 37500, 'Should be taken with food.', 7, ''),
(34, 'Mucopect tab 30 mg 10 × 10''s', 254760, 'Should be taken with food: ', 7, ''),
(35, 'Mucopect Retard cap 75 mg 5 × 10''s', 392500, 'Retard cap: Swallow whole, do not chew/crush.', 7, ''),
(41, 'Farmadol tab 500 mg 10 × 10''s', 25000, '', 15, ''),
(42, 'Ikacetamol syr 120 mg/5 mL 60 mL x 24 × 1''s ', 3850, '', 15, ''),
(43, 'Pamol tab 500 mg v', 37000, '', 15, ''),
(44, 'Panadol caplet 500 mg', 6900, '', 15, ''),
(45, 'Progesic tab 500 mg 100''s ', 20500, '', 15, ''),
(46, 'Progesic syr 250 mg/5 mL 60 mL x 1''s', 7250, '', 15, ''),
(47, 'Sanmol Forte tab 650 mg 10 × 10''s', 25000, '', 15, ''),
(48, 'Sanmol tab 500 mg 25 × 4''s', 21500, '', 15, ''),
(49, 'Rydian film-coated tab 10 mg 3 × 10''s', 82500, 'May be taken with or without food.', 21, ''),
(50, 'Ryzen tab 10 mg 30''s', 157000, '1 tab daily. 11 mth 5 drops daily. Patient w/ renal insufficiency 5 mg daily to ½ the usual dosage.\r\nMay be taken with or without food.\r\n', 21, ''),
(51, 'Ozen syr 5 mg/5 mL\r\n60 mL x 1''s\r\n', 49500, 'Adult & childn >12 yr 10 mg daily, \r\nMay be taken with or without food.\r\n', 21, ''),
(52, 'Ozen film-coated tab 10 mg 30''s', 122100, 'Adult & childn >12 yr 10 mg daily, \r\nMay be taken with or without food.\r\n', 21, ''),
(62, 'Phyllocontin tab 225 mg', 95000, 'Should be taken on an empty stomach: Take at least 1 hr before or 2 hr after meals. ', 9, ''),
(63, 'Aminophyllin Indo Farma tab 200 mg 100', 8030, '', 9, ''),
(64, 'Aminophyllin Indo Farma tab 200 mg 1000', 43440, '', 9, ''),
(65, 'Amoxsan cap 250 mg 10 × 10''s', 136840, 'Cap/Dispersible tab Adult & childn ?20 kg 250-500 mg 8 hrly May be taken with or without food: May be taken w/ meals for better absorption & to reduce GI discomfort.', 31, ''),
(66, 'Ospamox FC tab 500 mg 10 × 10''s', 194000, 'May be taken with or without food: May be taken w/ meals for better absorption & to reduce GI discomfort', 31, ''),
(68, 'Ponstan FC tab 500 mg 10''s', 19555, 'Adult Initially 500 mg then 250 mg 6 hrly. Should be taken with food: Take immediately after meals.', 32, ''),
(71, 'Dolos caplet 500 mg 10 × 10''s', 57500, 'Should be taken with food: Take immediately after meals.', 32, ''),
(72, 'Pondex Forte caplet 100''s', 56000, 'Should be taken with food: Take immediately after meals.', 32, ''),
(73, 'Ponstelax cap 250 mg 200''s', 50000, 'Should be taken with food: Take immediately after meals.', 32, ''),
(74, 'Opimox caplet 500 mg 10 × 10''s', 200000, 'Adult 250-500 mg 8 hrly. May be taken with or without food: May be taken w/ meals for better absorption & to reduce GI discomfort.', 31, ''),
(75, 'Lapimox caplet 500 mg 100''s', 110000, 'Adult 250-500 mg 8 hrly. May be taken with or without food: May be taken w/ meals for better absorption & to reduce GI discomfort.', 31, ''),
(76, 'Ciproxin tab 500 mg 20''s', 370700, 'May be taken with or without food: May be taken w/ meals to minimise GI discomfort. Do not take w/ antacids, Fe or dairy products. XR tab: Swallow whole, do not chew/crush.', 31, ''),
(77, 'Rifamtibi FC caplet 450 mg', 352000, 'Adult >50 kg 600 mg daily, <50 kg 450 mg daily. To be taken as a single dose for 1st 4 wk. For the next 5 mth, usual dose is 600 mg 2 times wkly. Should be taken on an empty stomach: Best taken on an empty stomach 1 hr before or 2 hr after meals.', 35, ''),
(78, 'RIF 300 cap 300 mg 30''s', 217500, 'Should be taken on an empty stomach: Take at least ½ hr before meals', 35, ''),
(79, 'RIF 300 cap 300 mg 30''s', 98000, 'Should be taken on an empty stomach: Best taken on an empty stomach 1 hr before or 2 hr after meals.', 35, ''),
(80, 'Bacbutol tab 500 mg 160''s ', 205000, '', 33, ''),
(81, 'Tibitol tab 250 mg 100''s', 42000, '', 33, ''),
(82, 'Santibi Plus tab 10 × 10''s', 53000, '', 33, ''),
(83, 'Inoxin tab 150''s', 40000, 'Should be taken on an empty stomach: Best taken on an empty stomach 1 hr before or 2 hr after meals. May be taken w/ meals to reduce GI discomfort.', 36, ''),
(84, 'INH-Ciba tab 300 mg 10 × 10''s ', 53000, 'Should be taken on an empty stomach: Best taken on an empty stomach 1 hr before or 2 hr after meals. May be taken w/ meals to reduce GI discomfort.', 36, ''),
(85, 'Pulmolin tab 100''s', 36300, 'Therapy: Adult 1 tab daily. Adult 4-6 mg/kg body wt daily. Max: 300 mg.\r\nBest taken on an empty stomach 1 hr before or 2 hr after meals. May be taken w/ meals to reduce GI discomfort.\r\n', 36, ''),
(86, 'Prazina tab 500 mg 100''s', 145000, '20-35 mg/kg body wt/day. Max: 3 g daily. Adult >60 kg 1,500 mg daily, 40-60 kg 1,000 mg daily, <40 kg 750 mg daily. All doses to be taken 3 times daily. Should be taken with food.', 34, ''),
(87, 'Pezeta-Ciba 500 tab 500 mg 10 × 10''s', 121000, 'Should be taken with food.', 34, ''),
(88, 'Sanazet tab 500 mg 10 × 10''s', 102500, 'Adult 20-35 mg/kg body wt. Max: 3 g .Should be taken with food. ', 34, ''),
(89, 'Corsazinamid tab 500 mg 100''s', 88000, 'Should be taken with food.', 34, ''),
(90, 'Siramid FC caplet 500 mg 10 × 10''s', 115000, 'Adult 20-35 mg/kg body wt daily. Max: 3 g daily. Should be administered together w/ at least 2 other anti-TB drugs. Should be taken with food.', 34, ''),
(91, 'Baquinor Forte FC caplet 500 mg 2 × 10''s', 222800, 'May be taken with or without food: May be taken w/ meals to minimise GI discomfort. Do not take w/ antacids, Fe or dairy products.', 31, ''),
(92, 'Lapiflox tab 250 mg 30''s', 138000, 'Mild infections 250 mg twice daily. Severe infections 500-750 mg twice daily May be taken with or without food: May be taken w/ meals to minimise GI discomfort. Do not take w/ antacids, Fe or dairy products.', 31, ''),
(93, 'Quidex tab 500 mg 5 × 6''s ', 290000, 'Tab Mild infection: 250 mg twice daily. Severe infection: 500-750 mg twice daily.  or without food: May be taken w/ meals to minimise GI discomfort. Do not take w/ antacids, Fe or dairy products.', 31, '');

-- --------------------------------------------------------

--
-- Table structure for table `drug_relation`
--

CREATE TABLE IF NOT EXISTS `drug_relation` (
  `id_relation` int(11) NOT NULL,
  `id_drug` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `id_condition` int(11) NOT NULL,
  `not_in` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drug_relation`
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
-- Table structure for table `linguistic_variable`
--

CREATE TABLE IF NOT EXISTS `linguistic_variable` (
  `id_linguistic` int(11) NOT NULL,
  `linguistic_name` varchar(255) NOT NULL,
  `type` enum('disease','diagnostic','','') NOT NULL,
  `explaination` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `linguistic_variable`
--

INSERT INTO `linguistic_variable` (`id_linguistic`, `linguistic_name`, `type`, `explaination`) VALUES
(1, 'itchy on alergen', 'diagnostic', ''),
(2, 'sneeze on alergen', 'diagnostic', ''),
(3, 'have family members who have alergy', 'diagnostic', ''),
(4, 'Alergy', 'disease', ''),
(5, 'Headache', 'diagnostic', ''),
(6, 'Increasing body temperature', 'diagnostic', ''),
(7, 'sore throat', 'diagnostic', ''),
(8, 'loss of appetite', 'diagnostic', ''),
(9, 'Rash on skin', 'diagnostic', ''),
(10, 'Whezzing', 'diagnostic', ''),
(11, 'Cough with uncertain frequency', 'diagnostic', ''),
(12, 'very hard to breathe', 'diagnostic', ''),
(13, 'sticky mucus', 'diagnostic', ''),
(14, 'Family member have asthma', 'diagnostic', ''),
(15, 'Asthma', 'disease', 'This disease is the culprit for the coughing, wheezing, chest tighness and breathlessness. Asthma can be caused by the things we find daily. <br>The common asthma triggers include house dust mites, animal fur, pollen, cigarette smoke, exercise and viral infections.<br>The additional causes of asthma range from family history and allergy. <br>People with asthma is advised to inhale the medicine inside the inhalers.'),
(16, 'excessive mucus', 'diagnostic', ''),
(17, 'family member have bronchitis', 'diagnostic', ''),
(18, 'Bronchitis', 'disease', 'Brochitis is a pulmonary disease which is caused by the imflamation in the bronkhioli(the branch of broncus).<br> The imflamation cause the damage in the wall of bronkhioli. <br>\r\nBronchitis can be caused by the virus, dirty environment, etc which may cause infection inside the human body.<br>  Actually bronchitis will be cleared after few weeks. However it is advised to drink liquid and get plenty of rests.\r\n'),
(19, 'Yellow Mucus', 'diagnostic', ''),
(20, 'scattered infiltrates', 'diagnostic', 'scattered'),
(21, 'Pneumonia', 'disease', 'Pneumonia is inflamation or swelling in the tissue inside the lungs of the lungs. At the end of the breathing tubes(alveoli),fluid will flood it and make it swell(inflamation). The syptoms include a cough(may produce mucus which is yellow, green, brown, or with blood), fever, and the difficulty in breathing. \r\nPneumonia commonly caused by the bacteria called Streptococcus pneumoniae. The bacteria occurred in the dirty environment such as smoky environment(environment which has smoking people inside it).Because of that, it is important to keep good hygiene and a healthy lifestyle.\r\n'),
(22, 'X-ray shows lung lengthwise', 'diagnostic', ''),
(23, 'Hipersonor', 'diagnostic', ''),
(24, 'fever', 'disease', ''),
(25, 'polution', 'diagnostic', ''),
(26, 'smoking', 'diagnostic', ''),
(27, 'Emphysema', 'disease', ''),
(28, 'Old age', 'diagnostic', ''),
(29, 'Ribs'' gap widened', 'diagnostic', ''),
(30, 'Chronic Obstructive Pulmonary Disease', 'disease', 'Chronic obstructive pulmonary disease or copd is caused by the narrowing airways or airflow obstruction. The narrowing is caused by the inflamation which leads tto the permanent changes. The wall of the airways thicken and produce mucus. In addition, damage to the delicate walls of the air sacs will cause emphysema(the lost of lung elasticity). The inflamation of the airways mainly caused by smoking. The smoke from smoking will irrittes and inflame the lungs which leads to the narrowing airways. Moreover, the polution and dust around us in daily life will contribute more in inflamation. Least effective but being the cause is that the genetic of the COPD. The ancestors or siblings which has COPD will indicate the higher risk of being attacked by COPD.'),
(31, 'positive virus on mucus after wake up', 'diagnostic', ''),
(32, 'positive virus on mucus in first clinic visit', 'diagnostic', ''),
(33, 'positive virus on mucus in second clinic visit', 'diagnostic', ''),
(34, 'BTA Positive', 'diagnostic', ''),
(35, 'Cough more than 2 weeks', 'diagnostic', ''),
(36, 'Infiltrat gather on top of the lungs', 'diagnostic', ''),
(37, 'Bloody cough', 'diagnostic', ''),
(38, 'Significant weight loss', 'diagnostic', ''),
(39, 'TBC', 'disease', 'Tuberculosis is the bacterial infection spread through infection or inhaling tiny droplets from infected people. The main cause of the disease is the Mycobacterium tuberculosis. Normally, the disease will vanish as the immune system kills the bacteria. However, sometimes, the immune system fail to kill the bacteria and remain in the body(latent TB). Latent TB will spread all over the body within few weeks or months and become active once the immune system weakened. The symmptoms of TB include coughing, extreme weight lost, high temperature, tiredness and fatique, etc. Mainly the main cause of TB is that the contonous coughing(different from asthma and bronchitis).'),
(40, 'Only white on X-Ray', 'diagnostic', ''),
(41, 'yellowish white fluid is found', 'diagnostic', ''),
(42, 'pleural effusion', 'disease', 'This disease is caused by the abnormal amount of fluid around the lung. The fluids accumulates in the space beetween the layers of pleura. The cause of pleural effusion include the congestive heart failure, pneumonia, liver disease, cancer, lupus, and liver disease. The disease will cause the body fail to handle the fluid properly. Syptoms of pleural effusions will include shortnes of brath, chest pain, fever and cough. '),
(43, 'Injury on chest', 'diagnostic', ''),
(44, 'black X-ray', 'diagnostic', ''),
(45, 'Pneumothorax', 'disease', 'The lungs have a smooth covering called pleura that lets the lungs expand without rubbing on the inside of the chest. Pneumothorax is that the damage in this area causing air to enter the space and traped. <br>The space itself will be filled by the air and makinf th pressure to the lung.<br> As a result the lungs are pushed and impact on the heart. Pneumothorax is divided into primary and secodary penumothorax.<br> Primary neumothorax is caused spntaneusly and without any injury to the lung. This is caused by several diseases sch as pneumonia and tuberculosis.<br> The disease make the lung’s tissue become weak and let air get into the space. Meanwhile, the secondary penumothorax is caused by the external lung’s injury(can be caused by being stabbed by external objects such as knife).'),
(46, 'cough on alergen', 'diagnostic', ''),
(47, 'Pain all over the body', 'diagnostic', ''),
(48, 'use mask', 'diagnostic', ''),
(49, 'deal with polution in the daily live', 'diagnostic', ''),
(50, 'flatten diaphragma', 'diagnostic', ''),
(51, 'broken rib sttabbed lung', 'diagnostic', ''),
(52, 'BTAtype1', 'diagnostic', ''),
(53, 'BTAtype2', 'diagnostic', ''),
(54, 'BTAtype3', 'diagnostic', ''),
(55, 'shrinking lungs', 'diagnostic', 'The lungs are shrunk because of the air coming out due to the gaps in the lungs'),
(57, 'Ronchy', 'diagnostic', ''),
(59, 'rough pattern on rontchen', 'diagnostic', ''),
(60, 'High Blood Pressure', 'diagnostic', ''),
(61, 'Kidney is dirty?', 'diagnostic', '');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id_question` int(11) NOT NULL,
  `question` text NOT NULL,
  `type` int(11) NOT NULL,
  `linguistic_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id_question`, `question`, `type`, `linguistic_id`) VALUES
(2, 'Your sistle diastole high?', 2, 60),
(3, 'yuyuyuyuyuyu', 1, 61);

-- --------------------------------------------------------

--
-- Table structure for table `rules`
--

CREATE TABLE IF NOT EXISTS `rules` (
  `id_rule` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `CF` double NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rules`
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
-- Table structure for table `rule_relation`
--

CREATE TABLE IF NOT EXISTS `rule_relation` (
  `id_relation` int(11) NOT NULL,
  `id_linguistic` int(11) NOT NULL,
  `id_rule` int(11) NOT NULL,
  `connector` tinyint(1) NOT NULL,
  `not` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rule_relation`
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
(30, 4, 15, 0, 1),
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
  ADD PRIMARY KEY (`id_relation`),
  ADD KEY `id_condition` (`id_condition`),
  ADD KEY `id_linguistic` (`id_linguistic`);

--
-- Indexes for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  ADD PRIMARY KEY (`id_linguistic`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`);

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
  MODIFY `id_drug` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=94;
--
-- AUTO_INCREMENT for table `drug_relation`
--
ALTER TABLE `drug_relation`
  MODIFY `id_relation` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `linguistic_variable`
--
ALTER TABLE `linguistic_variable`
  MODIFY `id_linguistic` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=62;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id_question` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `rules`
--
ALTER TABLE `rules`
  MODIFY `id_rule` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `rule_relation`
--
ALTER TABLE `rule_relation`
  MODIFY `id_relation` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=79;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `drug_relation`
--
ALTER TABLE `drug_relation`
  ADD CONSTRAINT `drug_relation_ibfk_1` FOREIGN KEY (`id_relation`) REFERENCES `linguistic_variable` (`id_linguistic`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
