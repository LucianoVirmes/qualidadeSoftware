create table cliente(
	codigo int primary key auto_increment not null,
	email varchar(100),
	nome varchar(140),
	sobrenome varchar(140),
	senha varchar(100),
	cpf varchar(14),
	cidade varchar(100),
	estado varchar(100),
	bairro varchar(100),
	rua varchar(100),
	numero varchar(45)

);

drop table produto;
drop table cliente;
drop table categoria;

create table categoria(
	codigo int primary key auto_increment not null,
    nome varchar(100)
);

insert into categoria (nome) value("telefones");


create table produto(
	codigo int primary key auto_increment not null,
    nome varchar(140),
    valor double,
    disponibilidade boolean,
    modelo varchar(100),
    porcentagemDesconto double,
    codCategoria int,
    
    constraint fk_produto_categora foreign key(codCategoria) references categoria(codigo)
    
);


select max(codigo) from cliente;

select * from cliente;

delete from cliente where nome = "nome";
delete from cliente where codigo = 5;

select * from produto where porcentagemDesconto > 0;

insert into cliente (nome) value ("telefones");
select last_insert_id();