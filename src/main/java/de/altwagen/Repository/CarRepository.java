package de.altwagen.Repository;

import java.util.List;

import de.altwagen.Car.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByLastName(String lastName);

    Car findById(long id);
}