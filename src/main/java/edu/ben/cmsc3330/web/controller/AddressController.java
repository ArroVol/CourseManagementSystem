package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import edu.ben.cmsc3330.data.translator.AddressTranslator;
import edu.ben.cmsc3330.web.model.AddressView;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
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

    // get all users
    @GetMapping
    public List<Address> getAllUsers() {
        return this.addressRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public Optional<Address> getUserById(@PathVariable (value = "id") long userId) {
        return this.addressRepository.findById(userId);
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return this.addressRepository.save(address);
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
        // save note instance to db
        this.addressRepository.save(newAddress);

        return newAddress;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.addressRepository.deleteById(Long.valueOf(id));
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteUser(@PathVariable("id") Long userId) {
        Optional<Address> existingAddress = this.addressRepository.findById(userId);

//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        this.addressRepository.delete(existingAddress.get());
        return ResponseEntity.ok().build();
    }

    // update user
    @PutMapping("/{id}")
    public Address updateUser(@RequestBody Address address, @PathVariable ("id") long userId) {
       Optional<Address> existingAddress = this.addressRepository.findById(userId);
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingAddress.get().setCity(address.getCity());
        return this.addressRepository.save(existingAddress.get());
    }
}
