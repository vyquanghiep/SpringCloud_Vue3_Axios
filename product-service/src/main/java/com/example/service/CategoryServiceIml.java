package com.example.service;

import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIml implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoríes() {
        return categoryRepository.findAll();
    }
    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));

    }
    @Override
    public String deleteCategory(int id) {
        categoryRepository.deleteById(id);
        return "Danh muc remove ||" + id;
    }


    @Override
    public List<Product> getProductsByIdCategory(int id) {
        return productRepository.findByCategory_Id(id);
    }

    @Override
    public void deleteCategoryAndProducts(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {

            List<Product> products = getProductsByIdCategory(id);

            productRepository.deleteAll(products);

            categoryRepository.delete(category);
        }
    }
}
