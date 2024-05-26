package repository;

import dto.CustomerRequestDto;
import dto.OrderResponseDto;
import dto.ProductRequestDto;
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
    public void save(CustomerRequestDto customerRequestDto) {
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

    private OrderResponseDto getOrderResponseDto(Order order){
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setCreateDateTime(order.getCreateDateTime());
        //orderResponseDto.setProductResponseDtoList(order.getProductList());
        orderResponseDto.setOrderCode(order.getOrderCode());
        orderResponseDto.setOrderStatus(order.getOrderStatus());
        return orderResponseDto;
    }
}
