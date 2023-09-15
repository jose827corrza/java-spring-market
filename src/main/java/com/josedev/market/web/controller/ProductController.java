package com.josedev.market.web.controller;

import com.josedev.market.domain.Product;
import com.josedev.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Integer productId) {
        return  productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategoryId(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategoryId(categoryId);
    }

    public Product save(Product product) {
        return  productService.save(product);
    }

    public boolean deleteProduct(int productId) {
        return productService.delete(productId);
    }
}
