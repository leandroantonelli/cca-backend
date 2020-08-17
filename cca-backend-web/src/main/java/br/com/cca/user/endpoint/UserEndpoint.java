package br.com.cca.user.endpoint;

import br.com.cca.commons.endpoint.AbstractCrudEndpoint;
import br.com.cca.user.domain.User;
import br.com.cca.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Leandro Antonelli
 * Date: 20/06/20
 */
@RestController
@RequestMapping("/user")
public class UserEndpoint extends AbstractCrudEndpoint<User, UserService> {

    @Autowired
    private UserService userService;

    @Override
    protected UserService getService() {
        return userService;
    }

}
