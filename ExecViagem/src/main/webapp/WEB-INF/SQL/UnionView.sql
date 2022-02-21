CREATE DATABASE unionview
GO
USE unionview
GO
CREATE TABLE motorista (
cod_motorista			INT				NOT NULL		IDENTITY(12341, 1),
nome_motorista			VARCHAR(40)		NOT NULL,
naturalidade_motorista	VARCHAR(40)		NOT NULL,
PRIMARY KEY (cod_motorista)
)
GO
CREATE TABLE onibus (
placa_onibus			CHAR(7)			NOT NULL,
marca_onibus			VARCHAR(15)		NOT NULL,
ano_onibus				INT				NOT NULL,
descricao_onibus		VARCHAR(20)		NOT NULL,
PRIMARY KEY (placa_onibus)
)
GO
CREATE TABLE viagem (
cod_viagem				INT				NOT NULL	IDENTITY(101, 1),
onibus_viagem			CHAR(7)			NOT NULL,
motorista_viagem		INT				NOT NULL,
hr_saida_viagem			INT				NOT NULL	CHECK(hr_saida_viagem >= 0),
hr_chegada_viagem		INT				NOT NULL	CHECK(hr_chegada_viagem >= 0),
partida_viagem			VARCHAR(40)		NOT NULL,
destino_viagem			VARCHAR(40)		NOT NULL,
PRIMARY KEY (cod_viagem),
FOREIGN KEY (onibus_viagem)		REFERENCES onibus(placa_onibus),
FOREIGN KEY (motorista_viagem)	REFERENCES motorista(cod_motorista)
)

INSERT INTO motorista (nome_motorista, naturalidade_motorista) VALUES 
('Julio Cesar',			'S�o Paulo'),
('Mario Carmo',			'Americana'),
('Lucio Castro',		'Campinas'),
('Andr� Figueiredo',	'S�o Paulo'),
('Luiz Carlos',			'S�o Paulo'),
('Carlos Roberto',		'Campinas'),
('Jo�o Paulo',			'S�o Paulo')

INSERT INTO onibus (placa_onibus, marca_onibus, ano_onibus, descricao_onibus) VALUES
('adf0965',	'Mercedes',		2009, 	'Leito'),
('bhg7654',	'Mercedes',		2012,	'Sem Banheiro'),
('dtr2093',	'Mercedes',		2017, 	'Ar Condicionado'),
('gui7625',	'Volvo',		2014,	'Ar Condicionado'),
('jhy9425',	'Volvo',		2018,	'Leito'),
('lmk7485',	'Mercedes',		2015,	'Ar Condicionado'),
('aqw2374',	'Volvo',		2014,	'Leito')

INSERT INTO viagem (onibus_viagem, motorista_viagem, hr_saida_viagem, hr_chegada_viagem, partida_viagem, destino_viagem) VALUES
('adf0965',	12343,	10,	12,	'S�o Paulo',				'Campinas'),
('gui7625',	12341,	7,	12,	'S�o Paulo',				'Araraquara'),
('bhg7654',	12345,	14,	22,	'S�o Paulo',				'Rio de Janeiro'),
('dtr2093',	12344,	18,	21,	'S�o Paulo',				'Sorocaba'),
('aqw2374',	12342,	11,	17,	'S�o Paulo',				'Ribeir�o Preto'),
('jhy9425',	12347,	10,	19,	'S�o Paulo',				'S�o Jos� do Rio Preto'),
('lmk7485',	12346,	13,	20,	'S�o Paulo',				'Curitiba'),
('adf0965',	12343,	14,	16,	'Campinas',					'S�o Paulo'),
('gui7625',	12341,	14,	19,	'Araraquara',				'S�o Paulo'),
('bhg7654',	12345,	0,	8,	'Rio de Janeiro',			'S�o Paulo'),
('dtr2093',	12344,	22,	1,	'Sorocaba',					'S�o Paulo'),
('aqw2374',	12342,	19,	5,	'Ribeir�o Preto',			'S�o Paulo'),
('jhy9425',	12347,	22,	7,	'S�o Jos� do Rio Preto',	'S�o Paulo'),
('lmk7485',	12346,	0,	7,	'Curitiba',					'S�o Paulo')

--1) Criar um Union das tabelas Motorista e �nibus, com as colunas ID (C�digo e Placa) e Nome (Nome e Marca)
SELECT CAST(cod_motorista AS CHAR(7)) AS ID, nome_motorista AS Nome
FROM motorista
UNION
SELECT placa_onibus AS ID, marca_onibus AS Nome
FROM onibus

--2) Criar uma View (Chamada v_motorista_onibus) do Union acima
CREATE VIEW  v_motorista_onibus
AS
SELECT CAST(cod_motorista AS CHAR(7)) AS ID, nome_motorista AS Nome
FROM motorista
UNION
SELECT placa_onibus AS ID, marca_onibus AS Nome
FROM onibus

--3) Criar uma View (Chamada v_descricao_onibus) que mostre o C�digo da Viagem, o Nome do motorista, a placa do �nibus (Formato XXX-0000), 
--	 a Marca do �nibus, o Ano do �nibus e a descri��o do onibus
CREATE VIEW v_descricao_onibus 
AS
SELECT v.cod_viagem, m.nome_motorista, SUBSTRING(o.placa_onibus, 1, 3)  + '-' + SUBSTRING(o.placa_onibus, 4, 4) AS placa_onibus, 
		o.marca_onibus, o.ano_onibus, o.descricao_onibus
FROM viagem v, motorista m, onibus o
WHERE m.cod_motorista = v.motorista_viagem
	AND o.placa_onibus = v.onibus_viagem

--4) Criar uma View (Chamada v_descricao_viagem) que mostre o C�digo da viagem, a placa do �nibus(Formato XXX-0000), 
--	 a Hora da Sa�da da viagem (Formato HH:00), a Hora da Chegada da viagem (Formato HH:00), partida e destino
CREATE VIEW v_descricao_viagem
AS
SELECT v.cod_viagem, SUBSTRING(o.placa_onibus, 1, 3)  + '-' + SUBSTRING(o.placa_onibus, 4, 4) AS placa_onibus, 
convert(varchar(2), v.hr_saida_viagem) + ':' + '00' AS hora_saida,
convert(varchar(2), v.hr_chegada_viagem) + ':' + '00' AS hora_chegada,
v.partida_viagem, v.destino_viagem
FROM viagem v, onibus o
WHERE o.placa_onibus = v.onibus_viagem



SELECT * FROM motorista
SELECT * FROM onibus
SELECT * FROM viagem
SELECT * FROM v_motorista_onibus
SELECT * FROM v_descricao_onibus
SELECT * FROM v_descricao_viagem