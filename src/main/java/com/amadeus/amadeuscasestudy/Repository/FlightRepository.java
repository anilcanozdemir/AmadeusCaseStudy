package com.amadeus.amadeuscasestudy.Repository;

import com.amadeus.amadeuscasestudy.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByArrivalAirport_IdAndDepartureAirport_IdAndDepartureDateBetween(Long id, Long id1, Date departureDateStart, Date departureDateEnd);

}