package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.entity.Item;
import com.product.repository.ItemRepository;

@Service
public class ItemService {
@Autowired
private ItemRepository itemRepository;
public ItemService(ItemRepository itemRepository) {
	this.itemRepository=itemRepository;
	}

public List<Item> all() {
  return itemRepository.findAll();
}

public Item getById(Long id) {

  return itemRepository.findById(id).get();
}


public Item createNew(Item newItem) {
  return itemRepository.save(newItem);
}

public void delete(Long id) {
  itemRepository.deleteById(id);
}

public Item updateOrCreate(Item newItem,  Long id) {

  return itemRepository.findById(id)
      .map(item -> {
        item.setName(newItem.getName());
        return itemRepository.save(item);
      })
      .orElseGet(() -> {
        newItem.setId(id);
        return itemRepository.save(newItem);
      });
}
}
