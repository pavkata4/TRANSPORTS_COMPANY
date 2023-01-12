package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Long> {

    void deleteById(Long id);


}
