package com.example.transportcompany.services;


import com.example.transportcompany.entities.Company;

public interface CompanyService {

    void addCompany(Company company);

    void DeleteCompanyByName(String name);


}
