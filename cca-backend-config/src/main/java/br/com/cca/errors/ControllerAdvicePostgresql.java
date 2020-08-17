package br.com.cca.errors;

import br.com.cca.error.domain.ErrorPostgresql;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * User: Leandro Antonelli
 * Date: 12/07/20
 */
@ControllerAdvice
public class ControllerAdvicePostgresql {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorPostgresql> conflict(PSQLException e) {
        ErrorPostgresql errorMessage = new ErrorPostgresql(LocalDateTime.now(), getMessage(e));
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getMessage(PSQLException e) {

        String dsMessage = "Ocorreu um erro ao tentar efetuar a operação desejada!";

        switch (e.getSQLState()) {
            case "23505":
                dsMessage = "Já existe um registro com esse nome!";
                break;
            case "23503":
                dsMessage = "Registro vinculado a outro cadastro. Não é possível remover!";
                break;
        }

        return dsMessage;

    }
}
