package repository;

import dto.InvoiceResponseDto;
import factory.repository.BaseRepository;
import model.Invoice;
import model.Order;

import java.util.List;

public interface InvoiceRepository extends BaseRepository {
    void save(Order order);
    List<InvoiceResponseDto> getAll();
    InvoiceResponseDto getInvoiceResponseDto(Invoice invoice);
}
