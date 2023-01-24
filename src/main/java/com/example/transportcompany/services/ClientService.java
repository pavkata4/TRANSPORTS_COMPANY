package com.example.transportcompany.services;

import com.example.transportcompany.entities.Client;

import java.util.Collection;
import java.util.Optional;

public interface ClientService {

    void deleteClient(long id);

    Optional<Client> getClientByPhoneNumber(String phoneNumber);

    void addClient(String phoneNumber);
}
