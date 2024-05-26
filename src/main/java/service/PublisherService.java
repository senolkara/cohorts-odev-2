package service;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import factory.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface PublisherService extends BaseService {
    void save(PublisherRequestDto publisherRequestDto);
    List<PublisherResponseDto> getAll();
    Optional<PublisherResponseDto> getByName(String publisherName);
}
