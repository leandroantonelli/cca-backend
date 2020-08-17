package br.com.cca.clinic.domain;

import br.com.cca.address.domain.Address;
import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * User: Leandro Antonelli
 * Date: 15/08/20
 */
@Getter
@Setter
public class Clinic extends AbstractDomain {

    private Integer idClinic;

    private String dsName;

    private String dsCnpj;

    private Address address;
}
