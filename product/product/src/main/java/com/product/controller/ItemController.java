package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.Service.ItemService;
import com.product.entity.Item;
import com.product.repository.ItemRepository;

@RestController
public class ItemController {

  @Autowired
  ItemService itemService;

  @GetMapping("/items")
  List<Item> all() {
    return itemService.all();
  }

  @GetMapping("/items/{id}")
  Item getById(@PathVariable Long id) {

    return itemService.getById(id);
  }

  @PostMapping("/items")
  Item createNew(@RequestBody Item newItem) {
    return itemService.createNew(newItem);
  }

  @DeleteMapping("/items/{id}")
  void delete(@PathVariable Long id) {
	  itemService.delete(id);
  }

  @PutMapping("/items/{id}")
  Item updateOrCreate(@RequestBody Item newItem, @PathVariable Long id) {

    return itemService.updateOrCreate(newItem, id);
  }
}