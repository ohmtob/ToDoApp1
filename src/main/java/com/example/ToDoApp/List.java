package com.example.ToDoApp;

import javax.persistence.*;
import java.sql.Date;

@Entity
    public class List {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private Date created;

        @ManyToOne
        private List list;

        public List() {
        }

        public List(String name, String description, Date created) {
            this.name = name;
            this.description = description;
            this.created = created;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
