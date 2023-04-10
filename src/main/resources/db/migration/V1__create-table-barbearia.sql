create table barbearias(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cidade varchar(50) not null,
    bairro varchar (50) not null,
    rua varchar (100) not null,
    numero varchar (30) not null,
    cep varchar (8) not null,
    telefone varchar (50) not null,
    imagem varchar (250),


    primary key(id)

);