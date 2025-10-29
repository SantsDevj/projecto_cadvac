create database cadvac
default character set utf8mb3
collate utf8mb3_general_ci
;
use cadvac;

create table if not exists usuario(
id_usuario int primary key auto_increment,
nome varchar(255) not null unique,
email varchar(255) not null,
senha varchar(255) not null,
tipo_usuario varchar(50) not null,
data_nasc date,
sexo varchar(10),
enderecos varchar(255),
telefone int,
registro_prof varchar(50) unique,
especialidade varchar(100),
setor_respons varchar(100)
) default charset utf8mb3;

desc usuario;