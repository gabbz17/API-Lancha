package com.example.API_Lancha.service;

import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.entity.Trip;
import com.example.API_Lancha.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    TripRepository repository;
    @Autowired
    ShipService shipService;

    public Trip create(Trip trip){
        Ship ship = shipService.findByHour(trip.getHour());
        if (ship.getLimite() < trip.getLength()){
            throw new RuntimeException("Limite de passageiros excedido!");
        }
            trip.setBuy(trip.getLength() * ship.getPrice());
            ship.setLimite(ship.getLimite() - trip.getLength());
        return repository.save(trip);
    }

    public List<Trip> findAll(){
        return repository.findAll();
    }
}
