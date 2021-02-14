package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.TodoList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RestController
public class TodoController {

public Map<String, TodoList> todmap= new HashMap<>();
public ModelAndView modView= new ModelAndView();


    public TodoController(){
    todmap.put("1",(new TodoList("1", "Wake up")));
    todmap.put("2",(new TodoList("2", "Drink water")));
    todmap.put("3",(new TodoList("3", "Do some exercise")));
}

    @GetMapping("/TodList")
    public ModelAndView List(Model model) {

         model.addAttribute("items", todmap.values());
        modView.setViewName("todolist");
        return modView;
    }
    @GetMapping("/Additem")
    public ModelAndView insertItem() {

        modView.setViewName("AddItem");
        return modView;
    }


    @PostMapping("/Additem")
    public ModelAndView insertItem(@ModelAttribute("insetItem") TodoList todo,Model model) {
       todmap.put(todo.getItemId(),todo);
        model.addAttribute("items", todmap.values());
        modView.setViewName("todolist");
        return modView;
    }
    @GetMapping("/EditItem/{id}")
    public ModelAndView editItem(@PathVariable("id") String itemId, Model model) {

        model.addAttribute("editItems", todmap.get(itemId));
        modView.setViewName("editItems");
        return modView;
    }
    @PostMapping("/EditItem/{id}")
    public ModelAndView editItem(@PathVariable("id") String itemId, Model model,@ModelAttribute("insetItem") TodoList todo) {
        todmap.put(todo.getItemId(),todo);
        model.addAttribute("items", todmap.get(itemId));
        modView.setViewName("todolist");
        return modView;
    }
    @GetMapping("/DeleteItem/{id}")
    public ModelAndView delItem(@PathVariable("id") String itemId, Model model) {
        todmap.remove(itemId);
        model.addAttribute("items", todmap.values());
        modView.setViewName("todolist");
        return modView;
    }

}
