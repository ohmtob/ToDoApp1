package com.example.ToDoApp;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String activity;
    private Boolean completed;


    @ManyToOne
    private Item item;

    public Item() {
    }

    public Item(String activity, Boolean completed, Date created) {
        this.activity = activity;
        this.completed = completed;

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



}