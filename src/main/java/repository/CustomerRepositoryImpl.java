package repository;

import dto.CustomerRequestDto;
import dto.CustomerResponseDto;
import dto.UserResponseDto;
import factory.repository.UserRepositoryFactory;
import model.Customer;
import model.User;
import model.enums.RepositoryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private UserRepository userRepository = userRepositoryFactory.getBaseRepository(RepositoryType.USER);
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        User user = getUserByEmail(customerRequestDto.getUserRequestDto().getEmail());
        Customer customer = new Customer(
                customerRequestDto.getUserRequestDto().getName(),
                customerRequestDto.getUserRequestDto().getSurname(),
                customerRequestDto.getUserRequestDto().getEmail(),
                customerRequestDto.getUserRequestDto().getPassword()
        );
        customer.setUser(user);
        customerList.add(customer);
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerResponseDto customerResponseDto = getCustomerResponseDto(customer);
            customerResponseDtoList.add(customerResponseDto);
        });
        return customerResponseDtoList;
    }

    @Override
    public Optional<CustomerResponseDto> getByEmail(String email){
        return getAll().stream()
                .filter(customerResponseDto -> customerResponseDto.getUserResponseDto().getEmail().equals(email))
                .filter(customerResponseDto -> customerResponseDto.getUserResponseDto().getActive())
                .findFirst();
    }

    @Override
    public User getUserByEmail(String email){
        Optional<User> userOptional = userRepository.getUserByEmail(email);
        if (userOptional.isEmpty()){
            System.out.println("user not found : " + email);
            throw new RuntimeException("user not found");
        }
        return userOptional.get();
    }

    @Override
    public Customer getCustomerByEmail(String email){
        User user = getUserByEmail(email);
        Optional<Customer> customerOptional = customerList.stream()
                .filter(customer -> customer.getEmail().equals(user.getEmail()))
                .findFirst();
        if (customerOptional.isEmpty()){
            throw new RuntimeException("customer not found!");
        }
        return customerOptional.get();
    }

    private CustomerResponseDto getCustomerResponseDto(Customer customer){
        UserResponseDto userResponseDto = userRepository.getUserResponseDto(customer.getUser());
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setUserResponseDto(userResponseDto);
        customerResponseDto.setCredit(customer.getCredit());
        customerResponseDto.setAddresses(customer.getAddresses());
        //customerResponseDto.setOrderResponseDtoList(customer.getOrderList());
        customerResponseDto.setAccountType(customer.getAccountType());
        return customerResponseDto;
    }

}
