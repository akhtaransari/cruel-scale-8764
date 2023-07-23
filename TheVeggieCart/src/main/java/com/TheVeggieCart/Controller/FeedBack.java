package com.TheVeggieCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TheVeggieCart.Model.Feedback;
import com.TheVeggieCart.ServiceImpl.FeedbackServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/feeback")
@Slf4j
public class FeedBack {
	@Autowired
	FeedbackServiceImpl feedbackService;
	
	
	@PostMapping("/addFeedback/{vegetableId}/{customerId}")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,@PathVariable Long vegetableId,@PathVariable Integer customerId) {
       
            log.info("Added feedback for vegetable ID: {} by customer ID: {}", vegetableId, customerId);
            return new ResponseEntity<>(feedbackService.addFeedBack(feedback, vegetableId, customerId),HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateFeedback")
    public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
        
            log.info("Updated feedback with ID: {}", feedback.getFeedbackId());
            return new ResponseEntity<>(feedbackService.updateFeedBack(feedback),HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewFeedback/{id}")
    public ResponseEntity<Feedback> viewFeedback(@PathVariable Integer id) {

            log.info("Viewed feedback with ID: {}", id);
            return new ResponseEntity<>(feedbackService.viewFeedback(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewFeedbackAll")
    public ResponseEntity<List<Feedback>> viewFeedbackAll() {
        
            log.info("Viewed all feedbacks.");
            return new ResponseEntity<>(feedbackService.viewFeedbackAll(),HttpStatus.ACCEPTED);
    }
}
