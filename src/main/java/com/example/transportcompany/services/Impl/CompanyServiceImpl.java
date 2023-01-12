package com.example.transportcompany.services.Impl;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.repositories.CompanyDao;
import com.example.transportcompany.services.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

   private final CompanyDao companyDao;

@Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }


    @Override
    public void addCompany(Company company) {
        companyDao.saveAndFlush(company);
    }

    @Override
    @Transactional
    public void DeleteCompanyByName(String name) {
        companyDao.deleteByName(name);
    }
}
