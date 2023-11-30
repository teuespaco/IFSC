#Ruan Carlos Binder da Silva

Select * from compras_clientes;

#1
INSERT INTO livro (titulo, assunto, autor, editoras_Codigo, estoque)
VALUES ( "O sol é para todos", "Assunto 11", "Autor 11", 1, 15);

#2
INSERT INTO livro (titulo, assunto, autor, editoras_Codigo, estoque)
VALUES ( "O poder do habito", "Assunto 12", "Autor 12", 5, 22);

#3
INSERT INTO livro (titulo, assunto, autor, editoras_Codigo, estoque)
VALUES ( "Vidas secas", "Assunto 13", "Autor 13", 2, 8);

#4
INSERT INTO livro (titulo, assunto, autor, editoras_Codigo, estoque)
VALUES ( "O nome do vento", "Assunto 14", "Autor 14", 5, 12);

#5
INSERT INTO livro (titulo, assunto, autor, editoras_Codigo, estoque)
VALUES ( "A ultima flecha", "Assunto 15", "Autor 15", 2, 19);

#6
INSERT INTO clientes (nome, telefone, endereço) VALUES ( "Ruan", "789456", "Canoinhas/SC");
INSERT INTO compras_clientes (idcliente, idlivro) VALUES ( 6, 18);

#7
INSERT INTO clientes (nome) VALUES ( "Aldir");
INSERT INTO compras_clientes (idcliente, idlivro) VALUES ( 7, 19);



Select * from compras_clientes;
Select * from clientes;
Select * from livro;
