package br.com.cca.menu.sql

class MenuPerfilSql {

    public static String insert = """
        insert into perfil_menu
            (idmenu, idperfil)
        values
            (:id_menu, :id_perfil)
    """

    public static String deleteByPerfil = """
        delete from 
            perfil_menu
        where
            idperfil = :id_perfil
    """
}
