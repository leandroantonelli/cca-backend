package br.com.cca.perfil.service;

import br.com.cca.commons.service.AbstractCrudService;
import br.com.cca.menu.domain.MenuDTO;
import br.com.cca.menu.service.MenuService;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Service
public class PerfilService extends AbstractCrudService<Perfil> {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private MenuService menuService;

    @Override
    public List<Perfil> findAll() {

        return perfilRepository.findAll();
    }

    @Override
    public Perfil findById(Integer idPerfil) {

        Perfil perfil = perfilRepository.findByPerfil(idPerfil);
        perfil.setMenus(menuService.getMenusWithChecked(idPerfil));

        return perfil;
    }

    @Override
    @Transactional
    public Perfil save(Perfil perfil) {

        if (perfil.getIdPerfil() == null) {
            Integer idPerfil = insert(perfil);
            perfil.setIdPerfil(idPerfil);
        } else {
            update(perfil);
        }

        menuService.saveMenuPerfil(perfil);

        return perfil;
    }

    public List<MenuDTO> findMenusByPerfil(Integer idPerfil) {

        return menuService.findMenusByPerfil(idPerfil);
    }

    public List<MenuDTO> findAllMenu() {

        return menuService.findAll();
    }

    private Integer insert(Perfil perfil) {

        return perfilRepository.insert(perfil);
    }

    private void update(Perfil perfil) {

        perfilRepository.update(perfil);
    }

    @Override
    @Transactional
    public void delete(Integer idPerfil) {

        perfilRepository.delete(idPerfil);

        menuService.deleteByPerfil(idPerfil);
    }
}
