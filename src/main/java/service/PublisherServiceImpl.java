package service;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import model.Publisher;
import repository.PublisherRepository;
import repository.PublisherRepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository = new PublisherRepositoryImpl();

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
