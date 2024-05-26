package service;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import factory.repository.CustomerRepositoryFactory;
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
    public void changeAccountType(String email, Integer score) {
        Optional<CustomerResponseDto> customerResponseDtoOptional = getAll()
                .stream()
                .filter(customerResponseDto -> customerResponseDto.getUserResponseDto().getEmail().equals(email))
                .findFirst();
        if (customerResponseDtoOptional.isPresent()) {
            CustomerResponseDto customerResponseDto = customerResponseDtoOptional.get();
            customerResponseDto.setScore(score);
            customerRepository.changeAccountType(customerResponseDto);
        }
        else{
            throw new RuntimeException("customer not found");
        }
    }

}
