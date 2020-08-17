package br.com.cca.perfil.domain;

import br.com.cca.commons.domain.AbstractDomain;
import br.com.cca.menu.domain.MenuDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Getter
@Setter
public class Perfil extends AbstractDomain {

    private Integer idPerfil;

    private String dsName;

    private List<MenuDTO> menus;
}
