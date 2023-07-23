
package com.TheVeggieCart.ServiceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Repository.UserRepository;
import com.TheVeggieCart.Service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
    UserRepository userRepository;
	
    @Override
    public User validateLogin(Authentication auth) {
    	Optional<User> opt= userRepository.findByUsername(auth.getUsername());
		 if(opt.isEmpty()) throw new NotFoundException("No user found") ;
        return opt.get();
    }

    @Override
    public User logout(User user) {
        return user;
    }
}
