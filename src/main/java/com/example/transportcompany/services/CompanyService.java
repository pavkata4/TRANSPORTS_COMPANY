package com.example.transportcompany.services;


import com.example.transportcompany.entities.Company;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyService {

    void addCompany();






  Optional<Company> selectCompany();

    void deleteCompanyById(Optional<Company> selectCompany);
}
