package br.com.cca.address.domain;

import br.com.cca.commons.domain.AbstractDomain;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Object> getMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("ds_cep", this.dsCep);
        map.put("ds_address", this.dsAddress);
        map.put("ds_number", this.dsNumber);
        map.put("ds_complement", this.dsComplement);
        map.put("ds_neighborhood", this.dsNeighborhood);
        map.put("ds_state", this.dsState);
        map.put("ds_city", this.dsCity);

        if (this.idAddress != null) {
            map.put("id_address", this.idAddress);
        }

        return map;
    }
}
