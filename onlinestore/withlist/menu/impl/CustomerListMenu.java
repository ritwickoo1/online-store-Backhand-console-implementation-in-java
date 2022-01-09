/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore.withlist.menu.impl;

import java.util.List;
import onlinestore.withlist.configs.ApplicationContext;
import onlinestore.withlist.enteties.User;
import onlinestore.withlist.menu.Menu;
import onlinestore.withlist.services.UserManagementService;
import onlinestore.withlist.services.impl.DefaultUserManagementService;


public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
            userManagementService = DefaultUserManagementService.getInstance();
            context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
            printMenuHeader();
            List<User> users = userManagementService.getUsers();

            if (users.size() == 0) {
                    System.out.println("Unfortunately, there are no customers.");
            } else {
                    for (User user : users) {
                            System.out.println(user);
                    }
            }
            context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
            System.out.println("***** USERS *****");		
    }

}
