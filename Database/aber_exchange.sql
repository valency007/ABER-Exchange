-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2018 at 05:32 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aber_exchange`
--

-- --------------------------------------------------------

--
-- Table structure for table `credit_redemption`
--

CREATE TABLE IF NOT EXISTS `credit_redemption` (
  `cid` int(10) NOT NULL,
  `cemail` varchar(100) NOT NULL,
  `credit_use` int(10) NOT NULL,
  `reward` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credit_redemption`
--

INSERT INTO `credit_redemption` (`cid`, `cemail`, `credit_use`, `reward`) VALUES
(1, 'thanos4@gmail.com', 100, '1,000 Quantas Miles'),
(3, 'red@amex.com', 100, '$5 Reloadable Amex Gift Card'),
(4, 'The Hulk', 1000, 'Toxic Radioactive Material');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE IF NOT EXISTS `order_details` (
  `id` int(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `cnumber` int(100) NOT NULL,
  `s_address` varchar(100) NOT NULL,
  `d_address` varchar(1000) NOT NULL,
  `notes` varchar(1000) NOT NULL,
  `fare` int(100) NOT NULL DEFAULT '10',
  `rider` varchar(1000) NOT NULL DEFAULT 'UNASSIGNED',
  `isDonation` int(10) NOT NULL,
  `status` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `name`, `email`, `cnumber`, `s_address`, `d_address`, `notes`, `fare`, `rider`, `isDonation`, `status`) VALUES
(1, 'Captain America', 'stever@gmail.com', 479165182, 'Sydney', 'Melbourne', 'Please call', 10, 'valency007@gmail.com', 0, 1),
(8, 'Iron Man', 'tonystark@usyd.com', 1234567890, 'Los Angeles', 'San Fransisco', 'Call Pepper Potts', 10, 'valencycolaco@gmail.com', 1, 1),
(9, 'Steve Madden', 'steve.madden@gmail.com', 493124587, 'Darwin', 'Perth', 'Call if needed', 10, 'valency007@gmail.com', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) NOT NULL,
  `description` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `uid` int(10) NOT NULL,
  `category` varchar(100) NOT NULL,
  `isDonation` int(10) NOT NULL,
  `title` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `price`, `uid`, `category`, `isDonation`, `title`) VALUES
(1, '2012 Model', 1000, 7533, 'Electronics', 0, 'Macbook Air'),
(2, '2 months used', 50, 9984, 'Furniture', 1, 'TV Stand');

-- --------------------------------------------------------

--
-- Table structure for table `rider_location`
--

CREATE TABLE IF NOT EXISTS `rider_location` (
  `email` varchar(100) NOT NULL,
  `lat` varchar(100) NOT NULL,
  `lon` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rider_location`
--

INSERT INTO `rider_location` (`email`, `lat`, `lon`) VALUES
('valency007@gmail.com', '-33.8883039', '151.1959351'),
('valencycolaco@gmail.com', '-33.8883278', '151.1959317');

-- --------------------------------------------------------

--
-- Table structure for table `rider_login`
--

CREATE TABLE IF NOT EXISTS `rider_login` (
  `id` int(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rider_login`
--

INSERT INTO `rider_login` (`id`, `email`, `password`) VALUES
(1, 'valency007@gmail.com', '7f7f28d1c935a598450596ed4e7e7366'),
(2, 'valencycolaco@gmail.com', '7f7f28d1c935a598450596ed4e7e7366');

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE IF NOT EXISTS `teams` (
  `id` int(6) NOT NULL,
  `name` varchar(40) NOT NULL,
  `rating` int(6) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`id`, `name`, `rating`) VALUES
(1, 'Manchester United', 100),
(8, 'Real Madrid', 90),
(9, 'Chelsea FC', 70),
(10, 'Manchester City', 55),
(11, 'Everton', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user_information`
--

CREATE TABLE IF NOT EXISTS `user_information` (
  `uid` int(11) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `uploaded_item_count` int(11) NOT NULL,
  `ucredit` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_information`
--

INSERT INTO `user_information` (`uid`, `fname`, `lname`, `email`, `password`, `uploaded_item_count`, `ucredit`) VALUES
(1, 'Chris', 'Pratt', 'chris.pratt@gmail.com', 'crisprat', 10, 1000),
(2, 'Tony', 'Stark', 'tony.stark@gmail.com', 'pepperpotts', 10, 100),
(6, 'Gwen', 'Stefani', 'gwen@email.com', 'blakeshelton', 20, 25000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credit_redemption`
--
ALTER TABLE `credit_redemption`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rider_location`
--
ALTER TABLE `rider_location`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `rider_login`
--
ALTER TABLE `rider_login`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_information`
--
ALTER TABLE `user_information`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credit_redemption`
--
ALTER TABLE `credit_redemption`
  MODIFY `cid` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `rider_login`
--
ALTER TABLE `rider_login`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `user_information`
--
ALTER TABLE `user_information`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
