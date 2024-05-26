package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import factory.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface AuthorService extends BaseService {
    void save(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAll();
    Optional<AuthorResponseDto> getByName(String authorName);
}
