create database monitor_sensors;

\c monitor_sensors;

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

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 1', 'PC33-56', 'Pressure', 0, 16, 'bar', 'Room1', 'Pressure Sensor');

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 2', 'EH-567', 'Voltage', -25, 25, 'voltage', 'Room1', 'Voltage Sensor');

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 3', 'TER-21', 'Temperature', -70, 50, '°Ñ', 'Room2', 'Temperature Sensor');

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 4', 'H94', 'Humidity', 0, 100, '%', 'Room3', 'Humidity Sensor');

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 5', 'EH-555', 'Voltage', 15, 40, 'voltage', 'Room4', 'Voltage Sensor');

insert into sensor (name, model, type, range_from, range_to, unit, location, description)
values ('Sensor 6', 'TER-25', 'Temperature', -20, 30, '°Ñ', 'Room42', 'Temperature Sensor');
