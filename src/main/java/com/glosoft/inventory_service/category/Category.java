package com.glosoft.inventory_service.category;


// import java.awt.image.BufferedImage;
// import java.util.concurrent.atomic.AtomicLong;

public class Category {

    private final long id;
    private final String name;
    private final String description;
    private final String image;

    //private final byte[] image;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }



  //  private static final AtomicLong nextCatId = new AtomicLong();

    public Category(Long id, String name, String description, String image) {
        this.id = id; // nextCatId.incrementAndGet();
        this.name = name;
        this.description = description;
        this.image = image;
    }


    // public String getContent() {return content;}
}