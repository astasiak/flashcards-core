package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.LinkedList;
import java.util.List;

import model.User;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UsersController {
	
	private List<User> users = new LinkedList<User>();

    @ResponseBody
    @RequestMapping(method=GET)
    public List<User> listUsers() {
        return users;
    }

    @ResponseBody
    @RequestMapping(method=POST)
    public User postGreeting(@RequestBody User user) {
    	users.add(user);
        return user;
    }
}
