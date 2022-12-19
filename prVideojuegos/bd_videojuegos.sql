use pr_videjuegos;
create table videojuegos (
id int primary key auto_increment,
nombre varchar(30) not null,
precio float not null,
consola varchar(30) not null,
pegi int not null
);