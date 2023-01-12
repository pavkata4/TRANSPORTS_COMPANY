package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {

    void deleteByName(String name);



}
