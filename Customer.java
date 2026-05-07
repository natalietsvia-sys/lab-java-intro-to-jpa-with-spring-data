package com.airline.booking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status = CustomerStatus.NONE;

    @Column(name = "total_miles_flown", nullable = false)
    private Integer totalMilesFlown = 0;

    protected Customer() {
    }

    public Customer(String name, CustomerStatus status, Integer totalMilesFlown) {
        this.name = name;
        this.status = status;
        this.totalMilesFlown = totalMilesFlown;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Integer getTotalMilesFlown() {
        return totalMilesFlown;
    }

    public void setTotalMilesFlown(Integer totalMilesFlown) {
        this.totalMilesFlown = totalMilesFlown;
    }
}
