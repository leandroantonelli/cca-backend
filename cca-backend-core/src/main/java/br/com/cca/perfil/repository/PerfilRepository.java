package br.com.cca.perfil.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.mapper.PerfilRowMapper;
import br.com.cca.perfil.sql.PerfilSql;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Repository
public class PerfilRepository extends AbstractRepository {

    public List<Perfil> findAll() {

        return query(PerfilSql.findAll, new PerfilRowMapper());
    }

    public Perfil findByPerfil(Integer idPerfil) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_perfil", idPerfil);

        return queryForObject(PerfilSql.findByPerfil, map, new PerfilRowMapper());

    }

    public Integer insert(Perfil perfil) {

        Map<String, Object> map = new HashMap<>();
        map.put("ds_name", perfil.getDsName());

        Long id = insert(PerfilSql.insert, map, "idperfil");

        return id.intValue();
    }

    public void update(Perfil perfil) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_perfil", perfil.getIdPerfil());
        map.put("ds_name", perfil.getDsName());

        update(PerfilSql.update, map);
    }

    public void delete(Integer id) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_perfil", id);

        delete(PerfilSql.delete, map);
    }
}
