package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("ToDoListService")
class ToDoListService {

    @Autowired
        private ToDoListRepository toDoListRepository;

        ToDoList saveToDoList(ToDoList list) {
            return toDoListRepository.save(list);
        }


        Boolean deleteToDoList(Long id) {
            ToDoList list = toDoListRepository.findById(id).orElse(null);
            if (list != null) {
                toDoListRepository.delete(list);
                return true;
            }
            return false;
        }

        ToDoList editToDoList(ToDoList editedList)
        {
            ToDoList list = toDoListRepository.findById(editedList.getId()).orElse(null);
            if (list != null) {
                list.setName(editedList.getName());
                return toDoListRepository.save(list);
            }
            //Create new if we dont have.
            return toDoListRepository.save(list);
        }

        List<ToDoList> getAllToDoListForListId(UUID id) {
            return toDoListRepository.findById(id);
        }

        Optional<ToDoList> getToDoList(Long id)
        {
            return toDoListRepository.findById(id);
        }


    }

