package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.TodoList;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Optional;


@RestController
public class TodoController {

/*public Map<Integer, TodoList> todmap= new HashMap<>();*/
public ModelAndView modView= new ModelAndView();

    @Qualifier("todoService")
    @Autowired
   TodoService todService;

   /* public TodoController(){
    todmap.put(1,(new TodoList(1, "Wake up")));
    todmap.put(2,(new TodoList(2, "Drink water")));
    todmap.put(3,(new TodoList(3, "Do some exercise")));
}*/

    @GetMapping("/")
    public ModelAndView Index() {


        modView.setViewName("todolist");
        return modView;
    }

    @GetMapping("/getalldata")
    public ResponseEntity<Collection<TodoList>> list() {
        Collection<TodoList> data = todService.getTodo();


        return ResponseEntity.ok(data);
    }

    @GetMapping("/Additem")
    public ModelAndView insertItem() {

        modView.setViewName("AddItem");
        return modView;
    }


    @PostMapping("/Additem")
    public String insertItem(@RequestBody TodoList todo) {

        String msg="";
      if (todo == null){
        msg = "error";
      }else{
          todService.saveData(todo);
       msg="success";
      }

        return msg;
    }
    @GetMapping("/selItem/{id}")
    public Optional<TodoList> editItem(@PathVariable("id") long itemId) {
     Optional<TodoList> data=todService.getId(itemId);

        return data;
    }
    @PostMapping("/EditItem/{id}")
    public String editItem(@PathVariable("id") long itemId,@RequestBody TodoList todo) {
        String msg="";
        if (todo == null){
            msg = "error";
        }else{
            todService.saveData(todo);
            msg="success";
        }


        return msg;
    }
    @GetMapping("/DeleteItem/{id}")
    public String delItem(@PathVariable("id") long itemId) {

            todService.Deldata(itemId);
            String msg="success";


        return msg;
    }

}
