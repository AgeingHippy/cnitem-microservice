package com.ageinghippy.cnitem_microservice.service;

import com.ageinghippy.cnitem_microservice.exception.ItemNotFoundException;
import com.ageinghippy.cnitem_microservice.model.Item;
import com.ageinghippy.cnitem_microservice.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.orElse(null);
    }

    public Item insertNewItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Item updatedItem) throws ItemNotFoundException {
        Item item = itemRepository.findById(updatedItem.getItemId())
                .orElseThrow( ItemNotFoundException::new);
        BeanUtils.copyProperties(updatedItem,item);
        return itemRepository.save(item);
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
