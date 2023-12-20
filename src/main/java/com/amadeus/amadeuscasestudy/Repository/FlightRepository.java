package com.amadeus.amadeuscasestudy.Repository;

import com.amadeus.amadeuscasestudy.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}