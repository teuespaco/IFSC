CREATE DATABASE Livraria;
USE Livraria;

CREATE TABLE Clientes (
    codigo int(14) auto_increment primary KEY,
    nome VARCHAR(45) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    endereço VARCHAR(90) NOT NULL
);
Create TABLE Livros (
    isbn int(13) NOT NULL PRIMARY KEY,
    Titulo varchar(255) NOT Null,
    assunto VARCHAR(45) NOT NULL,
    autor varchar (45) NOT NULL,
    estoque int (255) NOT NULL
);
drop table livros;

CREATE TABLE Editoras (
    IdEditora INT(11) auto_increment NOT NULL PRIMARY KEY,
    Endereço varchar(40) NOT NULL,
    telefone varchar(11) Not Null,
    Gerente varchar (40) Not null
);

CREATE TABLE Compras_Clientes (
	idcliente int (250) not null,
    idlivro int (250) not null,
    data_compra date NOT NULL,
    FOREIGN KEY (idcliente) REFERENCES Livraria.Clientes(codigo),
	FOREIGN KEY (idlivro) REFERENCES Livraria.Livros(isbn)
);

insert into clientes values (1,'Rodiscley', '40228922', 'Rua dos perdidos');
insert into clientes values (2,'Harry', '40228921', 'BR 280');
insert into clientes values (3, 'Jack','40228920', 'Rua Rodolfo Ziperrer');
insert into clientes values (4, 'Jõao', '40028919', 'Rua Machado de Assis');
insert into clientes values (5, 'Paula', '40028918', 'Avenida Lula da Silva');

insert into livros values ('35651653', 'bizzaras aventuras de joao jorge, sangue fantasma', 'generico', 'araki', 2);
insert into livtos values ('45651654', 'bizzaras aventuras de joao jorge, tendencia de batalha','amizade nazista', 'araki', 50);
insert into livros values ('55651655', 'bizarras aventuras de joao jorge, cruzados do pó de estrela','bromance no deserto','araki', 150);
insert into livros values ('25651652', 'bizarras aventuras de joao jorge, diamantes são inquebraveis', 'descobridor dos 7 mares','araki', 200);
insert into livros values ('15651651', 'bizzaras aventuras de joao jorge, vento dourado', 'mafia italiana', 'araki', 4);

insert into Editoras values (1,'Tokyo', '36222875', 'celso portiolli');
insert into editoras values (2, 'Brás', '911', 'celso russomano');
insert into editoras values (3, 'São Paulo', '109', 'Paracelcius');
insert into editoras values (4, 'Rio de Janeiro', '190', 'Anders Celsius');
insert into editoreas values(5, 'Brasilia','193','Celso Furtado');


insert into compras_clientes value (1, 15651651, '1945-02-28');
insert into compras_clientes value (2, 25651652, '1936-09-01');
insert into compras_clientes value (3, 35651652, '1991-12-25');
insert into compras_clientes value (4, 45651652, '1995-11-01');
insert into compras_clientes value (5, 55651652, '2022-02-24');



