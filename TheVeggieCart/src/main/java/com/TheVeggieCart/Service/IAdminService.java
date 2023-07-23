package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.Admin;

public interface IAdminService {

    Admin addAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    Admin removeAdmin(Integer admin);
    Admin viewAdmin(Admin admin);
    List<Admin> viewAdmins();
 
}

