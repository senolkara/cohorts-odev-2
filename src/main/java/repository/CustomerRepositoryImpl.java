package repository;

import dto.*;
import factory.repository.ProductRepositoryFactory;
import factory.repository.UserRepositoryFactory;
import model.Customer;
import model.Order;
import model.User;
import model.enums.AccountType;
import model.enums.RepositoryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private UserRepository userRepository = userRepositoryFactory.getBaseRepository(RepositoryType.USER);

    private ProductRepositoryFactory productRepositoryFactory = new ProductRepositoryFactory();
    private ProductRepository productRepository = productRepositoryFactory.getBaseRepository(RepositoryType.PRODUCT);

    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        User user = getUserByEmail(customerRequestDto.getUserRequestDto().getEmail());
        Customer customer = new Customer(
                customerRequestDto.getUserRequestDto().getName(),
                customerRequestDto.getUserRequestDto().getSurname(),
                customerRequestDto.getUserRequestDto().getEmail(),
                customerRequestDto.getUserRequestDto().getPassword(),
                customerRequestDto.getUserRequestDto().getAddress(),
                customerRequestDto.getUserRequestDto().getBirthDate()
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

    @Override
    public void changeAccountType(CustomerResponseDto customerResponseDto){
        Customer customer = getCustomerByEmail(customerResponseDto.getUserResponseDto().getEmail());
        Integer totalScore = customer.getScore() + customerResponseDto.getScore();
        AccountType customerAccountType = customerResponseDto.getAccountType();
        if (totalScore.compareTo(1000) > 0){
            customerAccountType = AccountType.SILVER;
        } else if (totalScore.compareTo(2000) > 0) {
            customerAccountType = AccountType.GOLD;
        } else if (totalScore.compareTo(4000) > 0) {
            customerAccountType = AccountType.PLATINUM;
        }
        customer.setAccountType(customerAccountType);
    }

    @Override
    public CustomerResponseDto getCustomerResponseDto(Customer customer){
        UserResponseDto userResponseDto = userRepository.getUserResponseDto(customer.getUser());
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        customer.getOrderList().forEach(order -> {
            orderResponseDtoList.add(getOrderResponseDto(order));
        });
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setUserResponseDto(userResponseDto);
        customerResponseDto.setCredit(customer.getCredit());
        customerResponseDto.setOrderResponseDtoList(orderResponseDtoList);
        customerResponseDto.setAccountType(customer.getAccountType());
        customerResponseDto.setScore(customer.getScore());
        return customerResponseDto;
    }

    private OrderResponseDto getOrderResponseDto(Order order){
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        order.getProductList().forEach(product -> {
            productResponseDtoList.add(productRepository.getProductResponseDto(product));
        });
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setCreateDateTime(order.getCreateDateTime());
        orderResponseDto.setProductResponseDtoList(productResponseDtoList);
        orderResponseDto.setOrderCode(order.getOrderCode());
        orderResponseDto.setOrderStatus(order.getOrderStatus());
        return orderResponseDto;
    }

}
