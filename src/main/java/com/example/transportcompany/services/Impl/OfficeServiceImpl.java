package com.example.transportcompany.services.Impl;


import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Office;
import com.example.transportcompany.repositories.OfficeDao;
import com.example.transportcompany.services.OfficeService;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class OfficeServiceImpl implements OfficeService {

    private  Scanner scanner;
  private final   OfficeDao officeDao;

    public OfficeServiceImpl( OfficeDao officeDao) {

        this.officeDao = officeDao;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void addOffice(Company company) {

        Office office = new Office();
        System.out.println("Enter town:");
        office.setTown(scanner.nextLine());
        System.out.println("Enter street: ");
        office.setStreet(scanner.nextLine());
        System.out.println("Enter number");
        office.setNumber(scanner.next());
        office.setCompany(company);
        officeDao.saveAndFlush(office);


    }

    @Override
    @Transient
    public void deleteOffice(Optional<Company> selectCompany) {

        List<Office> offices = officeDao.findOfficesByCompany(selectCompany.get());
        System.out.println("Select office ID to remove: ");
        for (Office office : offices) {
            System.out.println(office.getId() + " " + office.getTown() + " " + office.getStreet() + " " + office.getNumber());
        }

        long Id;

        do {
            System.out.println("Select office ID to remove: ");
            Id = Long.parseLong(scanner.nextLine());
        }while (officeDao.getOfficeById(Id).isEmpty());


    }

    @Override
    public Optional<Office> getOffice() {
        officeDao.findAll().forEach(o->System.out.println(o.getId() + " " + o.getTown() + " " + o.getStreet()+ " " +o.getNumber()));
        long id;
       do {
           id = Long.parseLong(scanner.nextLine());
       }while(officeDao.findById(id).isEmpty());
        return officeDao.findById(id);
    }

    @Override
    public Office getofficesInTown(String town) {
        officeDao.findAllByTown(town).forEach(o->System.out.println(o.getId() + " " + o.getTown() + " " + o.getStreet()+ " " +o.getNumber()));
        long id;
        do {
            id = Long.parseLong(scanner.nextLine());
        }while(officeDao.findById(id).isEmpty());
        return officeDao.findById(id).get();
    }
}
