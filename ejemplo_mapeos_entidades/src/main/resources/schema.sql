
create table departamento (id  serial not null, nombre varchar(255) not null, responsable_id int4, primary key (id));

create table persona (id  serial not null, apellido varchar(10), departamento_id int4 not null, edad int4 check (edad>=18 AND edad<=150), email varchar(255), nombre varchar(255) not null, primary key (id));

create table persona_departamento (id_departamento int4 not null, id_persona int4 not null, primary key (id_departamento, id_persona));

alter table departamento add constraint FKr1coslpjbnj2hv8irdxua61jv foreign key (responsable_id) references persona;

alter table persona add constraint FKnu5811v0um7wh5op3s19cnjw foreign key (departamento_id) references departamento;

alter table persona_departamento add constraint FKinuwbjk9i9iuefs0psehvoe9s foreign key (id_departamento) references departamento;

alter table persona_departamento add constraint FK1usqirfu7hd4fm6jm4t8u1x4s foreign key (id_persona) references persona;