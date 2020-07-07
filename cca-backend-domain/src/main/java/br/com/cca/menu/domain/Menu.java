package br.com.cca.menu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {

    private Integer idMenu;

    private String dsMenu;

    private Integer idParent;

    private String dsClassIcon;

    private String dsRouterLink;

    private Integer nrOrder;
}
