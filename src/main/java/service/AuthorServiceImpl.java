package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import dto.PublisherResponseDto;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository = new AuthorRepositoryImpl();

    @Override
    public void save(AuthorRequestDto authorRequestDto) {
        authorRepository.save(authorRequestDto);
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public Optional<AuthorResponseDto> getByName(String authorName) {
        return getAll().stream()
                .filter(authorResponseDto -> authorResponseDto.getName().equals(authorName))
                .findFirst();
    }
}
