package factory.repository;

import model.enums.RepositoryType;

public interface BaseRepositoryFactory {
    BaseRepository getBaseRepository(RepositoryType repositoryType);
}
