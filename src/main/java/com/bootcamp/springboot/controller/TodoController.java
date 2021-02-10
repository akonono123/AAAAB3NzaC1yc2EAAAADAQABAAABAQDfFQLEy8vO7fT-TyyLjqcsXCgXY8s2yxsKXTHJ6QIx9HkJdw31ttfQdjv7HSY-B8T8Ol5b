package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.TodoList;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private TodoService  todoService;

    @Autowired
    public TodoController(TodoService  todoService) {

      this.todoService=todoService;
    }

    @GetMapping("/list")
    ResponseEntity<List<TodoList>> index() {
        List<TodoList> item = this.todoService.AddItems();


        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
