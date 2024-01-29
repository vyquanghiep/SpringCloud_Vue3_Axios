package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ProductSeviceIml implements ProductSevice{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
    @Override
    public List<Product> getByKeyword(String keyword) {
        return productRepository.findByKeyword(keyword);
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Sản phẩm remove ||" + id;
    }

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public String uploadImage(int id,MultipartFile file) throws IOException {
        // Tạo đường dẫn lưu trữ ảnh
        String imageUrl = uploadDir +  "/" + id + "/" + UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Lưu ảnh vào thư mục lưu trữ
        Files.copy(file.getInputStream(), Paths.get(imageUrl), StandardCopyOption.REPLACE_EXISTING);

        return imageUrl;
    }
}
