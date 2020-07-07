package br.com.cca.address.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

/**
 * User: Leandro Antonelli
 * Date: 04/07/20
 */
@Getter
@Setter
public class Address extends AbstractDomain {

    private Integer idAddress;

    private String dsCep;

    private String dsAddress;

    private String dsNumber;

    private String dsComplement;

    private String dsNeighborhood;

    private String dsState;

    private String dsCity;
}
