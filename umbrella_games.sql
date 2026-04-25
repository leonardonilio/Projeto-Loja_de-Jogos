-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25/04/2026 às 05:01
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `umbrella_games`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categorias`
--

CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `nome_categoria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nome_categoria`) VALUES
(1, 'Ação'),
(2, 'RPG'),
(3, '3D'),
(4, '2D'),
(5, 'Misterio'),
(6, 'Indie'),
(7, 'Shooter'),
(8, 'Atmosferico');

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria_jogo`
--

CREATE TABLE `categoria_jogo` (
  `id_categoria` int(11) NOT NULL,
  `id_jogo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `jogos`
--

CREATE TABLE `jogos` (
  `id_categoria` int(11) DEFAULT NULL,
  `id_jogo` int(11) NOT NULL,
  `nota` double NOT NULL,
  `valor` double NOT NULL,
  `desenvolvedora` varchar(255) DEFAULT NULL,
  `detalhes` varchar(255) DEFAULT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `nome_jogo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `jogos`
--

INSERT INTO `jogos` (`id_categoria`, `id_jogo`, `nota`, `valor`, `desenvolvedora`, `detalhes`, `imagem`, `nome_jogo`) VALUES
(3, 1, 8.9, 59.99, 'Ubisoft', 'é um jogo de ação e aventura em mundo aberto que dá continuidade direta à história de Assassin\'s Creed II, com o lendário Mestre Assassino Ezio Auditore da Firenze', 'assassin\'s creed brotherhood - capa1.png', 'Assassin\'s Creed Brotherhood'),
(7, 2, 10, 44.99, 'Gearbox Software', 'Borderlands 2 é um looter-shooter de ação e RPG focado em quatro novos Vault Hunters lutando para libertar o planeta Pandora do ditador Handsome Jack, CEO da Hyperion Corporation.', 'borderlands 2 - capa1.png', 'Borderlands2'),
(7, 3, 8.7, 0, 'Valve', 'Counter-Strike 2, também conhecido como CS2, é um jogo tático multijogador de tiro em primeira pessoa anunciado em 22 de março de 2023 e lançado em 27 de setembro de 2023.', 'counter-strike 2 - capa1.png', 'Counter-Strike 2'),
(5, 4, 10, 75.49, 'ZA/UM', 'Disco Elysium - The Final Cut é um RPG de detetive isométrico e focado em narrativa, onde você controla um policial amnésico e alcoólatra tentando resolver um assassinato em Martinaise', 'Disco Elysium - capa1.png', 'Disco Elysium'),
(2, 5, 9.5, 274.5, 'FromSoftware', 'Elden Ring é um RPG de ação de mundo aberto desenvolvido pela FromSoftware, ambientado nas Terras Intermédias após a destruição do Anel Prístino (Elden Ring). O jogador controla um Maculado ', 'elden ring - capa1.png', 'Elden Ring'),
(2, 6, 9.7, 39, 'Obsidian Entertainment', 'Fallout: New Vegas (2010) é um RPG pós-apocalíptico onde você joga como Courier (Entregador), que sobrevive a uma tentativa de assassinato após ser baleado na cabeça.', 'fallout new vegas - capa1.png', 'Fallout: New Vegas'),
(6, 7, 9, 25.99, 'Facepunch Studios', 'Garry\'s Mod (GMod) é um jogo sandbox de física sem objetivos pré-definidos, desenvolvido por Garry Newman.', 'garry\'s mod - capa1.png', 'Garry\'s Mod'),
(4, 8, 10, 46.99, 'Team Cherry', 'Hollow Knight é um jogo de ação e aventura metroidvania 2D no qual você controla um pequeno cavaleiro sem nome explorando o vasto e arruinado reino subterrâneo de Hallownest.', 'hollow knight - capa1.png', 'Hollow Knight'),
(5, 9, 8.7, 49.99, 'Daniel Mullins Games', 'Inscryption é uma odisseia sombria de cartas que mistura terror psicológico, elementos de roguelike e quebra-cabeças escape room.', 'inscryption - capa1.png', 'Inscryption'),
(8, 10, 8.8, 43.99, 'thatgamecompany', 'Journey é uma parábola interativa e contemplativa, onde um viajante encapuzado atravessa um vasto deserto em direção a uma montanha sagrada.', 'journey - capa1.png', 'Journey'),
(7, 13, 9.5, 274.5, 'Valve', 'Half-Life (1998) acompanha Gordon Freeman, um físico teórico no complexo secreto de Black Mesa, que acidentalmente abre um portal dimensional para o mundo alienígena Xen durante um experimento falho.', 'Half-Life.png', 'Half-Life'),
(1, 14, 9.7, 0, 'Valve', 'Dota 2 é um jogo eletrônico do gênero multiplayer online battle arena desenvolvido e publicado pela Valve.', 'Dota 2.png', 'Dota 2'),
(7, 15, 9, 0, 'Valve', 'Deadlock é um jogo de tiro em terceira pessoa e arena de batalha online multijogador desenvolvido e publicado pela Valve.', 'Deadlock.png', 'Dealock'),
(3, 16, 10, 46.99, 'Valve', 'Portal é uma série de jogos eletrônicos de primeira pessoa, com puzzles em plataforma desenvolvida por Valve Corporation.', 'Portal.png', 'Portal'),
(3, 17, 8.7, 49.99, 'Valve', 'Portal 2 é um jogo eletrônico de quebra-cabeça em plataformas desenvolvido e publicado pela Valve Corporation', 'Portal 2.png', 'Portal 2'),
(7, 18, 10, 0, 'Valve', 'Team Fortress 2 é um jogo eletrônico free-to-play multijogador de tiro em primeira pessoa desenvolvido pela Valve, baseado em equipes e com foco em combates.', 'Team Fortress 2.png', 'Team Fortress 2'),
(2, 19, 10, 44.99, 'Ubisoft', 'Rayman Origins é um jogo de plataforma 2D de 2011 que narra como Rayman, Globox e os Teensies precisam salvar a Clareira dos Sonhos.', 'Rayman Origins.png', 'Rayman Origins'),
(3, 20, 8.7, 260, 'Ubisoft', 'For Honor é um jogo de ação e luta corpo a corpo desenvolvido pela Ubisoft, ambientado em um mundo alternativo onde cavaleiros, vikings, samurais e outras facções guerreiras colidem em uma guerra perpétua.', 'For Honor.png', 'FOR HONOR'),
(8, 21, 9.5, 27.5, 'Ubisoft', 'Beyond Good & Evil (2003) é um jogo de ação e aventura da Ubisoft onde a repórter Jade investiga uma conspiração alienígena no planeta Hillys.', 'Beyond Good and Evil.png', 'Beyond Good & Evil'),
(3, 22, 9.7, 280, 'Ubisoft', 'The Crew Motorfest é um jogo de corrida em mundo aberto desenvolvido pela Ivory Tower e publicado pela Ubisoft. A sinopse do jogo se concentra em um festival automotivo vibrante. ', 'The Crew Motor Fest.png', 'The Crew Motorfest'),
(3, 23, 9, 60, 'Ubisoft', 'Star Wars Outlaws é um jogo de ação em mundo aberto ambientado entre O Império Contra-Ataca e O Retorno de Jedi.', 'Star Wars Outlaws.png', 'Star Wars Outlaws'),
(2, 24, 10, 46.99, 'Ubisoft', 'South Park: The Stick of Truth é um RPG satírico onde você controla o Novato, uma criança que se muda para a cidade e se envolve em uma guerra de RPG ao vivo entre as crianças locais', 'South Park the Stick of Truth.png', 'South Park: The Stick of Truth'),
(3, 25, 8.7, 49.99, 'Ubisoft', 'Assassin\'s Creed II é um jogo de ação e aventura ambientado na Renascença Italiana (1476-1499), onde o jovem nobre Ezio Auditore da Firenze busca vingança após a traição e execução de sua família.', 'Assassin\'s Creed 2.png', 'Assassin\'s Creed 2'),
(8, 26, 8.8, 43.99, 'Ubisoft', 'Valiant Hearts: The Great War é um jogo de aventura e puzzle 2D da Ubisoft, ambientado na Primeira Guerra Mundial, que foca na narrativa emocionante de quatro personagens (e um cão fiel) cujos destinos se cruzam.', 'Valiant Hearts Coming Home.png', 'Valiant Hearts: Coming Home'),
(1, 27, 9.8, 125.99, 'Capcom', 'Leon S. Kennedy, segue o rastro da raptada filha do presidente até uma vila europeia isolada, onde há algo terrivelmente errado com os habitantes.', 'Resident_Evil4.png', 'Resident Evil 4'),
(2, 28, 0, 0, 'Sandbox Interactive', 'Albion Online é um MMORPG sandbox em que você escreve sua própria história, em vez de seguir um caminho pré-determinado. Explore um vasto mundo aberto que consiste de 5 ecossistemas únicos.', 'albion-online.jpg', 'Albion Online'),
(8, 29, 90, 0, 'eu', '465', '1777060181010_bubba port.webp', 'meu');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `administrador` bit(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `email_usuario` varchar(255) DEFAULT NULL,
  `nome_usuario` varchar(255) DEFAULT NULL,
  `senha_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`administrador`, `id_usuario`, `email_usuario`, `nome_usuario`, `senha_usuario`) VALUES
(b'0', 1, 'adalberto@gamil', 'Adalberto Gomes', 'abc123'),
(b'1', 2, 'borguinho@gamil', 'Borguinho Barros', 'def456'),
(b'0', 3, 'carlos@gamil', 'Carlos de Carvalho', 'ghi789'),
(b'0', 4, 'daniel@gamil', 'Daniel Denevtz', 'jkl101112'),
(b'0', 5, 'emanuel@gamil', 'Emanuel Santos', 'mno131415'),
(b'0', 6, 'fabricio@gamil', 'Fabricio de Oliveira', 'pqr161718'),
(b'0', 7, 'gilberto@gamil', 'Gilberto Gill', 'tuv192021'),
(b'0', 8, 'homero@gamil', 'Homero Barbosa', 'wxy222324'),
(b'0', 9, 'ivandro@gamil', 'Ivandro Costa', 'zAB252627'),
(b'0', 10, 'jeremias@gamil', 'Jeremias de Holanda', 'CDE282930');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Índices de tabela `categoria_jogo`
--
ALTER TABLE `categoria_jogo`
  ADD PRIMARY KEY (`id_categoria`,`id_jogo`);

--
-- Índices de tabela `jogos`
--
ALTER TABLE `jogos`
  ADD PRIMARY KEY (`id_jogo`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `jogos`
--
ALTER TABLE `jogos`
  MODIFY `id_jogo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
