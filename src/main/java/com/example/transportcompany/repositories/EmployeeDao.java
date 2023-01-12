package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Person, Long> {


}
