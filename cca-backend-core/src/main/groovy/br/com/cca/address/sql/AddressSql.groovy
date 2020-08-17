package br.com.cca.address.sql

class AddressSql {

    public static String insert = """
        insert into address
            (dscep, dsaddress, dsnumber, dscomplement, dsneighborhood, dsstate, dscity)
        values
            (:ds_cep, :ds_address, :ds_number, :ds_complement, :ds_neighborhood, :ds_state, :ds_city)
    """

    public static String update = """
        update
            address
        set
            dscep = :ds_cep,
            dsaddress = :ds_address,
            dsnumber = :ds_number,
            dscomplement = :ds_complement,
            dsneighborhood = :ds_neighborhood,
            dsstate = :ds_state,
            dscity = :ds_city
        where
            idaddress = :id_address
    """

    public static String delete = """
        delete from
            address
        where
            idaddress = :id_address
    """
}
