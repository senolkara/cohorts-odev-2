package repository;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    void save(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAll();
    Optional<Author> getByName(String authorName);
}
