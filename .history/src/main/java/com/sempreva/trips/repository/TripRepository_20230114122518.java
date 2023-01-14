package com.sempreva.trips.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sempreva.trips.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
    
}
