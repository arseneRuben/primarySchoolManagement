DROP DATABASE IF EXISTS primarydb;
CREATE DATABASE primarydb ;
use primarydb;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `profile_image` varchar(50) DEFAULT NULL,
  `matricule` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `birth_date` varchar(50) DEFAULT NULL,
  `birth_place` varchar(50) DEFAULT NULL,
  `birth_country` varchar(50) DEFAULT NULL,
  `previous_school` varchar(50) DEFAULT NULL,
  `region_origin` varchar(50) DEFAULT NULL,
  `birth_certificate` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp()

);

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `profile_image` varchar(255) DEFAULT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `google_id` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `enabled` int(1) DEFAULT 0,
  `access_level` enum('personnel','admin') DEFAULT 'personnel'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;