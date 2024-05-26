package repository;

import dto.*;
import factory.GenerateRandomUnique;
import factory.model.Product;
import factory.repository.CustomerRepositoryFactory;
import factory.repository.ProductRepositoryFactory;
import model.Customer;
import model.Order;
import model.enums.RepositoryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {

    private ProductRepositoryFactory productRepositoryFactory = new ProductRepositoryFactory();
    private ProductRepository productRepository = productRepositoryFactory.getBaseRepository(RepositoryType.PRODUCT);

    private CustomerRepositoryFactory customerRepositoryFactory = new CustomerRepositoryFactory();
    private CustomerRepository customerRepository = customerRepositoryFactory.getBaseRepository(RepositoryType.CUSTOMER);

    private static List<Order> orderList = new ArrayList<>();

    @Override
    public Order save(CustomerRequestDto customerRequestDto) {
        String orderCode = GenerateRandomUnique.createRandomCode();
        controlIsThereOrderCode(orderCode);
        List<Product> productList = getProductListForOrderByCustomerRequestDto(customerRequestDto);
        Customer customer = customerRepository.getCustomerByEmail(customerRequestDto.getUserRequestDto().getEmail());
        Order order = new Order(
                productList,
                orderCode,
                customer
        );
        orderList.add(order);
        return order;
    }

    @Override
    public List<OrderResponseDto> getAll() {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        orderList.forEach(order -> {
            OrderResponseDto orderResponseDto = getOrderResponseDto(order);
            orderResponseDtoList.add(orderResponseDto);
        });
        return orderResponseDtoList;
    }

    @Override
    public void controlIsThereOrderCode(String orderCode){
        Optional<OrderResponseDto> orderResponseDtoByOptional = getAll().stream()
                .filter(orderResponseDto -> orderResponseDto.getOrderCode().equals(orderCode))
                .findFirst();
        if (orderResponseDtoByOptional.isPresent()){
            throw new RuntimeException("order code was already created!");
        }
    }

    private List<Product> getProductListForOrderByCustomerRequestDto(CustomerRequestDto customerRequestDto){
        List<Product> productList = new ArrayList<>();
        List<ProductRequestDto> productRequestDtoList = customerRequestDto.getOrderRequestDtoList()
                .stream()
                .flatMap(orderRequestDto -> orderRequestDto.getProductRequestDtoList().stream())
                .toList();
        productRequestDtoList.forEach(productRequestDto -> {
            productList.add(productRepository.getProductByProductRequestDto(productRequestDto));
        });
        return productList;
    }

    @Override
    public OrderResponseDto getOrderResponseDto(Order order){
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        order.getProductList().forEach(product -> {
            productResponseDtoList.add(productRepository.getProductResponseDto(product));
        });
        CustomerResponseDto customerResponseDto = customerRepository.getCustomerResponseDto(
                order.getCustomer()
        );
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setCreateDateTime(order.getCreateDateTime());
        orderResponseDto.setProductResponseDtoList(productResponseDtoList);
        orderResponseDto.setOrderCode(order.getOrderCode());
        orderResponseDto.setOrderStatus(order.getOrderStatus());
        orderResponseDto.setCustomerResponseDto(customerResponseDto);
        return orderResponseDto;
    }

    @Override
    public Order getOrderByOrderRequestDto(OrderRequestDto orderRequestDtoForGet){
        Optional<Order> orderByOrderRequestDto = orderList.stream()
                .filter(order -> order
                        .getCustomer()
                        .getUser()
                        .getEmail()
                        .equals(orderRequestDtoForGet
                                .getCustomerRequestDto()
                                .getUserRequestDto()
                                .getEmail()))
                .findFirst();
        if (orderByOrderRequestDto.isEmpty()){
            throw new RuntimeException("order not found!");
        }
        return orderByOrderRequestDto.get();
    }

    @Override
    public Order getOrderByCustomerEmail(String email){
        Optional<Order> orderByCustomerEmail = orderList.stream()
                .filter(order -> order
                        .getCustomer()
                        .getUser()
                        .getEmail()
                        .equals(email))
                .findFirst();
        if (orderByCustomerEmail.isEmpty()){
            throw new RuntimeException("order not found!");
        }
        return orderByCustomerEmail.get();
    }

    @Override
    public OrderRequestDto getOrderRequestDtoWithCustomerRequestDto(Order order, CustomerRequestDto customerRequestDto){
        List<ProductRequestDto> productRequestDtoList = new ArrayList<>();
        order.getProductList().forEach(product -> {
            ProductRequestDto productRequestDto = new ProductRequestDto();
            productRequestDto.setName(product.getName());
            productRequestDto.setAmount(product.getAmount());
            productRequestDtoList.add(productRequestDto);
        });
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setProductRequestDtoList(productRequestDtoList);
        orderRequestDto.setCustomerRequestDto(customerRequestDto);
        return orderRequestDto;
    }

    @Override
    public void changeProductStockInfo(List<Product> productList){
        productList.forEach(product -> {
            Integer newStock = product.getStock() - 1;
            product.setStock(newStock);
        });
    }
}
