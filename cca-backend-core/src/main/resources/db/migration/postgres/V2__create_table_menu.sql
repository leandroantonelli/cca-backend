create table menu(
	idmenu serial,
	dsmenu varchar(100),
	idparent integer,
	dsclassicon varchar(500),
	dsrouterlink varchar(100),
	nrorder integer,
	primary key (idmenu)
)
