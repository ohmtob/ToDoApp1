package com.example.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ToDoItemService")
class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    Item saveToDoItem(Item item) {
        return itemRepository.save(item);
    }

    Item completeToDoItem(Long id) {
        Item item = itemRepository.findByItemId(id);
        if (item != null) {
            item.setCompleted(!item.getCompleted());
            itemRepository.save(item);
            return item;
        }
        return null;
    }

    Boolean deleteToDoItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            itemRepository.delete(item);
            return true;
        }
        return false;
    }

    Item editToDoItem(Item editedItem)
    {
        Item item = itemRepository.findById(editedItem.getId()).orElse(null);
        if (item != null) {
            item.setActivity(editedItem.getActivity());
            return itemRepository.save(item);
        }
        //Create new if we don't have.
        return itemRepository.save(item);
    }

    List<Item> getAllToDoItemsForListId(User listId) {
        return itemRepository.findByListId(listId);
    }

    Item getItem(Long id)
    {
        return itemRepository.findByItemId(id);
    }


}