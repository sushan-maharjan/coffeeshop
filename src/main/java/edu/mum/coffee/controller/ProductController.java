package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@PostMapping("/product")
	public void create(@RequestBody Product product){
		productService.save(product);
	}
	
	@GetMapping("/product/{id}")
	public Product getById(@PathVariable("id") int id){
		return productService.getProduct(id);
	}
	
	@PutMapping("/product")
	public void update(@RequestBody Product product){
		productService.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable("id") int id){
		productService.delete(productService.getProduct(id));
	}


}
