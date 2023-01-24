package com.example.transportcompany;

import com.example.transportcompany.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {



    private  Scanner scanner;

    private final CompanyService companyService;

    private final ManagerService managerService;

    private final OfficeService officeService;

    private final DriverService driverService;

    private final AuthenticationService authenticationService;

    public Runner(CompanyService companyService, ManagerService managerService, OfficeService officeService, DriverService driverService, AuthenticationService authenticationService) {

        this.scanner = new Scanner(System.in);
        this.companyService = companyService;
        this.managerService = managerService;
        this.officeService = officeService;
        this.driverService = driverService;
        this.authenticationService = authenticationService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
                System.out.println("Select an option:");
                System.out.println("1 - register Company");
                System.out.println("2 - delete Company");
                System.out.println("3 - appoint Manager");
                System.out.println("4 - fired Manager");
                System.out.println("5 - register Office");
                System.out.println("6 - delete Office");
                System.out.println("7 - appoint Driver");
                System.out.println("8 - fired Driver");
                System.out.println("9 - buy Vehicle");
                System.out.println("10 - sell Vehicle");
                System.out.println("11 - View companies order by income");
                System.out.println("12 - View the employees order by salary");
                System.out.println("13 - View transports order by destination");
                System.out.println("14 - Login manager");
                System.out.println("15 - Login Cashier");

                int input = Integer.parseInt(scanner.nextLine());
                switch (input){
                    case 1:
                        companyService.addCompany();
                        break;
                    case 2:
                        companyService.deleteCompanyById(companyService.selectCompany());
                        break;
                    case 3:
                       managerService.addManager(companyService.selectCompany().get());
                       break;
                        case 4:
                            managerService.firedManager(companyService.selectCompany());
                            break;

                    case 5:
                        officeService.addOffice((companyService.selectCompany().get()));
                        break;

                    case 6:
                        officeService.deleteOffice(companyService.selectCompany());
                        break;

                    case 7:
                        driverService.appointDriver(companyService.selectCompany().get());
                        break;
                    case 8:
                        driverService.firedDriver(companyService.selectCompany().get());
                        break;

                    case 9:

                        break;

                    case 10:

                        break;

                    case 11:

                        break;

                    case 12:

                        break;

                    case 13:

                        break;

                    case 14:
                    }
                }
            }
        }



