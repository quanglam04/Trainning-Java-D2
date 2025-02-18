package com.example.EX_23.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.EX_23.entity.Product;
import com.example.EX_23.repository.ProductRepository;
import com.example.EX_23.spec.ProductSpecification;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProductsWithNameAndCategory(String name, String category) {
    	System.out.println("name = "+name+"   category "+category);
        Specification<Product> spec = Specification.where(ProductSpecification.hasName(name))
                .and(ProductSpecification.hasCategory(category));
        
 

        return productRepository.findAll(spec);
    }
    
    public List<Product> findAll(){
    	return productRepository.findAll();
    }
    
}
