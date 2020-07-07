create table users(
	iduser serial,
	dsname varchar(255),
	dsemail varchar(255),
	dspassword varchar,
	dscellphone varchar(20),
	dscpfcpnj varchar(20),
	idperfil integer references perfil(idperfil),
	idaddress integer references address(idaddress),
	primary key (iduser)
);

ALTER TABLE users ADD CONSTRAINT user_email UNIQUE (dsemail);
