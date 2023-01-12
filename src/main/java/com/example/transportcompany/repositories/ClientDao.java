package com.example.transportcompany.repositories;

import com.example.transportcompany.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    void deleteById(long id);


}
