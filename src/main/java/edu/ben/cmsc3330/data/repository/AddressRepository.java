package edu.ben.cmsc3330.data.repository;

import edu.ben.cmsc3330.data.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findByStreetContainingOrderByStreet(String name, final Pageable pageable);

    Optional<Address> findAllByActiveIsTrue();
}
