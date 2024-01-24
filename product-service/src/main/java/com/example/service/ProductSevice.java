package com.example.service;

import com.example.model.Product;
import java.util.List;

public interface ProductSevice {
    Product saveProduct(Product product);
    List<Product> getProducts();

    Product getProductById(int id);

    String deleteProduct(int id);

    List<Product> getByKeyword(String keyword);


}
