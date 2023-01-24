package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeDao extends JpaRepository<Office, Long> {

    List<Office> findOfficesByCompany(Company company);

    void deleteById(Long id);


    Optional<Office> getOfficeById(Long id);

    List<Office> findAllByTown(String town);
}
