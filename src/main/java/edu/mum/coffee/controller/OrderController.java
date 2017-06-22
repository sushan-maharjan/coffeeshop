package edu.mum.coffee.controller;

import java.util.List;

import edu.mum.coffee.DTO.OrderDTO;
import edu.mum.coffee.DTO.OrderlineDTO;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	PersonService personService;
	@Autowired
	ProductService productService;

	
	/*@PostMapping("/order")
	public void createOrder(@RequestBody OrderDTO orderDTO){
		Order order = new Order();
		order.setOrderDate(orderDTO.getOrderDate());
		System.out.println("orderDTO"+this);
		System.out.println("person_id"+orderDTO.getPerson_id());
		Person person = personService.findById(orderDTO.getPerson_id());
		System.out.println("person "+person);
		order.setPerson(personService.findById(orderDTO.getPerson_id()));


		if(orderDTO.getOrderlineDTOList()!=null){
			for(OrderlineDTO orderlineDTO : orderDTO.getOrderlineDTOList()){
				Orderline orderline = new Orderline();
				orderline.setQuantity(orderlineDTO.getQuantity());
				orderline.setProduct(productService.getProduct(orderlineDTO.getProduct_id()));
				orderline.setOrder(orderService.findById(orderlineDTO.getOrder_id()));
				order.addOrderLine(orderline);
			}
		}
		orderService.save(order);
	}*/
	@PostMapping("/order")
	public void saveOrder(@RequestBody OrderDTO orderDTO){
		Order order = orderService.save(orderDTO);
	}
	
	@GetMapping("/order")
	public List<Order> getAllOrder(){
		return orderService.findAll();
	}  

	@GetMapping("/order/{id}")
	public Order getById(@PathVariable("id") int id){
		return orderService.findById(id);
	}

/*	@GetMapping("/person")
	public List<Order> getByPerson(@RequestParam("id") long id){
		//return orderService.findByPerson(new Person(id));
		return null;
	}*/
	
	@DeleteMapping("/order/{id}")
	public void delete(@PathVariable("id") int id){
		orderService.delete(orderService.findById(id));
	}

}
