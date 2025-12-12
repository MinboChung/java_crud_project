package com.example.crud.controller;

import com.example.crud.model.Item;
import com.example.crud.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemController {
 private final ItemService service;
 public ItemController(ItemService service){this.service=service;}

 @PostMapping
 public Item create(@RequestBody Item item){
  return service.create(item.getTitle());
 }

 @GetMapping
 public List<Item> read(){
  return service.readAll();
 }

 @PutMapping("/{id}")
 public Item update(@PathVariable int id,@RequestBody Item item){
  return service.update(id,item.getTitle());
 }

 @DeleteMapping("/{id}")
 public String delete(@PathVariable int id){
  return service.delete(id)?"Deleted":"Not found";
 }
}
