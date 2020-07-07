package br.com.cca.perfil.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.mapper.PerfilRowMapper;
import br.com.cca.perfil.sql.PerfilSql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Repository
public class PerfilRepository extends AbstractRepository {

    public List<Perfil> findAll() {

        return query(PerfilSql.findAll, new PerfilRowMapper());
    }

    public Integer insert(Perfil perfil) {

        Long id = insert(PerfilSql.insert, perfil.toMap());

        return id.intValue();
    }

    public void update(Perfil perfil) {

        update(PerfilSql.update, perfil.toMap());
    }

    public void delete(Perfil perfil) {

        delete(PerfilSql.delete, perfil.toMap());
    }
}
