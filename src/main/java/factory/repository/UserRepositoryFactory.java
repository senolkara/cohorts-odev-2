package factory.repository;

import model.enums.RepositoryType;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class UserRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public UserRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.USER)){
            return new UserRepositoryImpl();
        }
        return null;
    }
}
