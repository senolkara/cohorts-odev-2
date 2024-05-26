package service;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import model.enums.AccountType;
import factory.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends BaseService {
    void save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAll();
    void changeAccountType(String email, AccountType accountType);
    Optional<CustomerResponseDto> getByEmail(String email);
}
