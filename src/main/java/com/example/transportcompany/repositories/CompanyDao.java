package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {

    void deleteByName(String name);
    Optional<Company> getCompanyByName(String name);

    List<Company> findAll();

    Optional<Company> findById(Long id);

    void deleteById(Long id);
}
