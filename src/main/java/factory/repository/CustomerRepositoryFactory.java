package factory.repository;

import model.enums.RepositoryType;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

public class CustomerRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public CustomerRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.CUSTOMER)){
            return new CustomerRepositoryImpl();
        }
        return null;
    }
}
