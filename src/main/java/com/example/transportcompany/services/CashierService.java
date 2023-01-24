package com.example.transportcompany.services;

import com.example.transportcompany.entities.Company;
import com.example.transportcompany.entities.Office;

public interface CashierService {


    void appointCashier(Office office);

    void firedCashier(Office office);
}
