package com.data.session11.service.Bai8;

import com.data.session11.model.Bai8.Category;

import java.util.List;

public interface CategoryService {
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(int id);
    List<Category> getAllCategory();
    Category findById(int id);
    boolean isCategoryNameExists(String categoryName);
}
