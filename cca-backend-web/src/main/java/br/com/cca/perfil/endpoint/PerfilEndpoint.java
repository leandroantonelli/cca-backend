package br.com.cca.perfil.endpoint;

import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@RestController
@RequestMapping("/perfil")
public class PerfilEndpoint {

    @Autowired
    private PerfilService perfilService;

    @GetMapping()
    public ResponseEntity<List<Perfil>> findAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }
}
