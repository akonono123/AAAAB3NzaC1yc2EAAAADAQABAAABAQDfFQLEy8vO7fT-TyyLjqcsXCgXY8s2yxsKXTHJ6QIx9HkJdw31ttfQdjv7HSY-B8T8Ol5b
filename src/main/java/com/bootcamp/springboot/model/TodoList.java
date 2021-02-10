package com.bootcamp.springboot.model;

public class TodoList {
    private int itemId;
    private String name;


    public TodoList(int itemID,String name){
        this.itemId=itemID;
        this.name=name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
