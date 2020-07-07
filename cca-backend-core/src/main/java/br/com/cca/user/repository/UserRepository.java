package br.com.cca.user.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.user.domain.User;
import br.com.cca.user.mapper.UserRowMapper;
import br.com.cca.user.sql.UserSql;
import org.springframework.stereotype.Repository;

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

}
