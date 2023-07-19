package com.TheVeggieCart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TheVeggieCart.Model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
