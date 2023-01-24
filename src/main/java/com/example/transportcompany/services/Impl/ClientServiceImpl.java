package com.example.transportcompany.services.Impl;

import com.example.transportcompany.entities.Client;
import com.example.transportcompany.repositories.ClientDao;
import com.example.transportcompany.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private Scanner scanner;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void deleteClient(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public void addClient(String phoneNumber) {
        Client client = new Client();
        System.out.println("Client registration");
        System.out.println("Enter firstname:");
        client.setFirstName(scanner.nextLine());
        System.out.println("Enter lastname");
        client.setLastName(scanner.nextLine());
        client.setPhoneNumber(phoneNumber);
        clientDao.saveAndFlush(client);

    }

    @Override
    public Optional<Client> getClientByPhoneNumber(String phoneNumber) {
        return clientDao.findByPhoneNumber(phoneNumber);
    }
}
