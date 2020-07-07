package br.com.cca.user.sql

class UserSql {

    public static String findByEmail = """
        select
            iduser,
            dsname, 
            dsemail, 
            dspassword, 
            dscellphone 
        from
            users 
        where
            dsemail = :ds_email
    """

    public static String findAll = """
        select
            iduser,
            dsname, 
            dsemail, 
            dspassword, 
            dscellphone 
        from
            users
    """
}
