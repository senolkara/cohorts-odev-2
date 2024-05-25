package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;

import java.util.List;

public interface AuthorService {
    void save(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAll();
}
