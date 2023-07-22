package com.TheVeggieCart.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.TheVeggieCart.Model.User;
import com.TheVeggieCart.Repository.UserRepository;

@Service
public class ManualUserDetailsImpl implements UserDetailsService {
	
	
	@Autowired
	private UserRepository uRepo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = uRepo.findByUsername(username) ;
		if(user.isEmpty()) throw new UsernameNotFoundException("user not found") ;
		User us = user.get() ;
		List<GrantedAuthority> authorities = new ArrayList<>() ;
		SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+us.getRole().toUpperCase()) ;
		authorities.add(autho) ;
		org.springframework.security.core.userdetails.User secUser = new org.springframework.security.core.userdetails.User(us.getUsername(), us.getPassword(),  authorities) ;
		return secUser ;
	}

}
