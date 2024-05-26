package service;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import factory.repository.PublisherRepositoryFactory;
import model.enums.RepositoryType;
import repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {

    private PublisherRepositoryFactory publisherRepositoryFactory = new PublisherRepositoryFactory();
    private PublisherRepository publisherRepository = publisherRepositoryFactory.getBaseRepository(RepositoryType.PUBLISHER);

    @Override
    public void save(PublisherRequestDto publisherRequestDto) {
        publisherRepository.save(publisherRequestDto);
        System.out.println("publisher saved.");
    }

    @Override
    public List<PublisherResponseDto> getAll() {
        return publisherRepository.getAll();
    }

    @Override
    public Optional<PublisherResponseDto> getByName(String publisherName) {
        return getAll().stream()
                .filter(publisherResponseDto -> publisherResponseDto.getName().equals(publisherName))
                .findFirst();
    }

}
