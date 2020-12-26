package com.microservices2.roomservices.controller;

import com.microservices2.roomservices.model.Room;
import com.microservices2.roomservices.repository.RoomRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomWebServices {

    private final RoomRepository roomRepository;

    public RoomWebServices(RoomRepository repository){
        this.roomRepository=repository;
    }

    @GetMapping
    public Iterable<Room> getAllRoomsInfo(){
        return this.roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoombyID(@PathVariable("id") Long id){
        return this.roomRepository.findById(id).get();
    }
}
