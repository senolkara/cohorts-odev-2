package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void save(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAll();
    Optional<AuthorResponseDto> getByName(String authorName);
}
