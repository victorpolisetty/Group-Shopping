package com.glosoft.circleshopper.controller;

import com.glosoft.circleshopper.exception.ResourceNotFoundException;
import com.glosoft.circleshopper.model.Item;
import com.glosoft.circleshopper.repository.ItemRepository;
import com.glosoft.circleshopper.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories/{categoryId}/items")
    public Page<Item> getAllItemsByCategoryId(@PathVariable (value = "categoryId") Long categoryId,
                                                            Pageable pageable) {
        return itemRepository.findByCategoryId(categoryId, pageable);
    }

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(@PathVariable (value = "categoryId") Long categoryId,
                                          @Valid @RequestBody Item item) {
        return categoryRepository.findById(categoryId).map(category -> {
            item.setCategory(category);
            return itemRepository.save(item);
        }).orElseThrow(() -> new ResourceNotFoundException("CategoryId " + categoryId + " not found"));
    }

    @PutMapping("/categories/{categoryId}/items/{itemId}")
    public Item updateItem(@PathVariable (value = "categoryId") Long categoryId,
                                         @PathVariable (value = "itemId") Long itemId,
                                         @Valid @RequestBody Item itemRequest) {
        if(!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("CategoryId " + categoryId + " not found");
        }

        return itemRepository.findById(itemId).map(itm -> {
            itm.setCategory(itemRequest.getCategory());
            itm.setDescription(itemRequest.getDescription());
            itm.setImageURL(itemRequest.getImageURL());
            itm.setName(itemRequest.getName());
            itm.setPrice(itemRequest.getPrice());
            return itemRepository.save(itm);
        }).orElseThrow(() -> new ResourceNotFoundException("ItemId " + itemId + "not found"));
    }

    @DeleteMapping("/categories/{categoryId}/items/{itemId}")
    public ResponseEntity<?> deleteFavorite(@PathVariable (value = "categoryId") Long categoryId,
                                            @PathVariable (value = "itemId") Long itemId) {
        return itemRepository.findByIdAndCategoryId(itemId, categoryId).map(comment -> {
            itemRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + itemId + " and postId " + categoryId));
    }
}
