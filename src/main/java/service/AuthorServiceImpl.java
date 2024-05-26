package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import dto.PublisherResponseDto;
import factory.repository.AuthorRepositoryFactory;
import model.enums.RepositoryType;
import model.enums.ServiceType;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepositoryFactory authorRepositoryFactory = new AuthorRepositoryFactory();
    private AuthorRepository authorRepository = authorRepositoryFactory.getBaseRepository(RepositoryType.AUTHOR);

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
                .filter(authorResponseDto -> authorResponseDto.getUserResponseDto().getName().equals(authorName))
                .findFirst();
    }

}
