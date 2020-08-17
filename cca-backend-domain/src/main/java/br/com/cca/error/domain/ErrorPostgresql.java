package br.com.cca.error.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * User: Leandro Antonelli
 * Date: 12/07/20
 */
@Getter
@Setter
public class ErrorPostgresql extends AbstractDomain {

    private LocalDateTime timestamp;
    private String message;

    public ErrorPostgresql(LocalDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
