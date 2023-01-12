package com.example.transportcompany.services.Impl;

import com.example.transportcompany.DTOS.RegisterUserDTO;
import com.example.transportcompany.entities.Person;
import com.example.transportcompany.entities.Employer;
import com.example.transportcompany.repositories.EmployeeDao;
import com.example.transportcompany.repositories.EmployerDao;
import com.example.transportcompany.services.AuthenticationService;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.Scanner;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final StringBuilder sb;
    private final EmployeeDao employeeDao;

    private final EmployerDao employerDao;

    private final ModelMapper mapper;

    private Optional<Person> loggedUser;

    private final Scanner scanner;


    public AuthenticationServiceImpl(StringBuilder sb, EmployeeDao employeeDao, EmployerDao employerDao, ModelMapper mapper, Scanner scanner) {
        this.sb = sb;
        this.employeeDao = employeeDao;
        this.employerDao = employerDao;
        this.mapper = mapper;
        this.scanner = scanner;
    }

    public String registerEmployer(RegisterUserDTO employerDTO){
        while (!employerDTO.getPassword().equals(employerDTO.getConfirmPassword())){
            String newPassword = scanner.nextLine();
            String confirmNewPassword = scanner.nextLine();
            System.out.println("Enter a new password");
            employerDTO.setPassword(newPassword);
            System.out.println("Confirm password");
            employerDTO.setConfirmPassword(confirmNewPassword);
            registerEmployer(employerDTO);
        }
        Employer employer;
        employer = mapper.map(employerDTO, Employer.class);
        employerDao.saveAndFlush(employer);
        return "Successfully registered.";
    }

   /* public String LogInUser(){

    }

    public String registerEmployee(RegisterUserDTO employeeDTO){
        sb.delete(0,sb.length());
        Person person;
        person = mapper.map(employeeDTO, Person.class);

        if (employeeDao.findAll().isEmpty()) {
            person.setRole(Role.ADMIN);
        } else {
            user1.setRole(Role.USER);
        }
        // try {
        userRepository.saveAndFlush(user1);
        sb.append(String.format("%s was registered.", user.getFullName()));
        // } catch (Exception e) {
        //   System.out.printf("Email %s already exist", user1.getMail());
        // }
//        }else {
//            sb.append("Passwords are not equals.");
//
//        }

        return sb.toString().trim();
    }

*/
}
