package com.TheVeggieCart.Service;

import com.TheVeggieCart.Model.BillingDetails;

public interface IBillingService {

    BillingDetails addBill(BillingDetails bill);
    BillingDetails updateBill(BillingDetails bill);
    BillingDetails viewBill(int id);

}

