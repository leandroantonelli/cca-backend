create table perfil(
	idperfil serial,
	dsname varchar(255),
	primary key (idperfil)
);

ALTER TABLE perfil ADD CONSTRAINT perfil_name UNIQUE (dsname);