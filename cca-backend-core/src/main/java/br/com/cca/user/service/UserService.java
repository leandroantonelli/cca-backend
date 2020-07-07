package br.com.cca.user.service;

import br.com.cca.commons.service.AbstractService;
import br.com.cca.menu.domain.Menu;
import br.com.cca.user.domain.User;
import br.com.cca.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String dsEmail) {

        return userRepository.findByEmail(dsEmail);

    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<Menu> findUserMenu(Integer idUser) {

        return null;
    }
}
