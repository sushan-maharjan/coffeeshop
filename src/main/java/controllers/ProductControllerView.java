/*package controllers;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductControllerView {

    @Autowired
    ProductService productService;*/

   /* @GetMapping("/product-list")
    public String getProductList(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "productList";
    }

    @GetMapping("/addProduct")
    public String createProduct(){
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
        return "redirect:/product-list";
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
    }*/
//}
