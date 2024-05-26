package factory.repository;

import model.enums.RepositoryType;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;

public class AuthorRepositoryFactory implements BaseRepositoryFactory{
    @Override
    public AuthorRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.AUTHOR)){
            return new AuthorRepositoryImpl();
        }
        return null;
    }
}
