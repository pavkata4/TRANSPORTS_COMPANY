package com.example.transportcompany.services.Impl;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.repositories.CompanyDao;
import com.example.transportcompany.services.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Scanner;


@Service
public class CompanyServiceImpl implements CompanyService {

   private final CompanyDao companyDao;

   private  Scanner scanner;

@Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    this.scanner = new Scanner(System.in);
}


    @Override
    public void addCompany() {
        Company company = new Company();
        System.out.println("Company name: ");
        company.setName(scanner.nextLine());
        companyDao.saveAndFlush(company);
    }





    @Override
    public Optional<Company> selectCompany() {
        for (Company company : companyDao.findAll()) {
            System.out.println(company.getId() + " " + company.getName());
        }
        System.out.println("Select Id: ");
        long id;
         do {
              id = Long.parseLong(scanner.nextLine());
         }while (companyDao.findById(id).isEmpty());
        return companyDao.findById(id);
    }

    @Override
    @Transactional
    public void deleteCompanyById(Optional<Company> selectCompany) {
        companyDao.deleteById(selectCompany.get().getId());
    }

}
