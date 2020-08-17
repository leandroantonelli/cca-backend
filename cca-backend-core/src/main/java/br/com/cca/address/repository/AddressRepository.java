package br.com.cca.address.repository;

import br.com.cca.address.domain.Address;
import br.com.cca.address.sql.AddressSql;
import br.com.cca.commons.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 09/08/20
 */
@Repository
public class AddressRepository extends AbstractRepository {

    public Integer insert(Address address) {

        Long id = insert(AddressSql.insert, address.getMap(), "idaddress");

        return id.intValue();
    }

    public void update(Address address) {

        update(AddressSql.update, address.getMap());
    }

    public void delete(Integer id) {

        Map<String, Object> map = new HashMap<>();
        map.put("id_address", id);

        delete(AddressSql.delete, map);
    }
}
