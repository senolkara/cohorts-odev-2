package repository;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;

import java.util.List;

public interface CustomerRepository {
    void save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAll();
}
