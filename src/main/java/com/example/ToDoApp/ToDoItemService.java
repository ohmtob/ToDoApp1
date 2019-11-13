package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service("ToDoItemService")
public class ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoItem saveToDoItem(ToDoItem item) {
        return toDoItemRepository.save(item);
    }

    public ToDoItem changeDoneStateForToDoItem(Long id) {
        ToDoItem item = toDoItemRepository.findByItemId(id);
        if (item != null) {
            item.setCompleted(!item.getCompleted());
            toDoItemRepository.save(item);
            return item;
        }
        return null;
    }

    public Boolean deleteToDoItem(Long id) {
        ToDoItem item = toDoItemRepository.findById(id).orElse(null);
        if (item != null) {
            toDoItemRepository.delete(item);
            return true;
        }
        return false;
    }

    public ToDoItem editToDoItem(ToDoItem editedItem)
    {
        ToDoItem item = toDoItemRepository.findById(editedItem.getId()).orElse(null);
        if (item != null) {
            item.setActivity(editedItem.getActivity());
            return toDoItemRepository.save(item);
        }
        //Create new if we dont have.
        return toDoItemRepository.save(item);
    }

    public List<ToDoItem> getAllToDoItemsForListId(UUID listId) {
        return toDoItemRepository.findByListId(listId);
    }

    public ToDoItem getItem(Long id)
    {
        return toDoItemRepository.findByItemId(id);
    }


}