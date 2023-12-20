package com.amadeus.amadeuscasestudy.Repository;

import com.amadeus.amadeuscasestudy.Entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}