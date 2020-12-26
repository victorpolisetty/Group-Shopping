package com.glosoft.inventory_service.item;

//import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class Items {
    private ItemTestDao item;

    public Items() {
        item = new ItemTestDao();
    }

    public List<Item> getItemList() {
        return item.getAll();
    }

    public Optional<Item> getItem(long id) {
        return item.get(id);
    }


    public List<Item> getItemsByCategory(Long categoryId) {
        List<Item> allItems = item.getAll();
        List<Item> categoryItems = allItems.stream().filter(itm -> categoryId == itm.getCategoryId()).collect(Collectors.toList());
        return categoryItems;

        //return item.getAll().stream().filter(itm -> categoryId == itm.getCategoryId()).collect(Collectors.toList());
    }

}
