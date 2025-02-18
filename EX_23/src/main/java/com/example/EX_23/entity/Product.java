package com.example.EX_23.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String category;
    
    @Override
    public String toString() {
    	return id+" "+name +" "+category;
    }

    

	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getCategory() {
		return category;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}



	public void setCategory(String category) {
		this.category = category;
	}
    
    
 
}
