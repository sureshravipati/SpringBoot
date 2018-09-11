-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2018 at 10:50 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `corejava`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookid` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `volume` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` bigint(20) NOT NULL,
  `bookid` bigint(20) DEFAULT NULL,
  `duration_in_hours` int(11) DEFAULT NULL,
  `subject_title` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=ascii;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `bookid`, `duration_in_hours`, `subject_title`) VALUES
(1, 1, 10, 'First Subject');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `enabled` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `enabled`, `password`, `role`) VALUES
('USER1', 1, '$2a$10$jfL2znISMGz7rOW75iIoP.izdMs.1QiP0Mze4pYs/cA3Cvn00g6bC', 'PRINCIPAL'),
('USER2', 1, '$2a$10$Ra6AShXgbSQPWsv.NRhvIurP38GOSqQO6ec8j893Nvt1ZDUNseA5q', 'LIBRARIAN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
