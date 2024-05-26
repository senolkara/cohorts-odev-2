package service;

import dto.InvoiceResponseDto;
import factory.service.BaseService;
import model.Order;

import java.util.List;

public interface InvoiceService extends BaseService {
    void save(Order order);
    List<InvoiceResponseDto> getAll();
}
