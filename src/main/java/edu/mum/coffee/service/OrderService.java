package edu.mum.coffee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.mum.coffee.DTO.OrderDTO;
import edu.mum.coffee.DTO.OrderlineDTO;
import edu.mum.coffee.domain.Orderline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PersonService personService;
	@Autowired
	private  ProductService productService;
	
	public Order save(OrderDTO order){
		Order order1 = new Order();
		order1.setOrderLines(new ArrayList<>());
		order1.setOrderDate(order.getOrderDate());
		order1.setPerson(personService.findById(order.getPerson_id()));

		List<OrderlineDTO> orderLines = order.getOrderlineDTOList();
		for(OrderlineDTO orderLine : orderLines){
			Orderline ord = new Orderline();
			ord.setQuantity(orderLine.getQuantity());
			ord.setProduct(productService.getProduct(orderLine.getProduct_id()));
			order1.addOrderLine(ord);
		}
		return orderRepository.save(order1);
	}
	
	public void delete(Order order){
		orderRepository.delete(order);
	}
	
	public List<Order> findByProduct(Product product) {
		return orderRepository.findDistinctOrderByOrderLines_Product(product);
	}
	
	public List<Order> findByPerson(Person person) {
		return orderRepository.findOrderByPerson(person);
	}

	public List<Order> findByDate(Date minDate, Date maxDate) {
		return orderRepository.findOrderByOrderDateBetween(minDate, maxDate);
	}

	public Order findById(int id){
		return orderRepository.findOne(id);
	}

	public List<Order> findAll(){
		return orderRepository.findAll();
	}

}
