package com.example.EX_23.controller;

import com.example.EX_23.entity.Product;
import com.example.EX_23.repository.ProductRepository;
import com.example.EX_23.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public List<Product> searchProductsWithSpec(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
    	System.out.println(name+"   "+category);
    	List<Product> list = productService.searchProductsWithNameAndCategory(name, category);
    	System.out.println(list.size());
        return productService.searchProductsWithNameAndCategory(name, category);
    }
    
    @GetMapping("/search-no-spec")
    public ResponseEntity<Product> findAll(){
    	List<Product> list = productService.findAll();
    	for(Product product : list) {
    		System.out.println(product.toString());
    	}
    	Product result = list.get(0);
    	System.out.println("Trả về cho FE: "+result);
    	return ResponseEntity.ok().body(result);
    }
    
    
    
    @GetMapping("/hello")
    public ResponseEntity<String> getHello(){
    	return ResponseEntity.ok().body("Hello");
    }
}
