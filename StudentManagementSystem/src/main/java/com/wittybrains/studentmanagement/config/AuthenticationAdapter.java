package com.wittybrains.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wittybrains.studentmanagement.service.UserServiceImpl;

@Configuration
public class AuthenticationAdapter extends GlobalAuthenticationConfigurerAdapter{
	@Autowired
	private UserServiceImpl userservice;
	@Autowired
	private PasswordEncoder passwordencoder;
@Override
public void init(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userservice).passwordEncoder(passwordencoder);
}
}
