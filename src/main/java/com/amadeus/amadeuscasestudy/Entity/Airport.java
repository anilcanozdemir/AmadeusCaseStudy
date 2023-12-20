package com.amadeus.amadeuscasestudy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String cityName;
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlightList;
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlightList;
}