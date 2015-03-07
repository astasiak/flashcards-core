package db;

import java.util.List;

import model.User;

public interface UsersDao {
	List<User> listUsers();
	User createUser(User user);
	void deleteUser(String id);
}
