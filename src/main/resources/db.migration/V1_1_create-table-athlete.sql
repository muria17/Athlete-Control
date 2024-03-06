create table athlete(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    peso varchar(100) not null unique,
    altura varchar(6) not null unique,
    dataInicio date not null,
    idade int not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);