package com.bootcamp.springboot.model;

public class TodoList {
    private String itemId;
    private String name;

    public TodoList(){
        super();
    }

    public TodoList(String itemID,String name){
        super();
        this.itemId=itemID;
        this.name=name;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
