package com.example.API_Lancha.controller;

import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.entity.Trip;
import com.example.API_Lancha.service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trip")
public class TripController {

    @Autowired
    TripService service;

    @PostMapping
    public ResponseEntity<Trip> create(@Valid @RequestBody Trip trip){
        Trip s1 = service.create(trip);
        return ResponseEntity.status(201).body(s1);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> findAll(){
        List<Trip> ship = service.findAll();
        return ResponseEntity.ok().body(ship);
    }

    @GetMapping("/buyer/{buyer}")
    public ResponseEntity<Trip> findByBuyer(@Valid @PathVariable String buyer){
        Trip ship = service.findByBuyer(buyer);
        return ResponseEntity.ok().body(ship);
    }
}
