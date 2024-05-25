package service;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import model.enums.AccountType;

import java.util.List;

public interface CustomerService {
    void save(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAll();
    void changeAccountType(String email, AccountType accountType);
}
