package factory.repository;

import model.enums.RepositoryType;
import repository.CategoryRepository;
import repository.CategoryRepositoryImpl;

public class CategoryRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public CategoryRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.CATEGORY)){
            return new CategoryRepositoryImpl();
        }
        return null;
    }
}
