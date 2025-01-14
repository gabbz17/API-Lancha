package com.example.API_Lancha.service;

import com.example.API_Lancha.entity.Role;
import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.exception.NameNotFoundException;
import com.example.API_Lancha.exception.NameUniqueException;
import com.example.API_Lancha.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    @Autowired
    ShipRepository repository;

    public Ship create(Ship ship){
        try {
            return repository.save(ship);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new NameUniqueException("Dados já cadastrados!");
        }
    }

    public List<Ship> findAll(){
        return repository.findAll();
    }

    public Ship findByHour(String hour){
        return repository.findByHour(hour).orElseThrow(() ->
                new NameNotFoundException(String.format("Lancha com o horário (%s), não encontrada!", hour)));
    }

    public Ship findByGo(Role go){
        return repository.findByGo(go);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
