package com.example.API_Lancha.controller;

import com.example.API_Lancha.entity.Role;
import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ship")
public class ShipController {

    @Autowired
    ShipService service;

    @PostMapping
    public ResponseEntity<Ship> create(@Valid @RequestBody Ship ship){
        Ship s1 = service.create(ship);
        return ResponseEntity.status(201).body(s1);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> findAll(){
        List<Ship> ship = service.findAll();
        return ResponseEntity.ok().body(ship);
    }

    @GetMapping("/hour/{hour}")
    public ResponseEntity<Ship> findByHour(@Valid @PathVariable String hour){
        Ship ship = service.findByHour(hour);
        return ResponseEntity.ok().body(ship);
    }

    @GetMapping("/go/{go}")
    public ResponseEntity<Ship> findByGo(@Valid @PathVariable String go){
        Role role = Role.valueOf(go);
        Ship ship = service.findByGo(role);
        return ResponseEntity.ok().body(ship);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
