package com.airline.booking.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false)
    private CustomerStatus customerStatus = CustomerStatus.NONE;

    @Column(name = "total_customer_mileage", nullable = false)
    private Integer totalCustomerMileage = 0;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightBooking> flightBookings = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public List<FlightBooking> getFlightBookings() {
        return flightBookings;
    }

    public void addFlightBooking(FlightBooking flightBooking) {
        flightBookings.add(flightBooking);
        flightBooking.setCustomer(this);
    }

    public void removeFlightBooking(FlightBooking flightBooking) {
        flightBookings.remove(flightBooking);
        flightBooking.setCustomer(null);
    }
}
