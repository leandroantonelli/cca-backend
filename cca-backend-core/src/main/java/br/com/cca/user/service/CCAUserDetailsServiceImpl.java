package br.com.cca.user.service;

import br.com.cca.component.CCAUserDetailsService;
import br.com.cca.user.commons.UserCommons;
import br.com.cca.user.domain.CustomUser;
import br.com.cca.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Service
public class CCAUserDetailsServiceImpl implements CCAUserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String dsEmail) {

        User usuarioPoder = userService.findByEmail(dsEmail);

        if (Objects.nonNull(usuarioPoder)) {
            return new CustomUser(usuarioPoder, getPermissoes(usuarioPoder));
        } else {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getPermissoes(User user) {

        return UserCommons.getPermissoes(user);
    }
}
