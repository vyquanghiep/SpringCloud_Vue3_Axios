package com.example.frontendservice.client;

import com.example.frontendservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping(value = "/product")
    List<ProductDto> findAllProduct();

    @PostMapping("/product/save")
    void saveProduct(ProductDto productDto);

    @GetMapping("/product/{id}")
    ProductDto findProductById(@PathVariable("id") Integer id);

    @DeleteMapping("/product/{id}")
    void DeleteProduct(@PathVariable("id") Integer id);

    @GetMapping("/product/byKeyword")
    List< ProductDto>  findProductByKeyword(@RequestParam("keyword") String keyword);
}
