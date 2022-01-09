
package onlinestore.withoutlist.configs;

import onlinestore.withoutlist.enteties.impl.DefaultCart;
import onlinestore.withoutlist.enteties.Cart;
import onlinestore.withoutlist.enteties.User;
import onlinestore.withoutlist.menu.Menu;



public class ApplicationContext {
	
    private static ApplicationContext instance;

    private User loggedInUser;
    private Menu mainMenu;
    private Cart sessionCart;

    private ApplicationContext() {
    }

    public void setLoggedInUser(User user) {
        if (this.sessionCart != null) {
                this.sessionCart.clear(); // we have to clear session cart when new user is logged in
        }
        this.loggedInUser = user;
    }

    public User getLoggedInUser() {
            return this.loggedInUser;
    }

    public void setMainMenu(Menu menu) {
        this.mainMenu = menu;
    }

    public Menu getMainMenu() {
        return this.mainMenu;
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public Cart getSessionCart() {
        if (this.sessionCart == null) {
            this.sessionCart = new DefaultCart();
        }
        return this.sessionCart;
    }
}
