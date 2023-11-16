package com.product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService { 
	@Autowired
	private  ProductRepository productRepository; 

	public ProductService( 
		ProductRepository productRepository) 
	{ 
		this.productRepository = productRepository; 
	} 
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) 
	{ 
		Product newProduct = productRepository.save(product); 
		return ResponseEntity.ok(newProduct); 
	}
	// Get all products 
	public List<Product>  getAllProducts() 
	{ 
		return productRepository.findAll(); 
	}
	// Get a product by ID 
	public ResponseEntity<Product>  
	fetchProductById(Long id) 
	{ 
		Optional<Product> product 
			= productRepository.findById(id); 
		if (product.isPresent()) { 
			return ResponseEntity.ok().body(product.get()); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	}
	public ResponseEntity<Product> updateProduct(Long id, Product updatedProduct) 
	{ 
		if (id == null) { 
			throw new IllegalArgumentException( 
				"ID cannot be null"); 
		} 
		Product Existingproduct 
			= productRepository.findById(id).orElseThrow( 
				() 
					-> new EntityNotFoundException( 
						String.valueOf(id))); 
		Existingproduct.setName(updatedProduct.getName()); 
		Existingproduct.setPrice(updatedProduct.getPrice()); 
		Existingproduct.setQuantity( 
			updatedProduct.getQuantity()); 
		Product savedEntity 
			= productRepository.save(Existingproduct); 
		return ResponseEntity.ok(savedEntity); 
	}
	public ResponseEntity<String> deleteProduct(Long id) 
	{ 
		productRepository.deleteById(id); 
		return ResponseEntity.ok( 
			"Product Deleted Successfully"); 
	}



}
