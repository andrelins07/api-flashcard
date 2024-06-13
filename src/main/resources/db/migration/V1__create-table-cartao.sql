create table cartao(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    total_topicos smallint,
    data_criacao date,
    primary key(id)
);
create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    total_flashCards smallint,
    data_criacao date,
    cartao_id int,

    primary key(id)

);
create table flashcard(

    id bigint not null auto_increment,
    pergunta varchar(250) not null,
    resposta varchar(500) not null,
    data_criacao date,
    nivel varchar(100) not null,
    topico_id int,

    primary key(id)
);
