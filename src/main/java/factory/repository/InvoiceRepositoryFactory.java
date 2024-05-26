package factory.repository;

import model.enums.RepositoryType;
import repository.InvoiceRepository;
import repository.InvoiceRepositoryImpl;

public class InvoiceRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public InvoiceRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.INVOICE)){
            return new InvoiceRepositoryImpl();
        }
        return null;
    }
}
