package br.com.cca.commons.endpoint;

import br.com.cca.commons.domain.AbstractDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 15/08/20
 */
public abstract class AbstractEndpoint {

    protected ResponseEntity ok(List<AbstractDomain> domain) {

        return new ResponseEntity<>(domain, HttpStatus.OK);
    }

    protected ResponseEntity ok(AbstractDomain domain) {

        return new ResponseEntity<>(domain, HttpStatus.OK);
    }

    protected ResponseEntity<?> noContent() {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    protected ResponseEntity<?> error() {

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
