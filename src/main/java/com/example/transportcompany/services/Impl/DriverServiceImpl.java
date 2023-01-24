package com.example.transportcompany.services.Impl;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Driver;
import com.example.transportcompany.entities.Qualification;
import com.example.transportcompany.repositories.DriverDao;
import com.example.transportcompany.services.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@Service
public class DriverServiceImpl implements DriverService {

    private Scanner scanner;

    private final DriverDao driverDao;

    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void appointDriver(Company selectCompany) {

        Driver driver = new Driver();

        System.out.println("Enter first name: ");
        driver.setLastName(scanner.nextLine());

        System.out.println(("Enter last name: "));
        driver.setLastName(scanner.nextLine());

        System.out.println("Enter age: ");
        driver.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.println("Select qualifications: ");
        System.out.println("0 - Exit");
        System.out.println("1 - passenger bus");
        System.out.println("2 - tanker");
        System.out.println("3 - dangerous-goods");
        System.out.println("4 - truck");
        System.out.println("5 - van");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1: driver.setQualification(Qualification.passenger_bus);
            break;
            case 2: driver.setQualification(Qualification.tanker);
            break;
            case 3: driver.setQualification(Qualification.dangerous_goods);
            break;
            case 4: driver.setQualification(Qualification.truck);
            break;
            case 5: driver.setQualification(Qualification.van);
            break;
            default:
                System.out.println("Invalid option!");
                break;
        }



        System.out.println("Enter salary:");
        driver.setSalary(BigDecimal.valueOf(Long.parseLong(scanner.nextLine())));

        System.out.println("");


        driver.setAppointmentDate(LocalDate.now());

        driverDao.saveAndFlush(driver);




    }

    @Override
    @Transactional
    public void firedDriver(Company selectCompany) {
        System.out.println("Select driver ID: ");
        selectCompany.getDrivers().forEach(driver ->System.out.println(driver.getId() + " " + driver.getFirstName() + " " + driver.getLastName()));
        driverDao.deleteById(Long.parseLong(scanner.nextLine()));
    }
}
