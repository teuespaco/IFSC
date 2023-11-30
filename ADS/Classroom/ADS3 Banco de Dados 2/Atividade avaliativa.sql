# 01 - Faça uma pesquisa que retorne os livros comprados por você (a consulta deve conter o nome do livro, o assunto, o nome da categoria e o nome da editora)
select l.titulo, l.assunto, c.nome, e.nome, qw.nome
from livro as l
inner join categoria as qw
on qw.id = l.categoria_id
inner join venda as v
on v.livro_id = l.id
inner join cliente as c
on v.cliente_id = c.id
inner join editora as e
on e.id = l.editora_id
where c.id = 13;

# 02 - Faça uma consulta para verificar se há alguma categoria sem livros comprados pela livraria
select q.nome 
from categoria as q
left join livro as l
on q.id = l.categoria_id
where l.categoria_id is null;

# 03 - Faça uma consulta para verificar se há algum livro que ainda não foi vendido
SELECT l.id, l.titulo, v.livro_id
FROM livro AS l
LEFT JOIN venda AS v
ON v.livro_id = l.id
WHERE v.livro_id IS NULL;

# 04 - O gerente da livraria lhe pediu para verificar os clientes cadastrados que não compraram #nada e pediu para ligar ofertando um cupom de 20% de desconto, faça uma lista com o nome, sobrenome # e telefone
SELECT f.id, f.nome, f.sobrenome, f.telefone, g.cliente_id
FROM cliente AS f
LEFT JOIN venda AS g
ON g.cliente_id = f.id
WHERE g.cliente_id IS NULL;

# 05 - Liste todas as vendas realizadas no mês de março/22
SELECT * FROM venda WHERE date like "%22-03-%" ;
 
# 06 - Buscando uma promoção em seu emprego, para ganhar um aumento salarial, realize uma consulta que apresente dados relevantes ao seu líder (quais dados essa consulta deve mostrar será definido pelo aluno)
SELECT c.id, c.nome, c.sobrenome, c.telefone, c.endereco FROM cliente AS c;


