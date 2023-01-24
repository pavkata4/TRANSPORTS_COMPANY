package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    void deleteById(long id);


    Optional<Client> findByPhoneNumber(String phoneNumber);
}
