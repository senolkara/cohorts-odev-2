package dto;

import java.util.List;

public class OrderRequestDto {
    private List<ProductRequestDto> productRequestDtoList;
    private CustomerRequestDto customerRequestDto;

    public List<ProductRequestDto> getProductRequestDtoList() {
        return productRequestDtoList;
    }

    public void setProductRequestDtoList(List<ProductRequestDto> productRequestDtoList) {
        this.productRequestDtoList = productRequestDtoList;
    }

    public CustomerRequestDto getCustomerRequestDto() {
        return customerRequestDto;
    }

    public void setCustomerRequestDto(CustomerRequestDto customerRequestDto) {
        this.customerRequestDto = customerRequestDto;
    }
}
