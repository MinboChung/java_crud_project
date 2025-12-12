package com.example.crud.service;

import com.example.crud.model.Item;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ItemService {
 private List<Item> items=new ArrayList<>();
 private int nextId=1;

 public Item create(String title){
  Item item=new Item(nextId++,title);
  items.add(item);
  return item;
 }

 public List<Item> readAll(){ return items; }

 public Item update(int id,String newTitle){
  for(Item item:items){
   if(item.getId()==id){
    item.setTitle(newTitle);
    return item;
   }
  }
  return null;
 }

 public boolean delete(int id){
  return items.removeIf(i->i.getId()==id);
 }
}
