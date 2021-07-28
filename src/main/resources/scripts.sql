create table if not exists sensor
(
    id          serial primary key,
    name        varchar(255),
    model       varchar(255),
    type        varchar(255),
    range_from  int,
    range_to    int,
    unit        varchar(255),
    location    varchar(255),
    description varchar(255)
    );

create table if not exists users
(
    id       serial primary key,
    username varchar(255),
    password varchar(255),
    role     varchar(255)
    );

create table if not exists type
(
    id   serial primary key,
    name varchar(255)
    );

insert into type (name)
values ('Pressure');

insert into type (name)
values ('Voltage');

insert into type (name)
values ('Temperature');

insert into type (name)
values ('Humidity');

create table if not exists unit
(
    id   serial primary key,
    name varchar(255)
    );

insert into unit (name)
values ('bar');

insert into unit (name)
values ('voltage');

insert into unit (name)
values ('°Ñ');

insert into unit (name)
values ('%');
