package edu.mum.coffee.DTO;

/**
 * Created by trauma_sushan on 6/21/2017.
 */
public class OrderlineDTO {
    private int product_id;
    private int order_id;
    private int quantity;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
