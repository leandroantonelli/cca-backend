package br.com.cca.user.service;

import br.com.cca.address.domain.Address;
import br.com.cca.address.service.AddressService;
import br.com.cca.commons.service.AbstractCrudService;
import br.com.cca.perfil.domain.Perfil;
import br.com.cca.perfil.service.PerfilService;
import br.com.cca.security.service.SecurityService;
import br.com.cca.user.domain.User;
import br.com.cca.user.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Service
public class UserService extends AbstractCrudService<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private SecurityService securityService;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {

        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {

        Address address = addressService.save(user.getAddress());
        user.setAddress(address);

        if (user.getIdUser() == null) {
            Integer idUser = insert(user);
            user.setIdUser(idUser);
            setPassword(user);
            updatePassword(user);
        } else {
            setPassword(user);
            update(user);
        }

        return user;
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        User user = findById(id);

        userRepository.delete(user.getIdUser());
        addressService.delete(user.getAddress().getIdAddress());
    }

    public User findByEmail(String dsEmail) {

        User user = userRepository.findByEmail(dsEmail);
        Perfil perfil = perfilService.findById(user.getPerfil().getIdPerfil());
        user.setPerfil(perfil);

        return user;
    }

    private User setPassword(User user) {

        if (user.getIdUser() == null || StringUtils.isNotEmpty(user.getDsPassword())) {
            String dsPassword = securityService.encrypt(user.getDsPassword(), user.getIdUser().toString());
            user.setDsPassword(dsPassword);
        } else {
            String dsPassword = userRepository.findPassword(user.getIdUser());
            user.setDsPassword(dsPassword);
        }

        return user;
    }

    private Integer insert(User user) {

        return userRepository.insert(user);
    }

    private void update(User user) {

        userRepository.update(user);
    }

    private void updatePassword(User user) {

        userRepository.updatePassword(user);
    }
}
