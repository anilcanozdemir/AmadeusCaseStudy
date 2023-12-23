package com.amadeus.amadeuscasestudy.Repository;

import com.amadeus.amadeuscasestudy.Entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}