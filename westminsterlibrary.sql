-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2019 at 08:05 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `westminsterlibrary`
--

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `borrowDate` varchar(30) DEFAULT NULL,
  `isbn` varchar(10) NOT NULL,
  `returnDate` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`id`, `name`, `email`, `mobile`, `borrowDate`, `isbn`, `returnDate`) VALUES
('\"1\"', '\"ravidu\"', '\"shean@gmail.com\"', '\"0987899\"', '\"2018-12-19T20:20\"', '1', NULL),
('\"5\"', '\"abc\"', '\"def\"', '\"934843894\"', '\"2018-12-20T11:01\"', '10', NULL),
('\"6\"', '\"abc\"', '\"def\"', '\"934843894\"', '\"2018-12-20T11:15\"', '11', NULL),
('\"7\"', '\"abc\"', '\"def\"', '\"934843894\"', '\"2018-12-20T11:15\"', '12', NULL),
('\"11\"', '\"dd\"', '\"dd\"', '\"dd\"', '\"2018-12-20T20:20\"', '15', NULL),
('\"2\"', '\"shehan\"', '\"rv@gmail.com\"', '\"098789944\"', '\"2018-12-20T20:34\"', '2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `isbn` varchar(10) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `section` varchar(30) DEFAULT NULL,
  `publishedDate` varchar(30) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `totalPages` varchar(20) DEFAULT NULL,
  `languages` varchar(20) DEFAULT NULL,
  `substitles` varchar(30) DEFAULT NULL,
  `producer` varchar(30) DEFAULT NULL,
  `actors` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`isbn`, `title`, `section`, `publishedDate`, `author`, `publisher`, `totalPages`, `languages`, `substitles`, `producer`, `actors`) VALUES
('1', '\"Java\"', '\"Book\"', '\"2017-05-02\"', '\"java\"', '\"ABC\"', '\"200\"', NULL, NULL, NULL, NULL),
('10', '\"Game of thrones S4\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('11', '\"Game of thrones S5\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('12', '\"Game of thrones S6\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('13', '\"Game of thrones S7\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('14', '\"The 100\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"Cleark\"', '\"Abby Grifin\"'),
('15', '\"Maze runnr\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"noone\"', '\"gaga\"'),
('16', '\"dance of the dragons\"', '\"book\"', '\"2014-02-04\"', '\"JRRM\"', '\"JRRM\"', '\"400\"', NULL, NULL, NULL, NULL),
('17', '\"Goblet of Fire\"', '\"book\"', '\"2014-02-04\"', '\"JKR\"', '\"JRRM\"', '\"400\"', NULL, NULL, NULL, NULL),
('19', '\"Order of phenix\"', '\"book\"', '\"2014-02-07\"', '\"JKR\"', '\"JRRM\"', '\"500\"', NULL, NULL, NULL, NULL),
('2', '\"Python\"', '\"Book\"', '\"2017-05-02\"', '\"java\"', '\"ABC\"', '\"200\"', NULL, NULL, NULL, NULL),
('27', '\"tale of two cities\"', '\"Book\"', '\"2018-12-20\"', '\"someone\"', '\"someone\"', '\"300\"', NULL, NULL, NULL, NULL),
('28', '\"tale of two cities\"', '\"Book\"', '\"2018-12-20\"', '\"someone\"', '\"someone\"', '\"300\"', NULL, NULL, NULL, NULL),
('29', '\"abc\"', '\"abc\"', '\"2018-12-10\"', '\"someone\"', '\"abc\"', '\"20\"', NULL, NULL, NULL, NULL),
('3', '\"C++\"', '\"Book\"', '\"2017-05-02\"', '\"C++\"', '\"ABC\"', '\"200\"', NULL, NULL, NULL, NULL),
('30', '\"abc\"', '\"abc\"', '\"2018-12-10\"', '\"someone\"', '\"abc\"', '\"20\"', NULL, NULL, NULL, NULL),
('31', '\"dd\"', '\"book\"', '\"2018-12-04\"', '\"ee\"', '\"e\"', '\"22\"', NULL, NULL, NULL, NULL),
('4', '\"NodeJs\"', '\"Book\"', '\"2017-05-02\"', '\"C++\"', '\"ABC\"', '\"200\"', NULL, NULL, NULL, NULL),
('5', '\"Songs\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"Siinhala\"', '\"no\"', '\"Iraj\"', '\"noone\"'),
('6', '\"Songs\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"no\"', '\"Iraj\"', '\"noone\"'),
('7', '\"Game of thrones\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('8', '\"Game of thrones S2\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"'),
('9', '\"Game of thrones S3\"', '\"DVD\"', NULL, NULL, NULL, NULL, '\"English\"', '\"English\"', '\"David Benicoff\"', '\"Kit  harrington\"');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`isbn`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`isbn`),
  ADD UNIQUE KEY `isbn` (`isbn`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `items` (`isbn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
