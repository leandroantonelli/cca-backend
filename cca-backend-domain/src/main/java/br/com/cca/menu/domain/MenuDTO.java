package br.com.cca.menu.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 08/07/20
 */
@Getter
@Setter
public class MenuDTO extends AbstractDomain {

    private Integer idMenu;

    private String dsMenu;

    private String dsClassIcon;

    private String dsRouterLink;

    private Boolean fgChecked;

    private List<MenuDTO> menuList;

}
