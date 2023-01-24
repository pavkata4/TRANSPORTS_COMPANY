package com.example.transportcompany.services.Impl;

import com.example.transportcompany.Access.ManagerAccess;
import com.example.transportcompany.DTOS.LoginUserDTO;
import com.example.transportcompany.DTOS.RegisterUserDTO;
import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.entities.Person;
import com.example.transportcompany.repositories.ManagerDao;
import com.example.transportcompany.services.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private  StringBuilder sb;
    private final ManagerDao managerDao;

    private ManagerAccess managerAccess;

    private final ModelMapper mapper;

    private Optional<Person> loggedUser = Optional.empty();


    private  Scanner scanner;


    public AuthenticationServiceImpl( ManagerDao managerDao, ModelMapper mapper) {
        scanner = new Scanner(System.in);
        this.managerDao = managerDao;;
        this.mapper = mapper;

    }

    @Override
    public String registerManager(Manager manager) {
        RegisterUserDTO managerDTO = new RegisterUserDTO();

        System.out.println("Manager registration:");
        System.out.println("Enter email:");
        managerDTO.setEmail(scanner.nextLine());
        System.out.println("Enter a password");
        String newPassword = scanner.nextLine();
        System.out.println("Confirm password");
        String confirmNewPassword = scanner.nextLine();
        managerDTO.setPassword(newPassword);
        managerDTO.setConfirmPassword(confirmNewPassword);
        if (!managerDTO.getPassword().equals(managerDTO.getConfirmPassword())) {
            registerManager(manager);
        }
        manager.setPassword(managerDTO.getPassword());
        manager.setEmail(managerDTO.getEmail());
        return String.format("Мanager %s %s has been successfully registered!", manager.getFirstName(), manager.getLastName());

    }

    @Override
    public void loginManager() {
        LoginUserDTO loginUserDTO = new LoginUserDTO();
        System.out.println("Enter email:");
        loginUserDTO.setUsername(scanner.nextLine());
        System.out.println("Enter password: ");
        loginUserDTO.setPassword(scanner.nextLine());
        Optional<Manager> manager = managerDao.findByEmailAndPassword(loginUserDTO.getUsername(), loginUserDTO.getPassword());
        manager.ifPresent(value -> managerAccess.mangerMenu(value));

    }

    @Override
    public void registerCashier(Cashier cashier) {
        RegisterUserDTO cashierDTO = new RegisterUserDTO();
        System.out.println("Cashier registration:");
        System.out.println("Enter email:");
        cashierDTO.setEmail(scanner.nextLine());
        System.out.println("Enter a password");
        String newPassword = scanner.nextLine();
        System.out.println("Confirm password");
        String confirmNewPassword = scanner.nextLine();
        cashierDTO.setPassword(newPassword);
        cashierDTO.setConfirmPassword(confirmNewPassword);
        if (!cashierDTO.getPassword().equals(cashierDTO.getConfirmPassword())) {
            registerCashier(cashier);
        }
        cashier.setUsername(cashierDTO.getEmail());
        cashier.setPassword(cashierDTO.getPassword());
    }


}
