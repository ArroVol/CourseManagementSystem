package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import edu.ben.cmsc3330.data.translator.AddressTranslator;
import edu.ben.cmsc3330.web.model.AddressView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Optional;
import java.util.UUID;
@RequestMapping("/model/address")
@CrossOrigin
@Slf4j
@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    private Mapper mapper;


    public AddressController(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
//        this.mapper = mapper;
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

    @PostMapping
    public Address save(@RequestBody AddressView addressView, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        Address newAddress = new Address();
        newAddress.setStreet(addressView.getStreet());
        newAddress.setCity(addressView.getCity());
        newAddress.setState(addressView.getState());
        newAddress.setPostalCode(addressView.getPostalCode());

//        Address newAddress = this.mapper.convertToNoteEntity(createAddressView);

        // save note instance to db
        this.addressRepository.save(newAddress);

        return newAddress;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.addressRepository.deleteById(Long.valueOf(id));
    }
}
