package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.Admin;

public interface IAdminService {

    Admin addAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    Admin removeAdmin(Admin admin);
    Admin viewAdmin(Admin admin);

}

