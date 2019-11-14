package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("ToDoListService")
class ListService {

    @Autowired
        private ListRepository listRepository;

    ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    List saveToDoList(List list) {
            return listRepository.save(list);
        }


        Boolean deleteToDoList(Long id) {
            List list = listRepository.findById(id).orElse(null);
            if (list != null) {
                listRepository.delete(list);
                return true;
            }
            return false;
        }

        List editToDoList(List editedList)
        {
            List list = listRepository.findById( Long.valueOf( editedList.getId() ) ).orElse(null);
            if (list != null) {
                list.setName(editedList.getName());
                return listRepository.save(list);
            }
            //Create new if we don't have.
            return listRepository.save(list);
        }

        java.util.List getAllToDoListForListId(UUID id) {
            return listRepository.findById(id);
        }

        List getToDoList(Long id)
        {
            return listRepository.findById(id);
        }


    }

