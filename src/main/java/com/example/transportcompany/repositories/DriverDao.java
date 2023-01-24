package com.example.transportcompany.repositories;


import com.example.transportcompany.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {


}
