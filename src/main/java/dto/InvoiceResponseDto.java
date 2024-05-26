package dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceResponseDto {
    private BigDecimal totalPrice;
    private OrderResponseDto orderResponseDto;
    private LocalDateTime createDateTime;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderResponseDto getOrderResponseDto() {
        return orderResponseDto;
    }

    public void setOrderResponseDto(OrderResponseDto orderResponseDto) {
        this.orderResponseDto = orderResponseDto;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
