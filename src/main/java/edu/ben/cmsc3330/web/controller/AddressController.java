package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import edu.ben.cmsc3330.data.translator.AddressTranslator;
import edu.ben.cmsc3330.web.model.AddressView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class AddressController {

    private final AddressRepository addressRepository;


    public AddressController(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // /users
    // /users/id

    // GET, POST, PUT, DELETE

    @GetMapping(value = "/api/address/{addressId}")
    public AddressView viewAddress(@PathVariable Long addressId) throws Exception {

        // Retrieve the Address object
        Optional<Address> addressOption = addressRepository.findById(addressId);

        // Verify we actually got a good address/address id
        if (addressOption.isEmpty()) {
            log.error("Address with id [{}] does not exist in DB", addressId);
            throw new Exception("Address with id [" + addressId + "] does not exist in DB");
        }

        return AddressTranslator.entityToView(addressOption.get());

    }
}
