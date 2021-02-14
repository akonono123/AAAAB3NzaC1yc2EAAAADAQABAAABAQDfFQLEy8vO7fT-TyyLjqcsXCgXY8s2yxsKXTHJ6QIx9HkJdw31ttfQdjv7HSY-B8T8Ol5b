package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.TodoList;

import java.util.ArrayList;
import java.util.List;
public class TodoService {
    public List<TodoList> AddItems() {
        List<TodoList> items = new ArrayList<>();
        items.add(new TodoList("1", "Wake up"));
        items.add(new TodoList("2", "Drink water"));
        items.add(new TodoList("3", "Do some exercise"));
        return items;
    }
}
