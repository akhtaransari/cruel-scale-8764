package com.TheVeggieCart.Service;

import com.TheVeggieCart.Exception.InvalidRequestException;
import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User validateLogin(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidRequestException("Password is required for login.");
        }
        return userRepository.save(user);
    }

    @Override
    public User logout(User user) {
     
        return user;
    }
}
