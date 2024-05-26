package model;

import model.enums.OrderStatus;
import factory.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private LocalDateTime createDateTime;
    private List<Product> productList;
    private String orderCode;
    private OrderStatus orderStatus;
    private Customer customer;

    public Order(List<Product> productList, String orderCode, Customer customer) {
        this.createDateTime = LocalDateTime.now();
        this.productList = productList;
        this.orderCode = orderCode;
        this.customer = customer;
        this.orderStatus = OrderStatus.INITIAL;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDateTime=" + createDateTime +
                ", productList=" + productList +
                ", orderCode='" + orderCode + '\'' +
                ", orderStatus=" + orderStatus +
                ", customer=" + customer +
                '}';
    }
}
