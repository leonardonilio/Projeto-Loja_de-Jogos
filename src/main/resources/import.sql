INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (1, 	"Assassin's Creed Brotherhood", 	"Ubisoft Montreal", 		"/resources/imagem/capa/assassin's creed brotherhood - capa1.png", 	59.99,		8.9, 		"ACB desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (2, 	"Borderlands2", 					"Gearnox Software", 		"/resources/imagem/capa/borderlands2 - capa1.png", 					44.99,		10, 		"BL2 desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (3,	"Counter-Strike 2",					"Valve",					"/resources/imagem/capa/counter-strike 2 - capa1.png",				0,			8.7,		"CS2 desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (4,	"Disco Elysium",					"ZA/UM",					"/resources/imagem/capa/disco elysium - capa1.png",					75.49,		10,			"DE desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (5,	"Elden Ring",						"FromSoftware",				"/resources/imagem/capa/elden ring - capa1.png",					274.50,		9.5,		"ELR desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (6,	"Fallout: New Vegas",				"Obsidian Entertainment",	"/resources/imagem/capa/fallout new vegas - capa1.png",				39,			9.7,		"FNV desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (7,	"Garry's Mod",						"Facepunch Studios",		"/resources/imagem/capa/garry's mod - capa1.png",					25.99,		9,			"GM desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (8,	"Hollow Knight",					"Team Cherry",				"/resources/imagem/capa/hollow knight - capa1.png",					46.99,		10,			"HLK desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (9,	"Inscryption",						"Daniel Mullins Games",		"/resources/imagem/capa/inscryption - capa1.png",					49.99,		8.7,		"INC desc");
INSERT INTO jogos(Id_jogo, Nome_jogo, desenvolvedora, imagem, valor, nota, detalhes) VALUE (10,	"Journey",							"thatgamecompany",			"/resources/imagem/capa/journey - capa1.png",						43.99,		8.8,		"JRN desc");


INSERT INTO categorias(id_categoria, nome_categoria) VALUE (1,	"Acao");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (2,	"RPG");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (3,	"3D");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (4,	"2D");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (5,	"Misterio");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (6,	"Indie");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (7,	"Shooter");
INSERT INTO categorias(id_categoria, nome_categoria) VALUE (8,	"Atmosferico");


INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (1,	1);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (3,	1);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (2,	2);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (7,	2);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (7,	3);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (1,	3);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (6,	4);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (5,	4);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (2,	5);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (1,	5);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (2,	6);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (3,	6);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (3,	7);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (6,	7);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (6,	8);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (4,	8);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (5,	9);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (8,	9);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (6,	10);
INSERT INTO categoria_jogo(id_categoria, id_jogo) VALUE (8,	10);



INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (1,	"Adalberto Gomes",	"adalberto@gamil",	"abc123",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (2,	"Borguinho Barros",	"borguinho@gamil",	"def456",	1);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (3,	"Carlos de Carvalho",	"carlos@gamil",		"ghi789",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (4,	"Daniel Denevtz",	"daniel@gamil",		"jkl101112",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (5,	"Emanuel Santos",	"emanuel@gamil",	"mno131415",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (6,	"Fabricio de Oliveira",	"fabricio@gamil",	"pqr161718",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (7,	"Gilberto Gill",	"gilberto@gamil",	"tuv192021",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (8,	"Homero Barbosa",	"homero@gamil",		"wxy222324",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (9,	"Ivandro Costa",	"ivandro@gamil",	"zAB252627",	0);
INSERT INTO usuarios(id_usuario, nome_usuario, email_usuario, senha_usuario, administrador) VALUE (10,	"Jeremias de Holanda",	"jeremias@gamil",	"CDE282930",	0);


