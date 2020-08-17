package br.com.cca.menu.service;

import br.com.cca.menu.domain.MenuDTO;
import br.com.cca.menu.repository.MenuPerfilRepository;
import br.com.cca.perfil.domain.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 12/07/20
 */
@Service
public class MenuPerfilService {

    @Autowired
    private MenuPerfilRepository menuPerfilRepository;

    public void save(Perfil perfil) {

        menuPerfilRepository.deleteByPerfil(perfil.getIdPerfil());
        saveMenus(perfil.getMenus(), perfil.getIdPerfil());
    }

    private void saveMenus(List<MenuDTO> menuDTOList, Integer idPerfil) {

        for (MenuDTO menuDTO : menuDTOList) {
            if (menuDTO.getFgChecked() != null && menuDTO.getFgChecked()) {
                insert(menuDTO.getIdMenu(), idPerfil);

                if (menuDTO.getMenuList() != null) {
                    saveMenus(menuDTO.getMenuList(), idPerfil);
                }
            }
        }
    }

    private void insert(Integer idMenu, Integer idPerfil) {

        menuPerfilRepository.insert(idMenu, idPerfil);
    }

    public void deleteByPerfil(Integer idPerfil) {

        menuPerfilRepository.deleteByPerfil(idPerfil);
    }
}
