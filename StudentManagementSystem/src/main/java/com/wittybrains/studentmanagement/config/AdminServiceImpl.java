package com.wittybrains.studentmanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wittybrains.studentmanagement.model.Admin;



@Service
public abstract class AdminServiceImpl implements UserDetailsService {

   
	private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(AdminServiceImpl.class.getName());

    

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
  

    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }

    public void autologin(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
          
            if (LOG.isLoggable(java.util.logging.Level.FINE)) {
            	LOG.fine(String.format("Auto login %s successfully!", username));
            	}
        }
    }

}

