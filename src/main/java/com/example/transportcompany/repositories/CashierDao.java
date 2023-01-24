package com.example.transportcompany.repositories;


import com.example.transportcompany.entities.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;
import java.util.List;

@Repository
public interface CashierDao extends JpaRepository<Cashier , Long> {

}
