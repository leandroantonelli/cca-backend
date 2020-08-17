package br.com.cca.user.mapper;

import br.com.cca.address.domain.Address;
import br.com.cca.commons.mapper.AbstractRowMapper;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.user.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
public class UserRowMapper extends AbstractRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setIdUser(rs.getInt("iduser"));
        user.setDsName(rs.getString("dsname"));
        user.setDsEmail(rs.getString("dsemail"));
        user.setDsCellPhone(rs.getString("dscellphone"));
        user.setDsCpf(rs.getString("dscpfcpnj"));
        user.setFgActive(rs.getBoolean("fgactive"));

        if (hasColumn(rs, "dspassword")) {
            user.setDsPassword(rs.getString("dspassword"));
        }

        user.setPerfil(getPerfil(rs));
        user.setAddress(getAddress(rs));

        return user;
    }

    public Perfil getPerfil(ResultSet rs) throws SQLException {

        Perfil perfil = null;

        if (hasColumn(rs, "idperfil")) {
            perfil = new Perfil();
            perfil.setIdPerfil(rs.getInt("idperfil"));
            perfil.setDsName(rs.getString("dsperfil"));
        }

        return perfil;
    }

    public Address getAddress(ResultSet rs) throws SQLException {

        Address address = null;

        if (hasColumn(rs, "idaddress")) {
            address = new Address();
            address.setIdAddress(rs.getInt("idaddress"));
            address.setDsCep(rs.getString("dscep"));
            address.setDsAddress(rs.getString("dsaddress"));
            address.setDsNumber(rs.getString("dsnumber"));
            address.setDsComplement(rs.getString("dscomplement"));
            address.setDsNeighborhood(rs.getString("dsneighborhood"));
            address.setDsState(rs.getString("dsstate"));
            address.setDsCity(rs.getString("dscity"));
        }

        return address;
    }

}