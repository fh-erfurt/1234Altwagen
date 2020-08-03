package de.altwagen.Repository;

import java.util.List;

import de.altwagen.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByLastName(String lastName);

    Location findById(long id);
}