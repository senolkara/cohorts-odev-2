package repository;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAll();
    Optional<CustomerResponseDto> getByEmail(String email);
}
