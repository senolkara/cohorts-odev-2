package service;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    void save(PublisherRequestDto publisherRequestDto);
    List<PublisherResponseDto> getAll();
    Optional<PublisherResponseDto> getByName(String publisherName);
}
