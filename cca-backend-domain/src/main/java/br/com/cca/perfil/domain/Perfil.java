package br.com.cca.perfil.domain;

import br.com.cca.menu.domain.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Getter
@Setter
public class Perfil {

    private Integer idPerfil;

    private String dsName;

    private List<Menu> menus;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("id_perfil", idPerfil);
        map.put("ds_name", dsName);
        return map;
    }
}
