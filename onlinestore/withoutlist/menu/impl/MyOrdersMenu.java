/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore.withoutlist.menu.impl;

import onlinestore.withoutlist.enteties.Order;
import onlinestore.withoutlist.menu.Menu;
import onlinestore.withoutlist.configs.ApplicationContext;
import onlinestore.withoutlist.services.OrderManagementService;
import onlinestore.withoutlist.services.impl.DefaultOrderManagementService;


public class MyOrdersMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
                System.out.println(
                                "Please, log in or create new account to see list of your orders");
                new MainMenu().start();
                return;
        } else {
                printUserOrdersToConsole();
        }
        new MainMenu().start();
    }

    private void printUserOrdersToConsole() {
        Order[] loggedInUserOrders = orderManagementService
                        .getOrdersByUserId(context.getLoggedInUser().getId());

        if (loggedInUserOrders == null || loggedInUserOrders.length == 0) {
                System.out.println(
                                "Unfortunately, you don’t have any orders yet. "
                                + "Navigate back to main menu to place a new order");
        } else {
                for (Order order : loggedInUserOrders) {
                        System.out.println(order);
                }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MY ORDERS *****");		
    }
}