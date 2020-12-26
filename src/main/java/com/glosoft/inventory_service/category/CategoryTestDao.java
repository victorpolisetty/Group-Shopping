package com.glosoft.inventory_service.category;

import com.glosoft.inventory_service.IDao;
import com.glosoft.inventory_service.item.Item;

import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

//import javax.swing.ImageIcon;

public class CategoryTestDao implements IDao<Category> {

    private List<Category> testCategories = new ArrayList<>();

    public CategoryTestDao()  {
        BufferedImage clothingImg, sportingImg, textBookImg, miscIconImg = null;
 //       try {
            //URL url = this.getClass().getClassLoader().getResource("static/clothingIcon.png");
            //if (url != null)
//            clothingImg = ImageIO.read(this.getClass().getClassLoader().getResource("static/clothingIcon.png"));
//
//            sportingImg = ImageIO.read(this.getClass().getClassLoader().getResource("static/sportsIcon.png"));
//            textBookImg = ImageIO.read(this.getClass().getClassLoader().getResource("static/textbookIcon.png"));
          //  Resource resource =
            //        new ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg");
          //     BufferedImage clothingImg = ImageIO.read(getClass().getClassLoader().getResource("/resources/static/clothingIcon.png"));

            testCategories.add(new Category(1L, "Clothing",  "Men's, womens, and children clothing",
                    encodeToString("static/clothingIcon.png")));
            testCategories.add(new Category(2L, "Sporting",  "Sporting Goods",
                    encodeToString("static/sportsIcon.png")));
            testCategories.add(new Category(3L, "Text Books",  "Text books and other reading material",
                    encodeToString("static/textbookIcon.png")));
            testCategories.add(new Category(4L, "Misc.",  "Any misceallaneous",
                    encodeToString("static/thumbnail_miscIcon.png")));

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    String encodeToString(String fileName) {
        String imageBytesOutput = null;
        byte[] imageType =  "data:image/png;base64,".getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResource(fileName));
            ImageIO.write(image, "png", bos);
            bos.flush();
            byte[] imageBytes = bos.toByteArray();
            imageBytesOutput = Base64.getEncoder().encodeToString(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageBytesOutput;
//        return ByteBuffer.allocate(imageType.length + imageString.length)
//                .put(imageType)
//                .put(imageString)
//                .array();
    }
    @Override
    public Optional<Category> get(long id) {
        return Optional.ofNullable(testCategories.stream().filter(itm -> id == itm.getId()).findAny().orElse(null));
    }

    @Override
    public List<Category> getAll() {
        return testCategories;
    }

    @Override
    public void save(Category Item) {
        testCategories.add(Item);
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
