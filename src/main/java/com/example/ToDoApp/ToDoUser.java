package com.example.ToDoApp;


import javax.persistence.*;

@Entity
public class ToDoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @ManyToOne
    private ToDoUser toDoUser;

    public ToDoUser() {
    }

    public ToDoUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ToDoUser getToDoUser() {
        return toDoUser;
    }

    public void setToDoUser(ToDoUser toDoUser) {
        this.toDoUser = toDoUser;
    }
}