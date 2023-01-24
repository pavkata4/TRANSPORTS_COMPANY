package com.example.transportcompany.services.Impl;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.repositories.CompanyDao;
import com.example.transportcompany.repositories.ManagerDao;
import com.example.transportcompany.services.AuthenticationService;
import com.example.transportcompany.services.ManagerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;


@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerDao managerDao;

    private final AuthenticationService authenticationService;

    private Scanner scanner;


    public ManagerServiceImpl(ManagerDao managerDao, CompanyDao companyDao, AuthenticationService authenticationService) {
        this.managerDao = managerDao;
        this.authenticationService = authenticationService;

        this.scanner = new Scanner(System.in);
    }


    @Override
    public void addManager(Company company) {
        Manager manager = new Manager();
        System.out.println("Enter first name: ");
        manager.setFirstName(scanner.nextLine());
        System.out.println("Enter last name: ");
        manager.setLastName(scanner.nextLine());
        System.out.println("Enter age");
        manager.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter salary");
        manager.setSalary(BigDecimal.valueOf(Long.parseLong(scanner.nextLine())));
        System.out.println("Enter phone number");
        manager.setPhoneNumber(scanner.nextLine());
        manager.setAppointmentDate(LocalDate.now());
        manager.setCompany(company);
        authenticationService.registerManager(manager);
        managerDao.saveAndFlush(manager);
        System.out.println();

//     Optional<Company> company1 = companyDao.findById(company.getId());
//     company1.get().setManager(managerDao.findById(manager.getId()).get());
//     companyDao.save(company1.get());

    }

//    @Override
//    public long selectManagerId() {
//        List<Manager> all = managerDao.findAll();
//        for (Manager manager : all) {
//            System.out.println(manager.getId() + " - " + manager.getFirstName() + " - " + manager.getLastName() + " - " + manager.getCompany().getName());
//        }
//        System.out.println("Select ID: ");
//        return Long.parseLong(scanner.nextLine());
//    }

    @Override
    @Transactional
    public void firedManager(Optional<Company> selectCompany) {
        managerDao.deleteManagerByCompanyId(selectCompany.get().getId());


    }


}
