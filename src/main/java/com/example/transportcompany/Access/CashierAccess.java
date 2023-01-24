package com.example.transportcompany.Access;

import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Manager;
import com.example.transportcompany.services.OrderService;

import java.util.Scanner;

public class CashierAccess {

    Scanner scanner;

    private final OrderService orderService;

    public CashierAccess(OrderService orderService) {
        this.orderService = orderService;
        this.scanner = new Scanner(System.in);

    }

    public void cashierMenu(Cashier cashier) {
        System.out.println("0 - Logout");
        System.out.println("1 - push order");
        System.out.println("2 - accept order");
        int input = Integer.parseInt(scanner.nextLine());
        if (input != 0) {
            action(Integer.parseInt(scanner.nextLine()), cashier);
            cashierMenu(cashier);
        }

    }

    private void action(int input, Cashier cashier){
        switch (input){
            case 1:
                orderService.pushOrder(cashier);
                break;
        }
    }
}
