package com.example.ToDoApp;

import org.springframework.data.repository.CrudRepository;

public interface UserHasListRepository extends CrudRepository<UserHasList, Long> {

    Iterable<UserHasList> findAll();


}
