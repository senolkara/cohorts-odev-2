package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Invoice {
    private BigDecimal totalPrice;
    private Order order;
    private LocalDateTime createDateTime;

    public Invoice(BigDecimal totalPrice, Order order, LocalDateTime createDateTime) {
        this.totalPrice = totalPrice;
        this.order = order;
        this.createDateTime = createDateTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalPrice=" + totalPrice +
                ", order=" + order +
                ", createDateTime=" + createDateTime +
                '}';
    }
}
