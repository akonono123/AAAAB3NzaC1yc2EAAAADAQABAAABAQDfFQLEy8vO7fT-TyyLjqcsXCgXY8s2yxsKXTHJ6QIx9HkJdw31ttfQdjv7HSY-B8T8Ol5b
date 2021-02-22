package com.bootcamp.springboot.controller;


import com.bootcamp.springboot.model.Role;
import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;

@RestController
public class UserController {
    public ModelAndView modView= new ModelAndView();
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping("/UserIndex")
    public ModelAndView UserIndex(){
        modView.setViewName("userlist");
        return modView;
    }

    @GetMapping("/getalluserdata")
    public ResponseEntity<Collection<Users>> list() {
        Collection<Users> data = userService.findall();


        return ResponseEntity.ok(data);
    }

    @GetMapping("/getallrolesdata")
    public ResponseEntity<Collection<Role>> listrole() {

        Collection<Role> data = userService.list();


        return ResponseEntity.ok(data);
    }
    @GetMapping("/Adduser")
    public ModelAndView insertItem() {

        modView.setViewName("AddItem");
        return modView;
    }


    @PostMapping("/Adduser")
    public String insertItem(@RequestBody Users user) {

        String msg="";
        if (user == null){
            msg = "error";
        }else{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);
            msg="success";
        }

        return msg;
    }
    @GetMapping("/selActive")
    public Users editItem(String username) {
        Users data=userService.findByUsername(username);

        return data;
    }

    @GetMapping("/seluser/{id}")
    public Optional<Users> editItem(@PathVariable("id") long itemId) {
        Optional<Users> data=userService.findbyId(itemId);
        return data;
    }
    @PostMapping("/Edituser/{id}")
    public String editItem(@PathVariable("id") long itemId,@RequestBody Users user) {
        String msg="";
        if (user == null){
            msg = "error";
        }else{

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.save(user);
            msg="success";
        }


        return msg;
    }
    @GetMapping("/Deleteuser/{id}")
    public String delItem(@PathVariable("id") long itemId) {

       userService.deleteUser(itemId);
        String msg="success";


        return msg;
    }

}
