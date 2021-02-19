package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailServiceImplt implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailServiceImplt.class);

@Autowired
 private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Users user =  userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        } else if (!user.isActive()) {
            throw new BadCredentialsException("User is not active");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),loadAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> loadAuthorities(Users user) {
        Set<GrantedAuthority> authorit = new HashSet<>();
        user.getRoles().forEach(role -> authorit.add(new SimpleGrantedAuthority(role.getRoleName())));
        return authorit;
    }
}
