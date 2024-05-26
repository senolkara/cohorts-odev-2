package factory.repository;

import model.enums.RepositoryType;
import repository.PublisherRepository;
import repository.PublisherRepositoryImpl;

public class PublisherRepositoryFactory implements BaseRepositoryFactory {
    @Override
    public PublisherRepository getBaseRepository(RepositoryType repositoryType) {
        if (repositoryType.equals(RepositoryType.PUBLISHER)){
            return new PublisherRepositoryImpl();
        }
        return null;
    }
}
