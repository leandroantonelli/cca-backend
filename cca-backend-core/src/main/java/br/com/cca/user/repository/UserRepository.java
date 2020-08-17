package br.com.cca.user.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.user.domain.User;
import br.com.cca.user.mapper.UserRowMapper;
import br.com.cca.user.sql.UserSql;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Repository
public class UserRepository extends AbstractRepository {

    public User findByEmail(String dsEmail) {

        Map<String, Object> map = new HashMap<>();
        map.put("ds_email", dsEmail);

        return queryForObject(UserSql.findByEmail, map, new UserRowMapper());
    }

    public List<User> findAll() {

        return query(UserSql.findAll, Collections.emptyMap(), new UserRowMapper());
    }

    public Integer insert(User user) {

        Long id = insert(UserSql.insert, user.getMap(), "iduser");

        return id.intValue();
    }

    public void update(User user) {

        update(UserSql.update, user.getMap());
    }

    public void delete(Integer id) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_user", id);

        delete(UserSql.delete, map);
    }

    public User findById(Integer id) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_user", id);

        return queryForObject(UserSql.findUserById, map, new UserRowMapper());
    }

    public void updatePassword(User user) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_user", user.getIdUser());
        map.put("ds_password", user.getDsPassword());

        update(UserSql.updatePassword, map);
    }

    public String findPassword(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id_user", id);

        return queryForObject(UserSql.findPassword, map, new RowMapper<String>(){
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("dspassword");
            }
        });
    }

}
