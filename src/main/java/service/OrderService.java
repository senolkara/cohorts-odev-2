package service;

import dto.CustomerRequestDto;
import dto.OrderResponseDto;
import factory.service.BaseService;

import java.util.List;

public interface OrderService extends BaseService {
    void save(CustomerRequestDto customerRequestDto);
    List<OrderResponseDto> getAll();
}
