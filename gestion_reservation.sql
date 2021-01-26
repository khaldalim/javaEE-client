-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 26 jan. 2021 à 16:15
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_reservation`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE IF NOT EXISTS `chambre` (
  `num_chambre` int(11) NOT NULL AUTO_INCREMENT,
  `tel_chambre` varchar(255) NOT NULL,
  PRIMARY KEY (`num_chambre`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chambre`
--

INSERT INTO `chambre` (`num_chambre`, `tel_chambre`) VALUES
(3, '0101010101'),
(4, '0101010101'),
(5, '10'),
(6, '574'),
(7, '0101010101'),
(8, '65'),
(9, '65'),
(10, '654'),
(11, '654');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `num_client` int(11) NOT NULL AUTO_INCREMENT,
  `adresse_client` varchar(255) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `tel_client` varchar(255) NOT NULL,
  PRIMARY KEY (`num_client`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`num_client`, `adresse_client`, `email_client`, `nom_client`, `prenom_client`, `tel_client`) VALUES
(13, '57 Boulevard emile zola', 'demetleo@hotmail.fr', 'DEMET', 'Léo', '0667996441'),
(3, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(4, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(5, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(6, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(7, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(8, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(9, '57 babla', 'demetleo@hotmail.fr', 'demet', 'léo', '0601020304'),
(10, '57 Boulevard emile zola', 'frmrylr@gfd.gt', 'DEMET', 'Léo', 'gfdg'),
(11, '57 Boulevard emile zola', 'demetleo@hotmail.fr', 'DEMET', 'Léo', 'gfgdsgds'),
(12, 'fdsf', 'demetleo@hotmail.fr', 'ABC', 'fd', '0667996441');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `num_reserv` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `num_chambre` int(11) NOT NULL,
  `num_client` int(11) NOT NULL,
  PRIMARY KEY (`num_reserv`),
  KEY `FKdeymgjokwklxe4b5u76bgtw79` (`num_chambre`),
  KEY `FK3kvsps4hjlg5sd3hrclb22d9d` (`num_client`)
) ENGINE=MyISAM AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`num_reserv`, `date_debut`, `date_fin`, `num_chambre`, `num_client`) VALUES
(68, '2020-12-29', '2021-03-27', 5, 3);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`role`) VALUES
('ADMIN'),
('USER');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `active` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `password`, `active`) VALUES
('admin', '$2a$10$HGKD3XyvuHCeKpfFk02HvOs9mfXUt8Wj/SMkdK5w7JbNh6Cv6W1Ny', 1),
('user', '$2a$10$HGKD3XyvuHCeKpfFk02HvOs9mfXUt8Wj/SMkdK5w7JbNh6Cv6W1Ny', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`username`,`role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`username`, `role`) VALUES
('admin', 'ADMIN'),
('admin', 'USER'),
('user', 'USER');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
