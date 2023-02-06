package com.wittybrains.studentmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Admin implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public Admin() {}

    public Admin(String username, String password) {
        this.username = username;
        this.password = bCryptPasswordEncoder.encode(password);
        this.enabled = true;
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void addAuthority(GrantedAuthority authority) {
        this.authorities.add(authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = bCryptPasswordEncoder.encode(password);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void createTeacher(String username, String password) {
       
    }

    public void createStudent(String username, String password) {
        
    }
}

