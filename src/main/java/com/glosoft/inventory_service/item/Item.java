package com.glosoft.inventory_service.item;

import java.util.concurrent.atomic.AtomicLong;

public class Item {

    private final long id;
    private final long categoryId;
    private final String name;
    private final String description;
    private final String imageURL;
    private final String price;

    public long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPrice() {
        return price;
    }


    private static final AtomicLong nextId = new AtomicLong();

    public Item(long categoryId, String name, String description, String imageURL, String price) {
        this.id = nextId.incrementAndGet();
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
    }


   // public String getContent() {return content;}
}