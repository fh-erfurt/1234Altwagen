package de.altwagen.Repository;

import java.util.List;

import de.altwagen.user.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByLastName(String lastName);

    Employee findById(long id);
}