package org.example;

public class Main {
    public static void main(String[] args) {
        Todo todoList= new Todo();
        System.out.println(todoList.getTodos().size());
        todoList.addItem("Item1");
        todoList.addItem("Item2");
        todoList.addItem("Item3");
        System.out.println(todoList.getTodos().size());

    }
}