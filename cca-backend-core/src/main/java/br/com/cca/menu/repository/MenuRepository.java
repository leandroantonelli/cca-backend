package br.com.cca.menu.repository;

import br.com.cca.commons.repository.AbstractRepository;
import br.com.cca.menu.domain.MenuDTO;
import br.com.cca.menu.mapper.MenuRowMapper;
import br.com.cca.menu.sql.MenuSql;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 08/07/20
 */
@Repository
public class MenuRepository extends AbstractRepository {

    public List<MenuDTO> findByIdParentNull() {

        return query(MenuSql.findByIdParentNull, new MenuRowMapper());

    }

    public List<MenuDTO> findByIdParent(Integer idParent) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id_parent", idParent);

        return query(MenuSql.findByIdParent, objectMap, new MenuRowMapper());

    }

    public List<MenuDTO> findByIdPerfilAndIdParentNull(Integer idPerfil) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id_perfil", idPerfil);

        return query(MenuSql.findByIdPerfilAndIdParentNull, objectMap, new MenuRowMapper());

    }

    public List<MenuDTO> findByIdPerfilAndIdParent(Integer idParent, Integer idPerfil) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id_parent", idParent);
        objectMap.put("id_perfil", idPerfil);

        return query(MenuSql.findByIdPerfilAndIdParent, objectMap, new MenuRowMapper());

    }

}
