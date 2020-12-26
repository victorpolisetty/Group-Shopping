package com.glosoft.inventory_service.category;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Component
public class Categories {

        private CategoryTestDao category;

        public Categories()  {
            category = new CategoryTestDao();
        }

        public List<Category> getCategoryList() {
            return category.getAll();
        }

        public Optional<Category> getCategory(long id) {
            return category.get(id);
        }
}
