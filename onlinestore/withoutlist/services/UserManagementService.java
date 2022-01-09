package onlinestore.withoutlist.services;
import onlinestore.withoutlist.enteties.User;
public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}
