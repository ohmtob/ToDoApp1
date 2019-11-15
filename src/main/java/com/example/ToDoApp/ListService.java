package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ToDoListService")
class ListService {

    @Autowired
        private static ListRepository listRepository;

    ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    static List saveList(List list) {
            return listRepository.save(list);
        }


        static Boolean deleteList(Long id) {
            List list = listRepository.findById(id).orElse(null);
            if (list != null) {
                listRepository.delete(list);
                return true;
            }
            return false;
        }

        static List editList(List editedList)
        {
            List list = listRepository.findById( Long.valueOf( editedList.getId() ) ).orElse(null);
            if (list != null) {
                list.setName(editedList.getName());
                return listRepository.save(list);
            }
            //Create new if we don't have.
            return listRepository.save(list);
        }

        List getAllToDoListForListId(User id) {
            return listRepository.findById(id);
        }

        List getList(Long id)
        {
            return listRepository.findByListId(id);
        }

    }

