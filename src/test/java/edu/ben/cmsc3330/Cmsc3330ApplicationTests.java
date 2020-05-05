package edu.ben.cmsc3330;



import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.data.repository.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class Cmsc3330ApplicationTests {

	@RegisterExtension
	static TestContainersJupiterExtension containers = new TestContainersJupiterExtension();

	@Autowired
	private AddressRepository addressRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void testInsert(){
//	Address address = Address.builder()
		Address address = Address.builder()
//				.id(1L)
				.city("lisle")
				.state("IL")
				.postalCode("60532")
				.build();

		address = addressRepository.save(address);

//		Optional<Address> optionalAddress = addressRepository.findById(address.getId());

//		Address addressFromDB = optionalAddress.get();

//		assertThat(address).isEqualTo(addressFromDB);
	}


}
