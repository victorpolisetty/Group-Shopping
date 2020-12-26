package com.glosoft.inventory_service.controller;

import com.glosoft.inventory_service.category.Category;
import com.glosoft.inventory_service.category.Categories;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController

public class CategoryController {

    private Categories categories = new Categories();



 @GetMapping("/categories")
    public  List<Category> categoryList()  {
        List<Category> cl = categories.getCategoryList();
        return cl;
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> category(@PathVariable Long id) {
        Optional<Category> category = categories.getCategory(id);
        if (null == Optional.ofNullable(category))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Category with id = %d not found", id));
        return category;

    }
}
