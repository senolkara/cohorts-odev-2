package repository;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import factory.repository.BaseRepository;
import model.Customer;
import model.User;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends BaseRepository {
    void save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAll();
    Optional<CustomerResponseDto> getByEmail(String email);
    User getUserByEmail(String email);
    Customer getCustomerByEmail(String email);
}
