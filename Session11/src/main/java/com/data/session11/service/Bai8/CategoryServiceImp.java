package com.data.session11.service.Bai8;

import com.data.session11.dao.Bai8.CategoryDao;
import com.data.session11.model.Bai8.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean addCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean isCategoryNameExists(String categoryName) {
        return categoryDao.isCategoryNameExists(categoryName);
    }
}
