package br.com.cca.perfil.endpoint;

import br.com.cca.commons.endpoint.AbstractCrudEndpoint;
import br.com.cca.menu.domain.MenuDTO;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@RestController
@RequestMapping("/perfil")
public class PerfilEndpoint extends AbstractCrudEndpoint<Perfil, PerfilService> {

    @Autowired
    private PerfilService perfilService;

    @GetMapping(value = "/menu/{idPerfil}")
    public List<MenuDTO> findMenusByPerfil(@PathVariable Integer idPerfil) {
        return perfilService.findMenusByPerfil(idPerfil);
    }

    @GetMapping(value = "/menu/all")
    private List<MenuDTO> findAllMenu() {
        return perfilService.findAllMenu();
    }


    @Override
    protected PerfilService getService() {
        return perfilService;
    }
}
