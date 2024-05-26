package service;

import dto.InvoiceResponseDto;
import factory.repository.InvoiceRepositoryFactory;
import model.Order;
import model.enums.RepositoryType;
import repository.InvoiceRepository;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepositoryFactory invoiceRepositoryFactory = new InvoiceRepositoryFactory();
    private InvoiceRepository invoiceRepository = invoiceRepositoryFactory.getBaseRepository(RepositoryType.INVOICE);

    @Override
    public void save(Order order) {
        invoiceRepository.save(order);
    }

    @Override
    public List<InvoiceResponseDto> getAll() {
        return invoiceRepository.getAll();
    }
}
