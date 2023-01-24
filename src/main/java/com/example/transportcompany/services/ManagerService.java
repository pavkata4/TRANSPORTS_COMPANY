package com.example.transportcompany.services;


import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.repositories.ManagerDao;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ManagerService {

    void addManager(Company company);

   // long selectManagerId();


    void firedManager(Optional<Company> selectCompany);
}
