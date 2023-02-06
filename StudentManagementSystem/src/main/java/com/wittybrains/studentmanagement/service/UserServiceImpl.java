package com.wittybrains.studentmanagement.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wittybrains.studentmanagement.model.User;
import com.wittybrains.studentmanagement.repository.StudentRepository;
import com.wittybrains.studentmanagement.repository.UserRepository;



@Service
public class UserServiceImpl implements UserDetailsService{
@Autowired
    private  UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
   
    public void create(User user) {
        user = userRepository.save(user);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.findByEmail(username);
	if(user==null) {
		throw new UsernameNotFoundException(username);
	}
	return new org.springframework.security.core.userdetails.User(username, user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("USER")));
	}

	
}
