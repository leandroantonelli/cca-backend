package br.com.cca.user.service;

import br.com.cca.component.CCAUserDetailsService;
import br.com.cca.config.CCAAuthenticationProvider;
import br.com.cca.security.service.SecurityService;
import br.com.cca.user.commons.UserCommons;
import br.com.cca.user.domain.CustomUser;
import br.com.cca.user.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Log4j2
@Service
public class CCAAuthenticationProviderImpl extends AbstractUserDetailsAuthenticationProvider implements CCAAuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CCAUserDetailsService CCAUserDetailsService;

    @Override
    public void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    public CustomUser retrieveUser(String s, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        try {

            User user = userService.findByEmail(token.getName());

            if (user != null) {

                String dsPassEncrypt = securityService.encrypt(token.getCredentials().toString(), token.getName());

                if (dsPassEncrypt.equals(user.getDsPassword())) {
                    UserCommons.addPermissoes(user);
                    return new CustomUser(user, CCAUserDetailsService.getPermissoes(user));
                } else {
                    throw new UsernameNotFoundException("Usuário ou senha inválidos");
                }

            } else {
                throw new UsernameNotFoundException("Usuário ou senha inválidos");
            }

        } catch (InvalidDataAccessResourceUsageException e) {
            log.warn("Usuário ou senha inválida");
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }
    }

}
