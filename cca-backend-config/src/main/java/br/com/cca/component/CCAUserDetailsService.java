package br.com.cca.component;

import br.com.cca.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public interface CCAUserDetailsService extends UserDetailsService {

    UserDetails loadUserByUsername(String dsEmail) throws UsernameNotFoundException;

    Collection<? extends GrantedAuthority> getPermissoes(User user);
}
