create table address(
	idaddress serial,
	dscep varchar(8),
	dsaddress varchar(255),
	dsnumber varchar(20),
	dscomplement varchar(255),
	dsneighborhood varchar(255),
	dsstate varchar(255),
	dscity varchar(255),
	primary key (idaddress)
);