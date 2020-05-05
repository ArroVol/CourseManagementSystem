package edu.ben.cmsc3330.web.controller;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import edu.ben.cmsc3330.data.translator.AddressTranslator;
import edu.ben.cmsc3330.web.model.AddressView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // GET, POST, PUT, DELETE

    //http://localhost:8080/api/address/1
    @GetMapping(value = "/api/address/{studentId}")
    public AddressView viewAddressByStudentId(@PathVariable int studentId) throws Exception {
        log.info("inside view address method");
        // Retrieve the Address object
        Optional<Address> addressOption = addressRepository.findByStudentId(studentId);

        // Verify we actually got a good address/address id
        if (addressOption.isEmpty()) {
            log.error("Address with id [{}] does not exist in DB", studentId);
            throw new Exception("Address with id [" + studentId + "] does not exist in DB");
        }
        return AddressTranslator.entityToView(addressOption.get());
    }

    // get all users
    @GetMapping(value = "/api/address")
    public List<Address> getAllUsers() {
        log.info("inside the getAllusers method");
        return this.addressRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public Optional<Address> getUserById(@PathVariable (value = "id") long userId) {
        return this.addressRepository.findById(userId);
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }


    @PostMapping(value = "/api/address/post/{addressId}")
    public Address save(@RequestBody AddressView addressView, BindingResult bindingResult, @PathVariable int addressId) {
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


    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteUser(@PathVariable("id") Long userId) {
        Optional<Address> existingAddress = this.addressRepository.findById(userId);
        this.addressRepository.delete(existingAddress.get());
        return ResponseEntity.ok().build();
    }

    // update user
    @PutMapping("/address/put/{studentId}")
    public Address updateAddress(@RequestBody Address address, @PathVariable ("studentId") int studentId) {
        log.info("inside the put back end");
        Optional<Address> existingAddress = this.addressRepository.findByStudentId(studentId);
        existingAddress.get().setPostalCode(address.getPostalCode());
        existingAddress.get().setCity(address.getCity());
        existingAddress.get().setState(address.getState());
        existingAddress.get().setStreet(address.getStreet());
        return this.addressRepository.save(existingAddress.get());
    }

}
