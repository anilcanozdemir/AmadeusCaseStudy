package com.amadeus.amadeuscasestudy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "flight")
public class Flight {
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    Airport arrivalAirport;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    Airport departureAirport;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private Date arrivalDate;
    @Column
    private Date departureDate;
    @Column
    private Double price;

}