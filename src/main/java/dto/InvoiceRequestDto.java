package dto;

import java.math.BigDecimal;

public class InvoiceRequestDto {
    private BigDecimal totalPrice;
    private OrderRequestDto orderRequestDto;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderRequestDto getOrderRequestDto() {
        return orderRequestDto;
    }

    public void setOrderRequestDto(OrderRequestDto orderRequestDto) {
        this.orderRequestDto = orderRequestDto;
    }
}
