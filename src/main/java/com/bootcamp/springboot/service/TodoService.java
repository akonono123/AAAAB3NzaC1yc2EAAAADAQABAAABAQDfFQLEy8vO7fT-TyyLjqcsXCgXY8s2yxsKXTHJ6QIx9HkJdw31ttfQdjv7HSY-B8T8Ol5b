package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.TodoList;
import com.bootcamp.springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todorepo;
    @Autowired
    DbService databaseService;



    public List<TodoList> getTodo() {
        return todorepo.findAll();
    }

    public TodoList saveData(TodoList todo){
        return todorepo.save(todo);
    }

    public Optional<TodoList> getId(Long id){
        return todorepo.findById(id);
    }

    public void Deldata(Long id){
        todorepo.deleteById(id);
    }
}
