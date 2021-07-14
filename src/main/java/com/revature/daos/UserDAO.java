package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {

	User logInUser(String username, String pwd);

	ArrayList<User> findUserbyUsername(String username);

	void createNewUser(User user);

}
