package db.mongo;

import java.util.List;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import db.UsersDao;

@Repository
public class UsersDaoMongoImpl implements UsersDao {

	@Autowired
	MongoOperations mongo;
	
	@Override
	public List<User> listUsers() {
		return mongo.findAll(User.class);
	}

	@Override
	public User createUser(User user) {
		mongo.insert(user);
		return user;
	}

}
