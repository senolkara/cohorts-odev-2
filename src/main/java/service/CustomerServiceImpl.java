package service;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import factory.repository.CustomerRepositoryFactory;
import model.enums.AccountType;
import model.enums.RepositoryType;
import repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepositoryFactory customerRepositoryFactory = new CustomerRepositoryFactory();
    private CustomerRepository customerRepository = customerRepositoryFactory.getBaseRepository(RepositoryType.CUSTOMER);

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        Optional<CustomerResponseDto> customerResponseDtoByEmail = getByEmail(customerRequestDto.getUserRequestDto().getEmail());
        if (customerResponseDtoByEmail.isEmpty()){
            customerRepository.save(customerRequestDto);
        }
        else{
            throw new RuntimeException("This email address is registered!");
        }
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerResponseDto> getByEmail(String email){
        return customerRepository.getByEmail(email);
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

    public void changeAccountTypeByCredit(String email, AccountType accountType) {

    }

}
