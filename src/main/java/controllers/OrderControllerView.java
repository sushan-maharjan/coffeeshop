package controllers;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by trauma_sushan on 6/18/2017.
 */
@Controller
public class OrderControllerView {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String getOrderList(Model model){
        model.addAttribute("orders", orderService.findAll());
        return "orderList";
    }

    @GetMapping("/order/new")
    public String addOrder(){
        return "addOrder";
    }

    @PostMapping("/order")
    public String addOrder(Order order){
        orderService.save(order);
        return "redirect:/order";
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable int id){
        orderService.delete(orderService.findById(id));
        return "redirect:/order";
    }
}
