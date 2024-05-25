package repository;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {
    void save(PublisherRequestDto publisherRequestDto);
    List<PublisherResponseDto> getAll();
    Optional<Publisher> getPublisherByName(String publisherName);
}
