package repository;

import dto.CustomerRequestDto;
import dto.OrderResponseDto;
import factory.repository.BaseRepository;

import java.util.List;

public interface OrderRepository extends BaseRepository {
    void save(CustomerRequestDto customerRequestDto);
    List<OrderResponseDto> getAll();
    void controlIsThereOrderCode(String orderCode);
}
