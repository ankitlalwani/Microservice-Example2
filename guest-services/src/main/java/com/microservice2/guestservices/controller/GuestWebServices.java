package com.microservice2.guestservices.controller;

import com.microservice2.guestservices.model.Guest;
import com.microservice2.guestservices.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {

    private final GuestRepository guestRepository;

    public GuestWebServices(GuestRepository repository){
        this.guestRepository=repository;
    }

    @GetMapping("/")
    public Iterable<Guest> getAllGuests(){
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Guest> getGuestById(@PathVariable Long id){
        return this.guestRepository.findById(id);
    }
}
