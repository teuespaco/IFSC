## 1) Crie uma lista com o id e o nome dos clientes que não alugaram nenhum filme no segundo semestre de 2005.
select cliente.cliente_id, cliente.primeiro_nome, cliente.ultimo_nome, aluguel.data.aluguel 
from sakila.cliente, sakila.aluguel 
where aluguel.id_cliente = cliente.id_cliente 
and aluguel_date not between '2005/06/01 00:00:00' and '2005/12/31 23:59:59';

## 2) Crie uma lista com o id e nome dos atores que participaram do filme GREEK EVERYONE
  SELECT ator_id, primeiro_nome, ultimo_nome
  FROM ator
  WHERE ator_id IN
  (SELECT ator_id
  FROM filme_ator
  WHERE filme_id IN
  (SELECT filme_id
  FROM filme
  WHERE titulo = 'GREEK EVERYONE'));

## 3) Crie uma lista com o nome dos filmes que o Ator JOHNNY LOLLOBRIGIDA atuou em 2006
select fil.filme_id, fil.titulo
from filme as fil
inner join filme_ator as fa
on fil.filme_id = fa.filme_id
where fa.ator_id = 5;

## 4) Crie uma lista com o id e o título dos filmes que são de comédia
select fil.titulo, fil.filme_id
from filme as fil
inner join filme_categoria as filcat
on fil.filme_id = filcat.filme_id
inner join categoria as cat
on filcat.categoria_id = cat.categoria_id
where filcat.categoria_id = 5;

# 5) Crie uma lista com o id, nome do cliente e cidade dos clientes brasileiros
SELECT  cli.cliente_id, primeiro_nome, ultimo_nome, cdd.cidade
FROM cliente as cli
inner join endereco as e
on cli.endereco_id = e.endereco_id
inner join cidade as cdd
on e.cidade_id = cdd.cidade_id
inner join pais as p
on cdd.pais_id = p.pais_id
where p.pais_id = 15;
    
#6 6) Crie uma lista com os filmes alugados pela Tamara que mora no Brasil
