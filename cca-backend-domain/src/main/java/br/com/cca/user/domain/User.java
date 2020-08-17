package br.com.cca.user.domain;

import br.com.cca.address.domain.Address;
import br.com.cca.commons.domain.AbstractDomain;
import br.com.cca.perfil.domain.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
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

    private Boolean fgActive;

    private Perfil perfil;

    private Address address;

    private Set<String> permissions;

    public Map<String, Object> getMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("ds_name", this.dsName);
        map.put("ds_email", this.dsEmail);
        map.put("ds_password", this.dsPassword);
        map.put("ds_cellphone", this.dsCellPhone);
        map.put("ds_cpfcpnj", this.dsCpf);
        map.put("fg_active", this.fgActive);
        map.put("id_perfil", perfil.getIdPerfil());

        if (address != null) {
            map.put("id_address", address.getIdAddress());
        } else {
            map.put("id_address", null);
        }

        if (this.idUser != null) {
            map.put("id_user", this.idUser);
        }

        return map;
    }
}