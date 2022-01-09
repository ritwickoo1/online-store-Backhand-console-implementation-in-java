
package onlinestore.withoutlist.menu.impl;

import onlinestore.withoutlist.enteties.User;
import onlinestore.withoutlist.menu.Menu;
import onlinestore.withoutlist.services.UserManagementService;
import onlinestore.withoutlist.services.impl.DefaultUserManagementService;
import onlinestore.withoutlist.configs.ApplicationContext;

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
            User[] users = userManagementService.getUsers();

            if (users.length == 0) {
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
