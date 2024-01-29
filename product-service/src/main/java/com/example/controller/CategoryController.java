package com.example.controller;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @GetMapping("")
    public List<Category> findAllCategory() {
        return categoryService.getCategoríes();
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable("id") Integer id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/getpr/{id}")
    public List<Product>  findProductByCategory(@PathVariable("id") Integer id) {
        return categoryService.getProductsByIdCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategoryAndProducts(id);
    }
}
