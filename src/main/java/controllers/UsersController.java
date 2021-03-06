package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.List;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import db.UsersDao;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	@Autowired
	private UsersDao usersDao;

    @ResponseBody
    @RequestMapping(method=GET)
    public List<User> listUsers() {
        return usersDao.listUsers();
    }

    @ResponseBody
    @RequestMapping(method=POST)
    public User postUser(@RequestBody User user) {
    	return usersDao.createUser(user);
    }

    @ResponseBody
    @RequestMapping(value="/{id}",method=DELETE)
    public void deleteUser(@PathVariable("id") String id) {
    	// TODO: return 204
    	usersDao.deleteUser(id);
    }
}
