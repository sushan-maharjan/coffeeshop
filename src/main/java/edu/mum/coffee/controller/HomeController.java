package edu.mum.coffee.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.mum.coffee.DTO.OrderDTO;
import edu.mum.coffee.DTO.OrderlineDTO;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	PersonService personService;
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model){
		model.addAttribute("products", productService.getAllProduct());
		return "home";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// Login form with error
	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	@GetMapping({"/register"})
	public String registration(){
		return "registration";
	}
	@PostMapping("/register")
	public String register(Person person, BindingResult result, Principal principal){
		if(!result.hasErrors()){
			personService.savePerson(person);
			if(principal!=null){
				return "redirect:/secure";
			}
			return "redirect:/login";
		}
		return "registration";
	}

	@PostMapping("/saveOrder")
	public String orderNow(@Valid OrderlineDTO orderLines, BindingResult result, Principal principal, RedirectAttributes redirectAttributes){
		Person person = personService.findByUserName(principal.getName());
		if(person != null){
			OrderDTO orderDto = new OrderDTO();
			orderDto.setPerson_id(person.getId());
			orderDto.setOrderDate(new Date());
			orderDto.setOrderlineDTOList(Collections.singletonList(orderLines));
			orderService.save(orderDto);
			redirectAttributes.addFlashAttribute("success","Your Order has been saved");
			return "redirect:/orderList";
		}
		redirectAttributes.addFlashAttribute("error","Error Saving order. Please try again later.");
		return "redirect:/home";
	}

	@GetMapping("/orderList")
	public String orderList(Model model, Principal principal){
		model.addAttribute("orders", orderService.findByPerson(personService.findByUserName(principal.getName())));
		return "orderList";
	}

	@GetMapping("/profile")
	public String viewProfile(Model model, Principal principal){
		Person personList = personService.findByUserName(principal.getName());
		model.addAttribute("user", personList);
		return "profile";
	}

	@PostMapping("/updateProfile")
	public String updateProfile(Person person){
		personService.savePerson(person);
		return "redirect:/home";
	}

}
