package br.com.cca.user.endpoint;

import br.com.cca.menu.domain.Menu;
import br.com.cca.user.domain.User;
import br.com.cca.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user")
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/menu/{idUser}")
    public ResponseEntity<List<Menu>> findUserMenu(@PathVariable Integer idUser) {

        return null;
    }
}
