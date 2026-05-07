package week7.repository;

import week7.model.Customer;
import week7.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByStatus(CustomerStatus status);

    List<Customer> findByTotalCustomerMileageGreaterThan(int mileage);
}
