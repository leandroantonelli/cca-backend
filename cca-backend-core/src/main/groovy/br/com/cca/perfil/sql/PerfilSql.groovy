package br.com.cca.perfil.sql

class PerfilSql {

    public static String findAll = """
        select
            idperfil,
            dsname
        from
            perfil 
    """

    public static String insert = """
        insert into perfil
            (dsname)
        values
            (:ds_name)
    """

    public static String update = """
        update from
            perfil
        set
            dsname = :ds_name
        where
            idperfil = :id_perfil
    """

    public static String delete = """
        delete from
            perfil
        where
            idperfil = :id_perfil
    """
}

/*
create table perfil(
	idperfil serial,
	dsname varchar(255),
	primary key (idperfil)
);

ALTER TABLE perfil ADD CONSTRAINT perfil_name UNIQUE (dsname);


create table menu(
	idmenu serial,
	dsmenu varchar(100),
	idparent integer,
	dsclassicon varchar(500),
	dsrouterlink varchar(100),
	nrorder integer,
	primary key (idmenu)
)
 */
