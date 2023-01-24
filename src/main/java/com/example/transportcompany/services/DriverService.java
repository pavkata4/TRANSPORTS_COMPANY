package com.example.transportcompany.services;

import com.example.transportcompany.entities.Company;

import java.util.Optional;

public interface DriverService {
    void appointDriver(Company company);

    void firedDriver(Company selectCompany);
}
