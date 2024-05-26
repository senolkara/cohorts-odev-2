package repository;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import factory.repository.BaseRepository;
import model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends BaseRepository {
    void save(PublisherRequestDto publisherRequestDto);
    List<PublisherResponseDto> getAll();
    Optional<Publisher> getByName(String publisherName);
}
