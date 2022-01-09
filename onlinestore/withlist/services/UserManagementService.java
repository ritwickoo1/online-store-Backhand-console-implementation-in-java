
package onlinestore.withlist.services;

import java.util.List;
import onlinestore.withlist.enteties.User;

public interface UserManagementService {

    String registerUser(User user);
    List<User> getUsers();
    User getUserByEmail(String userEmail);

}