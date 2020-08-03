package de.altwagen.Repository;

import java.util.List;

import de.altwagen.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByLastName(String lastName);

    Address findById(long id);
}