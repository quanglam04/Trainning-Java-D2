package com.example.EX_23.spec;

import org.springframework.data.jpa.domain.Specification;

import com.example.EX_23.entity.Product;

import jakarta.persistence.criteria.*;

public class ProductSpecification {
    
	public static Specification<Product> hasName(String name) {
	    return (root, query, builder) -> 
	        name == null ? null : builder.equal(root.get("name"), name);
	}


	public static Specification<Product> hasCategory(String category) {
	    return (root, query, builder) -> 
	        category == null ? null : builder.equal(root.get("category"), category);
	}


}
