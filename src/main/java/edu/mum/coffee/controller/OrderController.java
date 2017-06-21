package edu.mum.coffee.controller;

import java.util.List;

import edu.mum.coffee.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public void createOrder(@RequestBody Order order){
	   orderService.save(order);	
	}
	
	@GetMapping("/order")
	public List<Order> getAllOrder(){
		return orderService.findAll();
	}  

	@GetMapping("/order/{id}")
	public Order getById(@PathVariable("id") int id){
		return orderService.findById(id);
	}

	@GetMapping("/person")
	public List<Order> getByPerson(@RequestParam("id") long id){
		//return orderService.findByPerson(new Person(id));
		return null;
	}
	
	@DeleteMapping("/order/{id}")
	public void delete(@PathVariable("id") int id){
		orderService.delete(orderService.findById(id));
	}

}
