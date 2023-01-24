package com.example.transportcompany.Access;

import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.services.CashierService;
import com.example.transportcompany.services.DriverService;
import com.example.transportcompany.services.OfficeService;

import java.util.Scanner;

public class ManagerAccess {

    Scanner scanner;

    private final Cashier cashier;

    private final CashierService cashierService;

    private final OfficeService officeService;

    private final DriverService driverService;

    public ManagerAccess(Cashier cashier, CashierService cashierService, OfficeService officeService, DriverService driverService) {
        this.cashier = cashier;
        this.cashierService = cashierService;
        this.officeService = officeService;
        this.driverService = driverService;
        this.scanner = new Scanner(System.in);
    }


    public void mangerMenu(Manager manager) {
        System.out.println("0 - LogOut");
        System.out.println("1 - appoint cashier");
        System.out.println("2 - fired cashier");
        System.out.println("3 - appoint driver");
        System.out.println("4 - fired driver");
        int input = Integer.parseInt(scanner.nextLine());
        if (input != 0) {
            action(Integer.parseInt(scanner.nextLine()), manager);
            mangerMenu(manager);
        }

    }

    private void action(int value, Manager manager){
        switch (value){
            case 1:
                cashierService.appointCashier(officeService.getOffice().get());
                break;
            case 2:
                cashierService.firedCashier(officeService.getOffice().get());
                break;
            case 3:
                driverService.appointDriver(manager.getCompany());
                break;
            case 4:{
                driverService.firedDriver(manager.getCompany());
            }

        }
    }
}

