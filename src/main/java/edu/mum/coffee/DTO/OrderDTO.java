package edu.mum.coffee.DTO;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * Created by trauma_sushan on 6/21/2017.
 */
@Component
public class OrderDTO {

    public OrderDTO(){}

    @Autowired
    PersonService personService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    private long person_id;
    private Date orderDate;

    public List<OrderlineDTO> getOrderlineDTOList() {
        return orderlineDTOList;
    }

    public void setOrderlineDTOList(List<OrderlineDTO> orderlineDTOList) {
        this.orderlineDTOList = orderlineDTOList;
    }

    List<OrderlineDTO> orderlineDTOList;

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
