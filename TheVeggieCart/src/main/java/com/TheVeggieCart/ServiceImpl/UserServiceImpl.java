package com.TheVeggieCart.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.TheVeggieCart.Exception.UserNotFoundException;
import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Repository.UserRepository;
import com.TheVeggieCart.Service.PasswordChangeRequest;
import com.TheVeggieCart.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeUser(Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if(findById.isEmpty()) throw new NotFoundException("not user found with "+userId);
		userRepository.deleteById(userId);
		return findById.get();
	}

	@Override
	public User viewUser(Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if(findById.isEmpty()) throw new NotFoundException("not user found with "+userId);
		return findById.get();
	}

	@Override
	public List<User> viewUsers() {
		List<User> findAll = userRepository.findAll();
		if(findAll.isEmpty()) throw new NotFoundException("Empty User List");
		
		return findAll;
	}

	@Override
	public String changePassword(PasswordChangeRequest passwordChangeRequest , Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (findById.isEmpty()) throw new UserNotFoundException("no such user here");
		User user = findById.get();
		user.setPassword(passwordChangeRequest.getNewPassword());
		userRepository.save(user);
		return "Succesfull";
	}

}
