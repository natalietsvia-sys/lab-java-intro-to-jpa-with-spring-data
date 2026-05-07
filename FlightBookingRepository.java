package week7.repository;

import week7.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

    List<FlightBooking> findByCustomerId(Long customerId);

    List<FlightBooking> findByFlightId(Long flightId);
}
