#Ruan Carlos Binder da Silva

#1
SELECT NOME, TELEFONE FROM CLIENTE;

#2
SELECT NOME FROM clientes;

#3
INSERT INTO cliente (nome, telefone, endereço)
VALUES ( "Audir Cerutti Jr",4799999999, "PR");

#4
select nome, endereço from  cliente where endereço = "SC";

#5
 update cliente set nome="Audir Cerutti Jr" where codigo=20;

#6
update editoras set endereço="PR" where codigo=2;
update editoras set endereço="PR" where codigo=3;
update editoras set endereço="PR" where codigo=4;

#7
update editoras set NOME_do_gerente="Gerente B" where codigo=4;
update editoras set NOME_do_gerente="null" where codigo=2;

#8
select nome,endereço from  editoras where endereço = "PR";

#9
select titulo, autor from  livro where id< 4;

#10
select titulo from  livro where titulo like"%os%";

#11
select titulo from  livro where titulo like"os%";

#12
select titulo, estoque from livro where estoque<=12;

#13
SELECT * FROM livro WHERE id % 2 = 1;

#14
ALTER TABLE cliente ADD Sobre_nome varchar (30) after nome;

#15
SELECT NOME,Sobre_nome as Sobrenome FROM CLIENTE;
