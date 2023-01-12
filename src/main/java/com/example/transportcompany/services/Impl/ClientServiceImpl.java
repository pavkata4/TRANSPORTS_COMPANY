package com.example.transportcompany.services.Impl;

import com.example.transportcompany.repositories.ClientDao;
import com.example.transportcompany.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void deleteClient(long id) {
        clientDao.deleteById(id);
    }
}
