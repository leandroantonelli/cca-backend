package br.com.cca.perfil.sql

class PerfilSql {

    public static String findAll = """
        select
            idperfil,
            dsname
        from
            perfil 
    """

    public static String findByPerfil = """
        select
            idperfil,
            dsname
        from
            perfil 
        where
            idperfil = :id_perfil
    """

    public static String insert = """
        insert into perfil
            (dsname)
        values
            (:ds_name)
    """

    public static String update = """
        update
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