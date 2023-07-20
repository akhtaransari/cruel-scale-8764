package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Model.Feedback;

public interface IFeedbackService {

    Feedback addFeedback(Feedback fdbk);
    List<Feedback> viewAllFeedbacks(int vegid);
    List<Feedback> viewFeedback(int custid);

}

