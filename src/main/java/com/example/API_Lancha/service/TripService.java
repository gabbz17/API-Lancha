package com.example.API_Lancha.service;

import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.entity.Trip;
import com.example.API_Lancha.exception.ListNotFoundException;
import com.example.API_Lancha.exception.NameNotFoundException;
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
        trip.setShipName(ship.getName());
            trip.setGo(ship.getGo());
            trip.setBuy(trip.getLength() * ship.getPrice());
            ship.setLimite(ship.getLimite() - trip.getLength());
        return repository.save(trip);
    }

    public List<Trip> findAll(){
        List<Trip> trips = repository.findAll();

        if (trips.isEmpty()){
            throw new ListNotFoundException("Lista vazia!");
        }

        return trips;
    }

    public Trip findByBuyer(String buyer){
        return repository.findByBuyer(buyer).orElseThrow(() ->
                new NameNotFoundException(String.format("Compra com o nome de titular (%s), não encontrada!", buyer)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
