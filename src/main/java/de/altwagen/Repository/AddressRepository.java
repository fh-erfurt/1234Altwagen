package de.altwagen.Repository;

import java.util.List;

import de.altwagen.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByLastName(String lastName);

    Address findById(long id);
}