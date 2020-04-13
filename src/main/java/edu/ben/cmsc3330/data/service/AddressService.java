package edu.ben.cmsc3330.data.service;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Page<Address> searchAddresses(String query, Integer page, Integer limit) {
//        boolean hasQuery = StringUtils.isNotEmpty(query);
        if (query != null && query.length() > 0) {
            return addressRepository.findByStreetContainingOrderByStreet(query, PageRequest.of(page, limit));
        }
        return null;
    }
}
