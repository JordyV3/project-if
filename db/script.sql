create table categoria
(
    id          int auto_increment
        primary key,
    nombre      varchar(50)  null,
    descripcion varchar(150) null
);

create table user
(
    id        int auto_increment
        primary key,
    nombre    varchar(50)  null,
    apellido  varchar(50)  null,
    direccion varchar(150) null,
    username  varchar(45)  null,
    password  varchar(45)  null
);

create table cuenta
(
    id             int auto_increment
        primary key,
    cuenta         int      null,
    saldo          double   null,
    fecha_creacion datetime null,
    id_user        int      null,
    constraint cuenta_ibfk_1
        foreign key (id_user) references user (id)
);

create index id_user
    on cuenta (id_user);

create table transaccion
(
    id                int auto_increment
        primary key,
    tipo_transaccion  varchar(50)  null,
    fecha_transaccion datetime     null,
    monto             tinyint(1)   null,
    descripcion       varchar(150) null,
    id_cuenta         int          null,
    id_categoria      int          null,
    constraint transaccion_ibfk_1
        foreign key (id_cuenta) references cuenta (id),
    constraint transaccion_ibfk_2
        foreign key (id_categoria) references categoria (id)
);

create index id_categoria
    on transaccion (id_categoria);

create index id_cuenta
    on transaccion (id_cuenta);


