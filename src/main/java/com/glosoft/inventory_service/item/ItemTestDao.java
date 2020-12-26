package com.glosoft.inventory_service.item;

import com.glosoft.inventory_service.IDao;

import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;





public class ItemTestDao implements IDao<Item> {
    
    private List<Item> items = new ArrayList<>();

    public ItemTestDao() {
        items.add(new Item(1, "Black Suit",  "I am selling this black suit. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images.unsplash.com/photo-1497339100210-9e87df79c218?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80","15"));
        items.add(new Item(1, "White Shirt",  "I am selling this white shirt. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1400&q=80","21"));
        items.add(new Item(1, "Women Jeans",  "I am selling this womans jeans. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images.unsplash.com/photo-1590902939083-c5b8c7c4fbfe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=934&q=80","35"));
        items.add(new Item(1, "Black Jacket",  "I am selling this black jacket. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images.unsplash.com/photo-1551028719-00167b16eac5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80","72"));
        items.add(new Item(3, "AP Spanish Literature",  "I am selling this textbook. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://www.teachersdiscovery.com/images/uploads/26290_78270_large.jpg","15"));
        items.add(new Item(3, "AP Calculus AB",  "I am selling this textbook. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images-na.ssl-images-amazon.com/images/I/51-SgNFUv5L._SX382_BO1,204,203,200_.jpg","21"));
        items.add(new Item(3, "AP Physics 1",  "I am selling this textbook. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://images-na.ssl-images-amazon.com/images/I/51NHXeXj0jL._SX383_BO1,204,203,200_.jpg","35"));
        items.add(new Item(2, "Lacrosse Goal",  "I am selling this sporting item. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://www.garedsports.com/sites/default/files/import/files/LG100%2520pic_MAIN.JPG","72"));
        items.add(new Item(2, "Football Gloves",  "I am selling this sporting item. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://i.ebayimg.com/images/g/~tUAAOSw8G1eBnK4/s-l640.jpg","72"));
        items.add(new Item(4, "Gaming Mouse",  "I am selling this gaming mouse. My name is Victor Polisetty, and I am up to negotiation :). The lowest I will go is $15. Please feel free to contact me at 9046513819", "https://i.pcmag.com/imagery/reviews/01NlLQzm8PSNlDYAGHYFL8D-1..v_1575422627.jpg","72"));







    }

    @Override
    public Optional<Item> get(long id) {
      return Optional.ofNullable(items.stream().filter(itm -> id == itm.getId()).findAny().orElse(null));
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void save(Item Item) {
        items.add(Item);
    }

 /*   //TODO
 @Override
    public void update(Item Item, String[] params) {
        Item.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        Item.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));

        Items.add(Item);
    }

    @Override
    public void delete(Item Item) {
        Items.remove(Item);
    }

  */
}
