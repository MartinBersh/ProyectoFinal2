create database horarios;
use horarios;

create table horarios(
id int auto_increment primary key,
NombreProfesor varchar(20) not null,
Aula varchar (20) not null,
Horario varchar(20) not null
);

insert into horarios(NombreProfesor, Aula, Horario)  Values (NombreProfesor, Aula,Horario);