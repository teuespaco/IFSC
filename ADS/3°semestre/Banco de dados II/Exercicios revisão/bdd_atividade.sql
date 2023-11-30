-- 1
 select c.cliente_id, c.primeiro_nome 
 from cliente as c
 left join aluguel as a
 on c.cliente_id = a.cliente_id
 where a.cliente_id is null;
 
 -- 2
 select a.aluguel_id, a.data_de_aluguel
 from aluguel as a  
 left join pagamento as p
 on a.aluguel_id = p.aluguel_id
 where p.aluguel_id is null;
 
 -- 3
 select f.filme_id, f.titulo  
 from filme as f 
 left join inventario as i
 on f.filme_id = i.filme_id
 where i.filme_id is null;
 
 -- 4
select f.filme_id, f.titulo  
from filme as f 
inner join inventario as i
on f.filme_id = i.filme_id
left join aluguel as a
on i.inventario_id = a.inventario_id
where a.inventario_id is null;
 
 -- 5
 select f.filme_id, f.titulo  
 from filme as f 
 left join filme_ator as fa
 on f.filme_id = fa.filme_id
 where fa.ator_id is null;
 
 -- 6
 select a.ator_id, a.primeiro_nome
 from ator as a 
 left join filme_ator as fa
 on a.ator_id = fa.ator_id
 where fa.filme_id is null;

  -- 7
 select c.cliente_id, c.primeiro_nome 
 from aluguel as a
 right join cliente as c
 on a.cliente_id = c.cliente_id
 where a.cliente_id is null;
 
 -- 8
 select a.aluguel_id, a.data_de_aluguel
 from pagamento as p  
 right join aluguel as a
 on a.aluguel_id = p.aluguel_id
 where p.aluguel_id is null;
 
 -- 9
 select f.filme_id, f.titulo  
 from inventario as i 
 right join filme as f
 on f.filme_id = i.filme_id
 where i.filme_id is null;
 
-- 10
select f.filme_id, f.titulo  
from aluguel as a 
right join inventario as i
inner join filme as f
on f.filme_id = i.filme_id
on i.inventario_id = a.inventario_id
where a.inventario_id is null;

-- 11
 select f.filme_id, f.titulo  
 from filme_ator as fa 
 right join filme as f
 on f.filme_id = fa.filme_id
 where fa.ator_id is null;
 
 -- 12
 select a.ator_id, a.primeiro_nome
 from filme_ator as fa 
 right join ator as a
 on a.ator_id = fa.ator_id
 where fa.filme_id is null;
 
 -- 13
select f.filme_id, f.titulo, a.ator_id, a.primeiro_nome
from filme as f, ator as a

 
 