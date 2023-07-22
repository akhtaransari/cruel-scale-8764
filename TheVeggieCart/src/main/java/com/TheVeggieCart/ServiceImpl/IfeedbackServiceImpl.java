package com.TheVeggieCart.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TheVeggieCart.Exception.FeedbackNotFoundException;
import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Exception.VegetableNotFoundException;
import com.TheVeggieCart.Model.Customer;
import com.TheVeggieCart.Model.Feedback;
import com.TheVeggieCart.Model.VegetableDTO;
import com.TheVeggieCart.Repository.CustomerRepository;
import com.TheVeggieCart.Repository.FeedbackRepository;
import com.TheVeggieCart.Repository.VegetableDTORepository;
import com.TheVeggieCart.Service.IFeedbackService;

@Service
public class IfeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VegetableDTORepository vegetableDTORepository;

    @Override
    public Feedback addFeedBack(Feedback feedBack, Long vegetableId, Integer customerId)
            throws VegetableNotFoundException, UserNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new UserNotFoundException("Customer is not present with Id: " + customerId);
        }

        // Check if the vegetable exists
        Optional<VegetableDTO> vegetableOptional = vegetableDTORepository.findById(vegetableId);
        if (vegetableOptional.isEmpty()) {
            throw new VegetableNotFoundException("Vegetable is not present with Id: " + vegetableId);
        }

        // Set the customer and vegetable for the feedback
        feedBack.setCustomerId(customerOptional.get());
        feedBack.setVegetableId(vegetableOptional.get());

        // Set the feedback date and time to the current date and time
        //feedBack.setFeedbackDateTime(LocalDateTime.now());

        // Save the feedback
        return feedbackRepository.save(feedBack);
    }

    @Override
    public Feedback updateFeedBack(Feedback feedback) throws FeedbackNotFoundException {
        Optional<Feedback> optional = feedbackRepository.findById(feedback.getFeedbackId());

        if (optional.isPresent()) {
            Feedback existingFeedback = optional.get();
            existingFeedback.setRating(feedback.getRating());
            existingFeedback.setComments(feedback.getComments());

            return feedbackRepository.save(existingFeedback);
        } else {
            throw new FeedbackNotFoundException("No feedback found!");
        }
    }

    @Override
    public Feedback viewFeedback(Integer id) throws FeedbackNotFoundException {
        Optional<Feedback> fedOptional = feedbackRepository.findById(id);
        if (fedOptional.isPresent()) {
            return fedOptional.get();
        }
        throw new FeedbackNotFoundException("No feedback found!");
    }

    @Override
    public List<Feedback> viewFeedbackAll() throws FeedbackNotFoundException {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        if (!feedbackList.isEmpty()) {
            return feedbackList;
        }
        throw new FeedbackNotFoundException("No feedbacks found!");
    }
}
