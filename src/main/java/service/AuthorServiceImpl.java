package service;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import repository.AuthorRepository;
import repository.AuthorRepositoryImpl;

import java.util.List;

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
}
