package com.example.frontendservice.controller;

import com.example.frontendservice.client.ProductClient;
import com.example.frontendservice.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/front")
public class ProductController {
    @Autowired
     private ProductClient productClient;

    @GetMapping("/showProduct")
    public String ShowProduct(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<ProductDto> listProducts = productClient.findProductByKeyword(keyword);
            model.addAttribute("listProducts", listProducts);
        }else {
            List<ProductDto> listProducts = productClient.findAllProduct();
            model.addAttribute("listProducts", listProducts);
        }
        return "Product";
    }
    @GetMapping("/addProduct")
    public String AddProduct(Model model){
        ProductDto product = new ProductDto();
        model.addAttribute("product",product);
        return "AddProduct";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") ProductDto productDto) {
        productClient.saveProduct(productDto);
        return "redirect:/front/showProduct";
    }
    @GetMapping("/editProduct/{id}")
    public String updateProduct(@PathVariable (value = "id") int id, Model model){
        ProductDto product = productClient.findProductById(id);;
        model.addAttribute("product",product);
        return "AddProduct";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") int id){
        productClient.DeleteProduct(id);
        return "redirect:/front/showProduct";
    }
}
