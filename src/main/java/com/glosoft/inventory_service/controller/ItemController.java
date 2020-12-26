package com.glosoft.inventory_service.controller;

import com.glosoft.inventory_service.item.Item;
import com.glosoft.inventory_service.item.Items;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController

public class ItemController {

    private Items items = new Items();
   // private Item item = new Item();


    @GetMapping("/items")
    public  List<Item> itemList() {
        List<Item> il = items.getItemList();
        return il;
    }

    @GetMapping("/item/{id}")
    public Optional<Item> item(@PathVariable long id) {
        Optional<Item> it = items.getItem(id);
        if (null == Optional.ofNullable(it))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Item with id = %d not found", id));
        return it;
    }
    @GetMapping("/item/categoryid")
    public List<Item> item(@RequestParam (name = "id", required = true, defaultValue = "1") Long id ) {
        List<Item> it = items.getItemsByCategory(id);
        if (null == Optional.ofNullable(it))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Item with id = %d not found", id));
        return it;
    }
}