create table registros (
        id bigint not null unique auto_increment,
        login varchar(100) not null unique,
        contrasena varchar(255) not null,

        primary key (id)
);