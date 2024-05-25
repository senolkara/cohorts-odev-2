package service;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import model.Customer;
import model.enums.AccountType;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        customerRepository.save(customerRequestDto);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void changeAccountType(String email, AccountType accountType) {

//        Optional<Customer> foundCustomer = getAll()
//                .stream()
//                .filter(customer -> customer.getEmail().equals(email))
//                .findFirst();
//
//        if (foundCustomer.isPresent()) {
//            foundCustomer.get().setAccountType(accountType);
//        }
    }

    public void changeAccountTypeByCredit(String email, AccountType accountType) { //ödev

    }


}
