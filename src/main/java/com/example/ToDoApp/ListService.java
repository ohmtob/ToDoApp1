package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ListService")
class ListService {

    @Autowired
        private static ListRepository listRepository;

    ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public static List saveList(List toDoList) {
            return listRepository.save(toDoList);
        }


        static Boolean deleteList(Long id) {
            List toDoList = listRepository.findById(id).orElse(null);
            if (toDoList != null) {
                listRepository.delete(toDoList);
                return true;
            }
            return false;
        }

        static List editList(List editedList)
        {
            List toDoList = listRepository.findById( Long.valueOf( editedList.getId() ) ).orElse(null);
            if (toDoList != null) {
                toDoList.setName(editedList.getName());
                return listRepository.save(toDoList);
            }
            //Create new if we don't have.
            return listRepository.save(toDoList);
        }

        List getAllToDoListForListId(User id) {
            return listRepository.findById(id);
        }

        List getList(Long id)
        {
            return listRepository.findByListId(id);
        }

    }

