package com.example.API_Lancha.repository;

import com.example.API_Lancha.entity.Role;
import com.example.API_Lancha.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByHour(String hour);
    Ship findByGo(Role go);
}
