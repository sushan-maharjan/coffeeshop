package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trauma_sushan on 6/22/2017.
 */
@Controller
public class AdminController {

    @Autowired
    PersonService personService;
    @Autowired
    ProductService productService;

    @RequestMapping("/personList")
    public String listPerson(){
        return "person";
    }

    @RequestMapping("/addPerson")
    public String addPerson(){
        return "registration";
    }

    @PostMapping("/createPerson")
    public String createPerson(Person person){
        personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("listOrder")
    public String listOrder(){
        return "orderList";
    }

    @GetMapping("/product-list")
    public String getProductList(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "productList";
    }

    @GetMapping("/addProduct")
    public String createProduct(Model model){
        model.addAttribute("productTypes", ProductType.values());
        return "addProduct";
    }

    @GetMapping("/productDetail/{id}")
    public String getProduct(@PathVariable int id, Model model){
        model.addAttribute("product", productService.getProduct(id));
        return "productDetail";
    }

    @PostMapping("/createProduct")
    @PutMapping("/createProduct")
    public String addProduct(Product product){
        productService.save(product);
        return "redirect:/home";
    }

    @PutMapping("/updateProduct")
    public String updateProduct(Product product){
        productService.save(product);
        return "redirect:/product-list";
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.delete(productService.getProduct(id));
        return "redirect:/product-list";
    }
}
