package repository;

import dto.CustomerRequestDto;
import dto.OrderRequestDto;
import dto.OrderResponseDto;
import factory.model.Product;
import factory.repository.BaseRepository;
import model.Order;

import java.util.List;

public interface OrderRepository extends BaseRepository {
    Order save(CustomerRequestDto customerRequestDto);
    List<OrderResponseDto> getAll();
    void controlIsThereOrderCode(String orderCode);
    OrderResponseDto getOrderResponseDto(Order order);
    Order getOrderByOrderRequestDto(OrderRequestDto orderRequestDtoForGet);
    Order getOrderByCustomerEmail(String email);
    OrderRequestDto getOrderRequestDtoWithCustomerRequestDto(Order order, CustomerRequestDto customerRequestDto);
    void changeProductStockInfo(List<Product> productList);
}
