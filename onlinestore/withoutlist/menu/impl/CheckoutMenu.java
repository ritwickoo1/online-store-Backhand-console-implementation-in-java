
package onlinestore.withoutlist.menu.impl;

import java.util.Scanner;
import onlinestore.withoutlist.enteties.Order;
import onlinestore.withoutlist.enteties.impl.DefaultOrder;
import onlinestore.withoutlist.menu.Menu;
import onlinestore.withoutlist.services.OrderManagementService;
import onlinestore.withoutlist.services.impl.DefaultOrderManagementService;
import onlinestore.withoutlist.configs.ApplicationContext;

public class CheckoutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
            context = ApplicationContext.getInstance();
            orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
            while (true) {
                    printMenuHeader();
                    Scanner sc = new Scanner(System.in);
                    String userInput = sc.next();

                    if (!createOrder(userInput)) {
                            continue;
                    }
                    context.getSessionCart().clear();
                    break;
            }

            System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
            new MainMenu().start();

    }

    private boolean createOrder(String creditCardNumber) {
            Order order = new DefaultOrder();
            if (!order.isCreditCardNumberValid(creditCardNumber)) {
                    return false;
            }

            order.setCreditCardNumber(creditCardNumber);
            order.setProducts(context.getSessionCart().getProducts());
            order.setCustomerId(context.getLoggedInUser().getId());
            orderManagementService.addOrder(order);
            return true;
    }

    @Override
    public void printMenuHeader() {
            System.out.println("***** CHECKOUT *****");
            System.out.print(
                            "Enter your credit card number without spaces and press enter if you confirm purchase: ");
    }

}