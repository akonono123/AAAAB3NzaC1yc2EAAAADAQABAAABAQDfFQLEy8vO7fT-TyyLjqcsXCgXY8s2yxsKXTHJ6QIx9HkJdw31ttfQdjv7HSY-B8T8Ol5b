package com.bootcamp.springboot.model;

import javax.persistence.*;

@Entity
@Table(name="Sample_tbl")
public class TodoList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="task_name")
    private String name;


    public TodoList(){
        super();
    }

    public TodoList(long id,String name){
        super();
        this.id=id;
        this.name=name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
