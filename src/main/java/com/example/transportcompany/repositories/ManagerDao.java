package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Long> {

    void deleteManagerById(Long id);
    void deleteManagerByCompanyId(Long id);


    Optional<Manager> findByEmailAndPassword(String email, String password);
}
