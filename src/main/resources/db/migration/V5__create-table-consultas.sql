create table agendamentos(

    id bigint not null auto_increment,
    usuario_id bigint not null,
    barbearia_id bigint not null,
    data datetime not null,
    motivo_cancelamento varchar(100),

    primary key(id),
    constraint fk_agendamento_usuario_id foreign key (usuario_id) references usuarios(id),
    constraint fk_agendamento_barbearia_id foreign key (barbearia_id) references barbearias(id)

);