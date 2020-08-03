package de.altwagen.AccessingData;

import de.altwagen.Car.Car;
import de.altwagen.Car.CarStatus;
import de.altwagen.Controller.GreetingApplication;
import de.altwagen.Repository.*;
import de.altwagen.Request.Request;
import de.altwagen.Request.RequestType;
import de.altwagen.domain.Address;
import de.altwagen.domain.Location;
import de.altwagen.user.Customer;
import de.altwagen.user.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("de.altwagen.Repository")
@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
        //SpringApplication.run(GreetingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            repository.save(new Customer("Jack", "Bauer","Jack.Bauer@gmx.de","123456", address));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demo(AddressRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Address("Germany","Erfurt","99099","Alronaer Straße","10"));

        };
    }

    @Bean
    public CommandLineRunner demo(CarRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            Location location = new Location(address,"FirstLocation",10);
            repository.save(new Car("NoPlan","1999",0,"Porsche","Corola","Nothing to add",location, CarStatus.FOR_SALE));

        };
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            repository.save(new Employee("Jack", "Bauer", "jack.bauer@gmx.de", "123456",address));

        };
    }

    @Bean
    public CommandLineRunner demo(LocationRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            repository.save(new Location(address,"FirstLocation",10));

        };
    }

    @Bean
    public CommandLineRunner demo(RequestRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            Location location = new Location(address,"FirstLocation",10);
            Car car = new Car("NoPlan","1999",0,"Porsche","Corola","Nothing to add",location, CarStatus.FOR_SALE);
            Customer customer = new Customer("Jack", "Bauer","Jack.Bauer@gmx.de","123456", address);
            repository.save(new Request(RequestType.SELL,car,customer,200));

        };
    }

    /*
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few customers
            Address address = new Address("Germany","Erfurt","99099","Alronaer Straße","10");
            repository.save(new User("Jack","Bauer","Jack.Bauer@gmx.de","123456",address));

        };
    }

    User is Abstract
    */

}