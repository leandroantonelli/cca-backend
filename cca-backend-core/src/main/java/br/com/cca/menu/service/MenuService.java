package br.com.cca.menu.service;

import br.com.cca.commons.service.AbstractService;
import br.com.cca.menu.domain.MenuDTO;
import br.com.cca.menu.repository.MenuRepository;
import br.com.cca.perfil.domain.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * User: Leandro Antonelli
 * Date: 08/07/20
 */
@Service
public class MenuService extends AbstractService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuPerfilService menuPerfilService;

    public List<MenuDTO> findAll() {

        List<MenuDTO> menuDTOList = menuRepository.findByIdParentNull();

        for (MenuDTO menuDTO : menuDTOList) {

            List<MenuDTO> menuDTOChilds = menuRepository.findByIdParent(menuDTO.getIdMenu());

            menuDTO.setMenuList(menuDTOChilds);

        }

        return menuDTOList;
    }

    public List<MenuDTO> findMenusByPerfil(Integer idPerfil) {

        List<MenuDTO> menuDTOList = menuRepository.findByIdPerfilAndIdParentNull(idPerfil);

        for (MenuDTO menuDTO : menuDTOList) {

            List<MenuDTO> menuDTOChilds = menuRepository.findByIdPerfilAndIdParent(menuDTO.getIdMenu(), idPerfil);

            menuDTOChilds.forEach(menuDTOChild -> menuDTOChild.setFgChecked(true));
            menuDTO.setFgChecked(true);
            menuDTO.setMenuList(menuDTOChilds);

        }

        return menuDTOList;
    }

    public void saveMenuPerfil(Perfil perfil) {

        menuPerfilService.save(perfil);
    }

    public void deleteByPerfil(Integer idPerfil) {

        menuPerfilService.deleteByPerfil(idPerfil);
    }

    public List<MenuDTO> getMenusWithChecked(Integer idPerfil) {

        List<MenuDTO> menuDTOList = findAll();
        List<MenuDTO> menuDTOPerfilList = findMenusByPerfil(idPerfil);

        menuDTOList.forEach(menu -> {

            Optional<MenuDTO> objFilter = menuDTOPerfilList.stream().filter(obj -> obj.getIdMenu().equals(menu.getIdMenu())).findFirst();

            if (objFilter.isPresent()) {
                MenuDTO menuDTO = objFilter.get();
                menu.setFgChecked(menuDTO.getFgChecked());
                menu.getMenuList().forEach(menuChild -> {

                    Optional<MenuDTO> childFilter = menuDTO.getMenuList().stream().filter(obj -> obj.getIdMenu().equals(menuChild.getIdMenu())).findFirst();

                    if (childFilter.isPresent()) {
                        MenuDTO menuChildDTO = childFilter.get();
                        menuChild.setFgChecked(menuChildDTO.getFgChecked());
                    }
                });
            }
        });

        return menuDTOList;
    }
}
