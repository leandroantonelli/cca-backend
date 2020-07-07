package br.com.cca.user.mapper;

import br.com.cca.user.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setIdUser(rs.getInt("iduser"));
        user.setDsName(rs.getString("dsname"));
        user.setDsEmail(rs.getString("dsemail"));
        user.setDsPassword(rs.getString("dspassword"));
        user.setDsCellPhone(rs.getString("dscellphone"));

        return user;
    }

}