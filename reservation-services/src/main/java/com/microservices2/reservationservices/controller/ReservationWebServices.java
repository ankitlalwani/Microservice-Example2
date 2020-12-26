package com.microservices2.reservationservices.controller;

import com.microservices2.reservationservices.model.Reservation;
import com.microservices2.reservationservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {

    private final ReservationRepository reservationRepository;

    public ReservationWebServices(ReservationRepository repository){
        super();
        this.reservationRepository=repository;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations(){
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationByID(@PathVariable("id") Long id){
        return this.reservationRepository.findById(id).get();
    }
}
