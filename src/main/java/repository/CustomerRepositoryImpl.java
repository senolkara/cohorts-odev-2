package repository;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer(
                customerRequestDto.getName(),
                customerRequestDto.getSurname(),
                customerRequestDto.getEmail(),
                customerRequestDto.getPassword()
        );
        customerList.add(customer);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
            customerResponseDto.setName(customer.getName());
            customerResponseDto.setSurname(customer.getSurname());
            customerResponseDto.setEmail(customer.getEmail());
            customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
            customerResponseDto.setCredit(customer.getCredit());
            customerResponseDto.setAccountType(customer.getAccountType());
            customerResponseDtoList.add(customerResponseDto);
        });
        return customerResponseDtoList;
    }

    @Override
    public Optional<CustomerResponseDto> getByEmail(String email){
        return getAll().stream()
                .filter(customerResponseDto -> customerResponseDto.getEmail().equals(email))
                .filter(CustomerResponseDto::getActive)
                .findFirst();
    }
}
