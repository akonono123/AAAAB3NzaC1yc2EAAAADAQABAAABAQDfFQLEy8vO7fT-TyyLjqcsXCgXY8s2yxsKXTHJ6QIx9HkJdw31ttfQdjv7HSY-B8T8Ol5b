package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.TodoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    public List<TodoList> AddItems() {
        List<TodoList> items = new ArrayList<>();
        items.add(new TodoList(1, "Wake up"));
        items.add(new TodoList(2, "Drink water"));
        items.add(new TodoList(3, "Do some exercise"));
        return items;
    }

    @GetMapping("/list")
    ResponseEntity<List<TodoList>> index() {
        List<TodoList> item = this.AddItems();


        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
