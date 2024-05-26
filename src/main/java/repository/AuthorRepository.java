package repository;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import dto.CustomerRequestDto;
import model.Author;
import factory.repository.BaseRepository;
import model.User;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository {
    void save(AuthorRequestDto authorRequestDto);
    List<AuthorResponseDto> getAll();
    Optional<Author> getByName(String authorName);
    User getUserByAuthorRequestDto(AuthorRequestDto authorRequestDto);
}
