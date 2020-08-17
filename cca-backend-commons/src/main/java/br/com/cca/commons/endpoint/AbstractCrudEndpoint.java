package br.com.cca.commons.endpoint;

import br.com.cca.commons.domain.AbstractDomain;
import br.com.cca.commons.service.AbstractCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * User: Leandro Antonelli
 * Date: 15/08/20
 */
@RestController
public abstract class AbstractCrudEndpoint<Domain extends AbstractDomain, Service extends AbstractCrudService> extends AbstractEndpoint {

    @GetMapping(value = "/all")
    public ResponseEntity<List<Domain>> findAll() {
        return ok(getService().findAll());
    }

    @PostMapping
    public ResponseEntity<Domain> save(@RequestBody Domain domain) {
        return ok(getService().save(domain));
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Domain> findById(@PathVariable Integer id) {

        return ok(getService().findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        getService().delete(id);
    }

    protected abstract Service getService();
}
