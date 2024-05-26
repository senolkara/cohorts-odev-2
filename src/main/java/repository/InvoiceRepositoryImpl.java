package repository;

import dto.*;
import factory.model.Product;
import factory.repository.OrderRepositoryFactory;
import model.Invoice;
import model.Order;
import model.enums.RepositoryType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryImpl implements InvoiceRepository {

    private OrderRepositoryFactory orderRepositoryFactory = new OrderRepositoryFactory();
    private OrderRepository orderRepository = orderRepositoryFactory.getBaseRepository(RepositoryType.ORDER);

    private static List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void save(Order order) {
        BigDecimal totalPrice = order.getProductList()
                .stream()
                .map(Product::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Invoice invoice = new Invoice(
                totalPrice,
                order,
                LocalDateTime.now()
        );
        invoiceList.add(invoice);
    }

    @Override
    public List<InvoiceResponseDto> getAll() {
        List<InvoiceResponseDto> invoiceResponseDtoList = new ArrayList<>();
        invoiceList.forEach(invoice -> {
            InvoiceResponseDto invoiceResponseDto = getInvoiceResponseDto(invoice);
            invoiceResponseDtoList.add(invoiceResponseDto);
        });
        return invoiceResponseDtoList;
    }

    @Override
    public InvoiceResponseDto getInvoiceResponseDto(Invoice invoice) {
        OrderResponseDto orderResponseDto = orderRepository.getOrderResponseDto(invoice.getOrder());
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();
        invoiceResponseDto.setTotalPrice(invoice.getTotalPrice());
        invoiceResponseDto.setOrderResponseDto(orderResponseDto);
        invoiceResponseDto.setCreateDateTime(invoice.getCreateDateTime());
        return invoiceResponseDto;
    }

}
