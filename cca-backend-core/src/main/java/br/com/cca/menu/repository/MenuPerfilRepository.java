package br.com.cca.menu.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.menu.sql.MenuPerfilSql;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 12/07/20
 */
@Repository
public class MenuPerfilRepository extends AbstractRepository {

    public void insert(Integer idMenu, Integer idPerfil) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_menu", idMenu);
        map.put("id_perfil", idPerfil);

        insertWihtoutGeneratedKey(MenuPerfilSql.insert, map);
    }

    public void deleteByPerfil(Integer idPerfil) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_perfil", idPerfil);

        delete(MenuPerfilSql.deleteByPerfil, map);

    }
}
