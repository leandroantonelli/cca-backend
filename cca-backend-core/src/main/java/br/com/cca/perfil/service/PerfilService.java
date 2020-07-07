package br.com.cca.perfil.service;

import br.com.cca.commons.service.AbstractService;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@Service
public class PerfilService extends AbstractService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> findAll() {

        return perfilRepository.findAll();
    }

    public Integer insert(Perfil perfil) {

        return perfilRepository.insert(perfil);
    }

    public void update(Perfil perfil) {

        perfilRepository.update(perfil);
    }

    public void delete(Perfil perfil) {

        perfilRepository.delete(perfil);
    }
}
