package br.com.cca.menu.sql

class MenuSql {

    public static String findByIdParentNull = """
        select
            idmenu,
            dsmenu,
            dsclassicon,
            dsrouterlink
        from
            menu 
        where
            idparent is null
        order by 
            nrorder asc
    """

    public static String findByIdParent = """
        select
            idmenu,
            dsmenu,
            dsclassicon,
            dsrouterlink
        from
            menu 
        where
            idparent = :id_parent
        order by 
            nrorder asc
    """

    public static String findByIdPerfilAndIdParentNull = """
        select
            m.idmenu,
            m.dsmenu,
            m.dsclassicon,
            m.dsrouterlink
        from
            menu m
            inner join perfil_menu pm on (pm.idmenu = m.idmenu)
        where
            m.idparent is null and
            pm.idperfil = :id_perfil
        order by
        m.nrorder asc
    """

    public static String findByIdPerfilAndIdParent = """
        select
            m.idmenu,
            m.dsmenu,
            m.dsclassicon,
            m.dsrouterlink
        from
            menu m
            inner join perfil_menu pm on (pm.idmenu = m.idmenu)
        where
            m.idparent = :id_parent and
            pm.idperfil = :id_perfil
        order by 
            m.nrorder asc
    """
}
