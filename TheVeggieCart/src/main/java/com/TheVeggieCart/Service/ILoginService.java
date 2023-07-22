package com.TheVeggieCart.Service;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;

import com.TheVeggieCart.Model.User;

public interface ILoginService {

    User validateLogin(Authentication auth);
    User logout(User user);

}
