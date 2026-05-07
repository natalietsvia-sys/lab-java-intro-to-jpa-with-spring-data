package week7;

import week7.model.Customer;
import week7.model.CustomerStatus;
import week7.model.Flight;
import week7.model.FlightBooking;
import week7.repository.CustomerRepository;
import week7.repository.FlightBookingRepository;
import week7.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo,
                          FlightRepository flightRepo,
                          FlightBookingRepository bookingRepo) {
        return args -> {
            Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Customer bob = customerRepo.save(new Customer("Bob", CustomerStatus.SILVER, 85000));
            Customer clara = customerRepo.save(new Customer("Clara", CustomerStatus.BRONZE, 30000));

            Flight london = flightRepo.save(new Flight("AB123", "Boeing 747", 300, 400));
            Flight paris = flightRepo.save(new Flight("CD456", "Airbus A320", 180, 220));
            Flight madrid = flightRepo.save(new Flight("EF789", "Boeing 737", 160, 190));

            bookingRepo.save(new FlightBooking(alice.getId(), london.getId()));
            bookingRepo.save(new FlightBooking(bob.getId(), paris.getId()));
            bookingRepo.save(new FlightBooking(clara.getId(), madrid.getId()));
        };
    }
}
