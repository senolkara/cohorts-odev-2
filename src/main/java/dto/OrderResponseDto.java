package dto;

import model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private LocalDateTime createDateTime;
    private List<ProductResponseDto> productResponseDtoList;
    private String orderCode;
    private OrderStatus orderStatus;
    private CustomerResponseDto customerResponseDto;

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<ProductResponseDto> getProductResponseDtoList() {
        return productResponseDtoList;
    }

    public void setProductResponseDtoList(List<ProductResponseDto> productResponseDtoList) {
        this.productResponseDtoList = productResponseDtoList;
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

    public CustomerResponseDto getCustomerResponseDto() {
        return customerResponseDto;
    }

    public void setCustomerResponseDto(CustomerResponseDto customerResponseDto) {
        this.customerResponseDto = customerResponseDto;
    }
}
