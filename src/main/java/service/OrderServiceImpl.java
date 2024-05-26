package service;

import dto.CustomerRequestDto;
import dto.OrderResponseDto;
import factory.model.Product;
import factory.repository.InvoiceRepositoryFactory;
import factory.repository.OrderRepositoryFactory;
import factory.service.CustomerServiceFactory;
import model.Order;
import model.enums.RepositoryType;
import model.enums.ServiceType;
import repository.InvoiceRepository;
import repository.OrderRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepositoryFactory orderRepositoryFactory = new OrderRepositoryFactory();
    private OrderRepository orderRepository = orderRepositoryFactory.getBaseRepository(RepositoryType.ORDER);

    private InvoiceRepositoryFactory invoiceRepositoryFactory = new InvoiceRepositoryFactory();
    private InvoiceRepository invoiceRepository = invoiceRepositoryFactory.getBaseRepository(RepositoryType.INVOICE);

    private CustomerServiceFactory customerServiceFactory = new CustomerServiceFactory();
    private CustomerService customerService = customerServiceFactory.getBaseService(ServiceType.CUSTOMER);

    @Override
    public void save(CustomerRequestDto customerRequestDto) {
        Order order = orderRepository.save(customerRequestDto);
        System.out.println("order saved");
        orderRepository.changeProductStockInfo(order.getProductList());
        invoiceRepository.save(order);
        System.out.println("invoice saved");
        changeCustomerAccountType(order, customerRequestDto);
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return orderRepository.getAll();
    }

    private void changeCustomerAccountType(Order order, CustomerRequestDto customerRequestDto){
        BigDecimal totalPrice = order.getProductList()
                .stream()
                .map(Product::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Integer score = totalPrice.multiply(BigDecimal.valueOf(2))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).intValue();
        customerService.changeAccountType(customerRequestDto.getUserRequestDto().getEmail(), score);
    }

}
