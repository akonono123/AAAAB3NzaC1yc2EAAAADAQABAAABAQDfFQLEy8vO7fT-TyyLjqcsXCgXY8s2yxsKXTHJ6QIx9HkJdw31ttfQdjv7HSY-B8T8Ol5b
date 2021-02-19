package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Users findByUsername(String username){
        return  userRepository.findByUsername(username);
    }
    public Optional<Users> findbyId(Long id){
       return userRepository.findById(id);
    }
    public void save(Users user){
        userRepository.save(user);
    }

    public Users update(Users user){
        return userRepository.save(user);
    }
    public List<Users> findall(){
       return userRepository.findAll();
    }
}
