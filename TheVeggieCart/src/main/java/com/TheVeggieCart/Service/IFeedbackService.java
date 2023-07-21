package com.TheVeggieCart.Service;

import java.util.List;

import com.TheVeggieCart.Exception.FeedbackNotFoundException;
import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Exception.VegetableNotFoundException;
import com.TheVeggieCart.Model.Feedback;

public interface IFeedbackService {

    Feedback addFeedBack(Feedback feedBack, Long vegetableId, Integer customerId) throws VegetableNotFoundException, UserNotFoundException;

    Feedback updateFeedBack(Feedback feedback) throws FeedbackNotFoundException;

    Feedback viewFeedback(Integer id) throws FeedbackNotFoundException;

    List<Feedback> viewFeedbackAll() throws FeedbackNotFoundException;
}
