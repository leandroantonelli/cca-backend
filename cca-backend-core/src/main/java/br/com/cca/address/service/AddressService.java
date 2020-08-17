package br.com.cca.address.service;

import br.com.cca.address.domain.Address;
import br.com.cca.address.repository.AddressRepository;
import br.com.cca.commons.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Leandro Antonelli
 * Date: 08/08/20
 */
@Service
public class AddressService extends AbstractService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {

        if (address.getIdAddress() == null) {
            Integer idAddress = insert(address);
            address.setIdAddress(idAddress);
        } else {
            update(address);
        }

        return address;
    }

    private Integer insert(Address address) {

        return addressRepository.insert(address);
    }

    public void update(Address address) {

        addressRepository.update(address);
    }

    public void delete(Integer id) {

        addressRepository.delete(id);
    }
}
