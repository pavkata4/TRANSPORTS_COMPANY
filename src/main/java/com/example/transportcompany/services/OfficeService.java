package com.example.transportcompany.services;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Office;

import java.util.Optional;

public interface OfficeService {
    void addOffice(Company company);

    void deleteOffice(Optional<Company> selectCompany);

    Optional<Office> getOffice();

    Office  getofficesInTown(String nextLine);
}
