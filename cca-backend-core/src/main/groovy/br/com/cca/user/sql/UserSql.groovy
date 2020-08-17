package br.com.cca.user.sql

class UserSql {

    public static String findByEmail = """
        select
            u.iduser,
            u.dsname,
            u.dsemail,
            u.dspassword,
            u.dscellphone,
            u.dscpfcpnj,
            u.fgactive,
            u.idperfil,
            p.dsname as dsperfil
        from
            users u 
            inner join perfil p on (p.idperfil = u.idperfil)
        where
            dsemail = :ds_email
    """

    /*
        Não lista o usuário ADMIN
     */
    public static String findAll = """
        select
            u.iduser,
            u.dsname,
            u.dsemail,
            u.dscellphone,
            u.dscpfcpnj,
            u.fgactive,
            u.idperfil,
            p.dsname as dsperfil,
            u.idaddress,
            a.dscep,
            a.dsaddress,
            a.dsnumber,
            a.dscomplement,
            a.dsneighborhood,
            a.dsstate,
            a.dscity
        from
            users u 
            inner join perfil p on (p.idperfil = u.idperfil)
            inner join address a on (a.idaddress = u.idaddress)
        where
            u.iduser > 1
    """

    public static String insert = """
        insert into users
            (dsname, dsemail, dspassword, dscellphone, dscpfcpnj, fgactive, idperfil, idaddress)
        values
            (:ds_name, :ds_email, :ds_password, :ds_cellphone, :ds_cpfcpnj, :fg_active, :id_perfil, :id_address)
    """

    public static String update = """
        update
            users
        set
            dsname = :ds_name,
            dsemail = :ds_email,
            dspassword = :ds_password,
            dscellphone = :ds_cellphone,
            dscpfcpnj = :ds_cpfcpnj,
            fgactive = :fg_active,
            idperfil = :id_perfil,
            idaddress = :id_address
        where
            iduser = :id_user
    """

    public static String delete = """
        delete from
            users
        where
            iduser = :id_user
    """

    public static String findUserById = """
        select
            u.iduser,
            u.dsname,
            u.dsemail,
            u.dscellphone,
            u.dscpfcpnj,
            u.fgactive,
            u.idperfil,
            p.dsname as dsperfil,
            u.idaddress,
            a.dscep,
            a.dsaddress,
            a.dsnumber,
            a.dscomplement,
            a.dsneighborhood,
            a.dsstate,
            a.dscity
        from
            users u 
            inner join perfil p on (p.idperfil = u.idperfil)
            inner join address a on (a.idaddress = u.idaddress)
        where
            u.iduser = :id_user
    """

    public static String findPassword = """
        select
            dspassword
        from
            users
        where
            iduser = :id_user
    """

    public static String updatePassword = """
        update
            users
        set
            dspassword = :ds_password
        where
            iduser = :id_user
    """
}
