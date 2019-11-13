package com.example.ToDoApp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activity;
    private Boolean completed;
    private Date created;

    @ManyToOne
    private com.example.ToDoApp.ToDoItem toDoItem;

    public ToDoItem() {
    }

    public ToDoItem(String activity,Boolean completed,  Date created) {
        this.activity = activity;
        this.completed = completed;
        this.created = created;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


}