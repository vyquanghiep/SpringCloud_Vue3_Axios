package com.example.service;

import com.example.model.Category;
import com.example.model.Product;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category Category);

    List<Category> getCategoríes();

    Category getCategoryById(int id);

    String deleteCategory(int id);

    List<Product> getProductsByIdCategory(int id);
    void deleteCategoryAndProducts(int id);
}
