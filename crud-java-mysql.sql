-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2021 at 11:57 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crud-java-mysql`
--
CREATE DATABASE IF NOT EXISTS `crud-java-mysql` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `crud-java-mysql`;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `nome_cli` varchar(50) NOT NULL,
  `email_cli` varchar(50) NOT NULL,
  `end_cli` varchar(100) NOT NULL,
  `fone_cli` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`client_id`, `nome_cli`, `email_cli`, `end_cli`, `fone_cli`) VALUES
(1, 'Tupã', 'tupagod@gmail.com', 'São Paulo, Brasil', '1234-5678'),
(2, 'Jaci', 'noite.jaci@gmail.com', 'São Paulo, Brasil', '5654-4474'),
(3, 'Guaraci', 'guaraci@gmail.com', 'São Paulo, Brasil', '6208-4208'),
(4, 'Ceuci', 'ceuci@gmail.com', 'São Paulo, Brasil', '9510-7530'),
(5, 'Anhangá', 'anhanga@gmail.com', 'São Paulo, Brasil', '7530-9510'),
(6, 'Sumé', 'sume@gmail.com', 'São Paulo, Brasil', '4826-9537'),
(7, 'Akuanduba', 'araras.akuanduba@gmail.com', 'São Paulo, Brasil', '9855-2634'),
(8, 'Yorixiriamori', 'passaro.ianomami@gmail.com', 'São Paulo, Brasil', '9865-2137'),
(9, 'Yebá Beló', 'dessanas.belo@gmail.com', 'São Paulo, Brasil', '6789-9876'),
(10, 'Wanadi', 'lecuanas.wanadi@gmail.com', 'São Paulo, Brasil', '1243-2134'),
(11, 'Yebá Ngoamãn', 'dessanas.ngoaman@gmail.com', 'São Paulo, Brasil', '2020-1520');

-- --------------------------------------------------------

--
-- Table structure for table `ordem_servico`
--

CREATE TABLE `ordem_servico` (
  `os` int(11) NOT NULL,
  `data_os` timestamp NOT NULL DEFAULT current_timestamp(),
  `tipo` varchar(20) NOT NULL,
  `situacao` varchar(50) NOT NULL,
  `equipamento` varchar(150) NOT NULL,
  `defeito` varchar(150) NOT NULL,
  `servico` varchar(150) NOT NULL,
  `tecnico` varchar(30) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordem_servico`
--

INSERT INTO `ordem_servico` (`os`, `data_os`, `tipo`, `situacao`, `equipamento`, `defeito`, `servico`, `tecnico`, `valor`, `client_id`) VALUES
(1, '2021-11-25 14:57:38', 'Orçamento', 'Orçamento Reprovado', 'Xiaomi Mi A2 Lite - 32GB', 'Android 9 não inicia', 'Formatação de fábrica para restauração do Android', 'Marcos', '65.00', 3),
(2, '2021-11-16 21:04:49', 'Ordem de Serviço', 'Aguardando Aprovação', 'Computador Intel I5 - 4G de RAM - 2T de HD. COD 1234.5678', 'A placa de vídeo não inicia', 'Trocar placa de vídeo e pente de memória.', 'Marcos', '150.00', 4),
(3, '2021-11-25 21:53:31', 'Ordem de Serviço', 'Aguardando Peças', 'Impressora HP Deskjet F2050', 'Cabo USB não conecta com o computador/notebook', 'Trocar cabo e adaptador', 'Paola', '30.00', 10),
(4, '2021-11-25 22:26:41', 'Ordem de Serviço', 'Abandonado', 'Mouse Óptico Multilaser 1200dpi - conexão USB', 'Scroll e cabo quebrados', 'Trocar cabo e recolocar scroll', 'Matias', '24.99', 1),
(5, '2021-11-25 22:11:45', 'Orçamento', 'Aguardando Aprovação', 'Caixa de Som Bluetooth/Rádio/Pen-drive KTS-935', 'Som sai abafado, bluetooth não conecta e quando conecta a bateria acaba rápido ', 'Verificar cabos, trocar bateria e saída de som', 'Paola', '149.99', 2),
(6, '2021-11-25 22:44:24', 'Ordem de Serviço', 'Na bancada', 'Tablet Positivo Ypy - 16GB - 7\"', 'Lentidão após atualizardo Android 4 para o Android 7', 'Backup de dados e redefinição de fábrica. *O cliente autorizou a venda ao abandonar o produto', 'Matias', '699.00', 6),
(9, '2021-11-25 22:51:36', 'Orçamento', 'Entregue', 'Câmera Fotográfica HD Samsung PL120 - 1.5\" front LCD - 14.2 megapixels', 'Lente quebrada', 'Trocar lente', 'Paola', '80.00', 8);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user`, `login`, `senha`, `fone`, `perfil`) VALUES
(1, 'Administrador Principal', 'admin', '1234', '940028922', 'admin'),
(2, 'Bianca Silva', 'beanca', '4321', '948485353', 'admin'),
(3, 'Usuário Comum', 'user', '1234', '915907530', 'user'),
(4, 'Usuário Teste', 'teste', '4321', '984481618', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`client_id`);

--
-- Indexes for table `ordem_servico`
--
ALTER TABLE `ordem_servico`
  ADD PRIMARY KEY (`os`),
  ADD UNIQUE KEY `client_id` (`client_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `ordem_servico`
--
ALTER TABLE `ordem_servico`
  MODIFY `os` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ordem_servico`
--
ALTER TABLE `ordem_servico`
  ADD CONSTRAINT `ordem_servico_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
