package com.example.transportcompany.services.Impl;



import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Office;
import com.example.transportcompany.repositories.CashierDao;
import com.example.transportcompany.services.AuthenticationService;
import com.example.transportcompany.services.CashierService;
import com.example.transportcompany.services.OfficeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CashierServiceImpl implements CashierService {

    Scanner scanner;
    private final AuthenticationService authenticationService;

    private final CashierDao cashierDao;

    private final OfficeService officeService;

    public CashierServiceImpl(AuthenticationService authenticationService, CashierDao cashierDao, OfficeService officeService) {
        this.authenticationService = authenticationService;
        this.cashierDao = cashierDao;
        this.officeService = officeService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void appointCashier(Office office) {
        Cashier cashier = new Cashier();
        cashier.setFirstName(scanner.nextLine());
        cashier.setLastName(scanner.nextLine());
        cashier.setAge(Integer.parseInt(scanner.nextLine()));
        cashier.setPhoneNumber(scanner.nextLine());
        authenticationService.registerCashier(cashier);
        cashier.setOffice(office);
        cashierDao.saveAndFlush(cashier);
        System.out.println("Cashier: " + cashier.getFirstName() + "was successfully appointed!");
    }

    @Override
    @Transactional
    public void firedCashier(Office office) {
        officeService.getOffice().get().getCashiers().forEach(c-> System.out.println(c.getId() + " " + c.getFirstName() + " " + c.getLastName()));
        System.out.println("Select cashier id: ");
        cashierDao.deleteById(Long.parseLong(scanner.nextLine()));
    }
}
