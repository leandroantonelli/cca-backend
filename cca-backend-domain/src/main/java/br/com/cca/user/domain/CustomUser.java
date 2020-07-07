package br.com.cca.user.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
public class CustomUser extends org.springframework.security.core.userdetails.User {

    @Getter
    private User user;

    public CustomUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getDsEmail(), user.getDsPassword(), authorities);
        this.user = user;
    }
}
