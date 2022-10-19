package org.example;

import java.util.ArrayList;

public class Todo {
    public ArrayList<String> todos= new ArrayList<>();

    public void addItem(String todoItem){
        todos.add(todoItem);
    }

    public ArrayList<String> getTodos(){
        return todos;
    }
}
