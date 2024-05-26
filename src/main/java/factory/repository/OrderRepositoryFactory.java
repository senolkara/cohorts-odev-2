package factory.repository;

import model.enums.RepositoryType;
import repository.OrderRepository;
import repository.OrderRepositoryImpl;

public class OrderRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public OrderRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.ORDER)){
            return new OrderRepositoryImpl();
        }
        return null;
    }
}
