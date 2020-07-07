package br.com.cca.perfil.mapper;

import br.com.cca.perfil.domain.Perfil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
public class PerfilRowMapper implements RowMapper<Perfil> {

    @Override
    public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {

        Perfil perfil = new Perfil();
        perfil.setIdPerfil(rs.getInt("idperfil"));
        perfil.setDsName(rs.getString("dsname"));

        return perfil;
    }

}
