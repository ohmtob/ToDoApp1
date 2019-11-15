package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;

    public interface ListHasItemRepository extends CrudRepository<ListHasItem, Long> {

        Iterable<ListHasItem> findAll();


    }

