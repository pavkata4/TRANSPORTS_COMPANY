package com.example.transportcompany.services.Impl;


import com.example.transportcompany.entities.Cashier;
import com.example.transportcompany.entities.Good;
import com.example.transportcompany.entities.Order;
import com.example.transportcompany.repositories.OrderDao;
import com.example.transportcompany.services.ClientService;
import com.example.transportcompany.services.OfficeService;
import com.example.transportcompany.services.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final ClientService clientService;

    private final OrderDao orderDao;

    private final OfficeService officeService;

    private Scanner scanner;



    public OrderServiceImpl(ClientService clientService, OrderDao orderDao, OfficeService officeService) {
        this.clientService = clientService;
        this.orderDao = orderDao;
        this.officeService = officeService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void pushOrder(Cashier cashier) {
        Set<Good> goods = new LinkedHashSet<>();
        Order order = new Order();
        String input;
        do {
            Good good = new Good();
            System.out.println("Good description: ");
            good.setName(scanner.nextLine());
            System.out.println("Is fragile? -> Select 1 - YES : 2 - NO");
            if (scanner.nextLine().equals("1")){
                good.setFragile(true);
            }else {
                good.setFragile(false);
            }
            System.out.println("Could you insurance your good? Select 1 - YES : 2 - NO");
            if (scanner.nextLine().equals("1")) {
                System.out.println("Price: ");
                good.setInsurancePrice(BigDecimal.valueOf(Long.parseLong(scanner.nextLine())));
            }else {
                good.setInsurancePrice(BigDecimal.ZERO);
            }
            goods.add(good);
            System.out.println("Could you add more goods? 1 - Yes : 2 - No");
             input = scanner.nextLine();

        }while (!input.equals("2"));
        order.setGoods(goods);
        System.out.println("Enter the total weight of the order: ");
        order.setWeight(BigDecimal.valueOf(Double.parseDouble(scanner.nextLine())));
        BigDecimal price = new BigDecimal(0);
        price = order.getWeight().multiply(BigDecimal.valueOf(4));
        for (Good good : goods) {
            price = price.add(good.getInsurancePrice());
        }

        order.setPrice(price);
        order.setStartingPoint(String.format("%s %s %s",cashier.getOffice().getTown(), cashier.getOffice().getStreet(), cashier.getOffice().getNumber()));
        System.out.println("where is the order for: 1 - to office : 2 - to address ");
        if (scanner.nextLine().equals("1")){
            System.out.println("Enter town:");
            officeService.getofficesInTown(scanner.nextLine());


        }else {
            price = price.add(BigDecimal.TEN);
        }
        order.setPrice(price);
        System.out.println("Enter client phone: ");
        String phoneNumber = scanner.nextLine();
        if (clientService.getClientByPhoneNumber(phoneNumber).isEmpty()){
            clientService.addClient(phoneNumber);

        }else {

        }


        orderDao.saveAndFlush(order);

    }
}
