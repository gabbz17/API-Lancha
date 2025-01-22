package com.example.API_Lancha.service;

import com.example.API_Lancha.entity.Role;
import com.example.API_Lancha.entity.Ship;
import com.example.API_Lancha.exception.IdNotFoundException;
import com.example.API_Lancha.exception.ListNotFoundException;
import com.example.API_Lancha.exception.NameNotFoundException;
import com.example.API_Lancha.exception.NameUniqueException;
import com.example.API_Lancha.repository.ShipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        List<Ship> ships = repository.findAll();

        if (ships.isEmpty()){
            throw new ListNotFoundException("Lista vazia!");
        }
        return ships;
    }

    public Ship findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Lancha com o id (%d), não encontrada!", id)));
    }

    public Ship findByHour(String hour){
        return repository.findByHour(hour).orElseThrow(() ->
                new NameNotFoundException(String.format("Lancha com o horário (%s), não encontrada!", hour)));
    }

    public Ship findByGo(Role go){
        return repository.findByGo(go).orElseThrow(() ->
                new NameNotFoundException(String.format("Viagem para (%s), não encontrada!", go)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Ship update(Long id, String hour){
        log.info("Alterando o horário para às: " + hour);
        Ship ship = findById(id);

        ship.setHour(hour);
        return repository.save(ship);
    }
}
