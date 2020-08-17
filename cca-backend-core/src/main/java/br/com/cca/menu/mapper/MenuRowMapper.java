package br.com.cca.menu.mapper;

import br.com.cca.commons.mapper.AbstractRowMapper;
import br.com.cca.menu.domain.MenuDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 08/07/20
 */
public class MenuRowMapper extends AbstractRowMapper implements RowMapper<MenuDTO> {

    @Override
    public MenuDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setIdMenu(rs.getInt("idmenu"));
        menuDTO.setDsMenu(rs.getString("dsmenu"));
        menuDTO.setDsClassIcon(rs.getString("dsclassicon"));
        menuDTO.setDsRouterLink(rs.getString("dsrouterlink"));

        return menuDTO;
    }

}
