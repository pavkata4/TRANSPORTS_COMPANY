package com.example.transportcompany.services;

import com.example.transportcompany.DTOS.RegisterUserDTO;
import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.entities.Person;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AuthenticationService {

    public String registerManager(Manager manager);

    void loginManager();


    void registerCashier(Cashier cashier);
}


