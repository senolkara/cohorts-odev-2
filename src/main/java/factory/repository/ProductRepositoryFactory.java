package factory.repository;

import model.enums.RepositoryType;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

public class ProductRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public ProductRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.PRODUCT)){
            return new ProductRepositoryImpl();
        }
        return null;
    }
}
