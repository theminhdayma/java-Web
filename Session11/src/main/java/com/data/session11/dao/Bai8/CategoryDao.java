package com.data.session11.dao.Bai8;

import com.data.session11.model.Bai8.Category;

import java.util.List;

public interface CategoryDao {
    boolean save(Category category);
    boolean update(Category category);
    boolean delete(int id);
    List<Category> getAllCategory();
    Category findById(int id);
    boolean isCategoryNameExists(String categoryName);

}
