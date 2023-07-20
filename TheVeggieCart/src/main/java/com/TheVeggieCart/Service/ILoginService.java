package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.User;

public interface ILoginService {

    User validateLogin(User user);
    User logout(User user);

}
