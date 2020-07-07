package br.com.cca.user.commons;

import br.com.cca.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
public class UserCommons {

    private static final String ROLE_USER = "ROLE_USER";

    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static void addPermissoes(User user) {

        Set<String> permissoesList = new HashSet<>();
        permissoesList.add(ROLE_ADMIN);

        user.setPermissions(permissoesList);
    }

    public static Collection<? extends GrantedAuthority> getPermissoes(User user) {

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        if (Objects.nonNull(user) && Objects.nonNull(user.getPermissions())) {
            user.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.toUpperCase())));
        }

        return authorities;

    }
}
