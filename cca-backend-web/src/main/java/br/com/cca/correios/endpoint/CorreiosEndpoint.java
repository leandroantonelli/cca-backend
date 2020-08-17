package br.com.cca.correios.endpoint;

import br.com.cca.correios.domain.CorreioResponseReturn;
import br.com.cca.correios.service.CorreiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Leandro Antonelli
 * Date: 04/08/20
 */
@RestController
@RequestMapping("/correios")
public class CorreiosEndpoint {

    @Autowired
    private CorreiosService correiosService;

    @GetMapping(value = "/{dsCep}")
    public CorreioResponseReturn findByPerfil(@PathVariable String dsCep) {
        return correiosService.getCep(dsCep);
    }
}
