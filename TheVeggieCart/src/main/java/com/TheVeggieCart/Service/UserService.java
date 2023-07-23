package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.User;

public interface UserService {
	
	User addUser(User user);
    User updateUser(User user);
    User removeUser(Long userId);
    User viewUser(Long userId);
    List<User> viewUsers();
    String changePassword(PasswordChangeRequest passwordChangeRequest , Long userId);
}
