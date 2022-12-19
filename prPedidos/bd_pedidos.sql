use bd_pedidos;
create table pedidos (
id int primary key auto_increment,
nombre varchar(30) not null,
precio float not null,
categoria varchar(30) not null

);
select * from pedidos;