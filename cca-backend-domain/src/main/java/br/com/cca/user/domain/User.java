package br.com.cca.user.domain;

import br.com.cca.address.domain.Address;
import br.com.cca.commons.domain.AbstractDomain;
import br.com.cca.perfil.domain.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@Getter
@Setter
public class User extends AbstractDomain {

    private Integer idUser;

    private String dsName;

    private String dsEmail;

    private String dsPassword;

    private String dsCellPhone;

    private String dsCpf;

    private Perfil perfil;

    private Address address;

    private Set<String> permissions;
}