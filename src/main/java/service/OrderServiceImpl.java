package service;

import dto.CustomerRequestDto;
import dto.OrderResponseDto;
import factory.repository.OrderRepositoryFactory;
import model.enums.RepositoryType;
import repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepositoryFactory orderRepositoryFactory = new OrderRepositoryFactory();
    private OrderRepository orderRepository = orderRepositoryFactory.getBaseRepository(RepositoryType.ORDER);

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        orderRepository.save(customerRequestDto);
        System.out.println("order saved");
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return orderRepository.getAll();
    }

}
