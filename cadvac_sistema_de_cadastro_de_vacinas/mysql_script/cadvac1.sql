USE cadvac;

CREATE TABLE usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
senha VARCHAR(255) NOT NULL,
tipo_usuario VARCHAR(50) NOT NULL /*Este campo indica que o usuário pode ser paciente, profissional de saúde e gestor*/,
data_nasc DATE,
sexo VARCHAR(10),
endereco VARCHAR(255),
telefone INT,
registro_prof VARCHAR(50) UNIQUE /*Este campo é para profissional de saúde*/,
especialidade VARCHAR(100) /*Este campo é para profissional de saúde*/,
setor_respons VARCHAR(100)
);

CREATE TABLE vacina(
id_vacina INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
fabricante VARCHAR(255),
validade DATE NOT NULL,
quant_despon INT NOT NULL
);

SHOW TABLES;

CREATE TABLE vacina_aplicada(
id_aplicacao INT PRIMARY KEY AUTO_INCREMENT,
data_aplicacao DATETIME NOT NULL,
lote VARCHAR(50),
dose VARCHAR(50),
local_aplicacao VARCHAR(255),
id_paciente INT NOT NULL,
id_profissional INT NOT NULL,
id_vacina INT NOT NULL,
FOREIGN KEY(id_paciente) REFERENCES usuario(id_usuario),
FOREIGN KEY (id_profissional) REFERENCES usuario(id_usuario),
FOREIGN KEY (id_vacina) REFERENCES vacina(id_vacina)
);

CREATE TABLE estoque(
id_estoque INT PRIMARY KEY AUTO_INCREMENT,
id_vacina INT NOT NULL,
quantidade INT NOT NULL,
LOCAL VARCHAR(255),
data_validade DATE NOT NULL,
FOREIGN KEY (id_vacina) REFERENCES vacina(id_vacina)
);


CREATE TABLE alerta(
id_alerta INT PRIMARY KEY AUTO_INCREMENT,
id_paciente INT NOT NULL,
tipo VARCHAR(100) NOT NULL,
descricao TEXT NOT NULL,
data_geracao DATETIME NOT NULL,
status VARCHAR(50) NOT NULL,
FOREIGN KEY(id_paciente) REFERENCES usuario(id_usuario)
);

CREATE TABLE relatorio(
id_relatorio INT PRIMARY KEY AUTO_INCREMENT,
tipo_relatorio VARCHAR(100),
data_geracao DATETIME NOT NULL,
id_gestor INT NOT NULL,
FOREIGN KEY (id_gestor) REFERENCES usuario(id_usuario)
);



