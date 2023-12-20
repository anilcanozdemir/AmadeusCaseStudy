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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    Airport departureAirport;
    @Column
    private Date arrivalDate;
    @Column
    private Date departureDate;
    @Column
    private Double price;

}