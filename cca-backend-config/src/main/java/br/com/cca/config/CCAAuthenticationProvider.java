package br.com.cca.config;

import br.com.cca.user.domain.CustomUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public interface CCAAuthenticationProvider extends AuthenticationProvider {

    void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException;

    CustomUser retrieveUser(String s, UsernamePasswordAuthenticationToken token) throws AuthenticationException;

    @Override
    Authentication authenticate(Authentication authentication) throws AuthenticationException;

    @Override
    boolean supports(Class<?> authentication);
}
