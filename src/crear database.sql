DELIMITER $$
drop database if exists apple;
create database apple;
use apple;
create table dispositivo(id_dispositivo int,nombre varchar(30),precio int,tipo varchar(30));
$$
DELIMITER  ;