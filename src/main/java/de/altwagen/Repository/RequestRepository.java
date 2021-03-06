package de.altwagen.Repository;

import java.util.List;

import de.altwagen.Request.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

    List<Request> findByLastName(String lastName);

    Request findById(long id);
}