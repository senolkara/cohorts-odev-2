package repository;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {

    private List<Author> authorList = new ArrayList<>();

    @Override
    public void save(AuthorRequestDto authorRequestDto) {
        Author author = new Author(
                authorRequestDto.getName(),
                authorRequestDto.getSurname(),
                authorRequestDto.getEmail(),
                authorRequestDto.getBio()
        );
        authorList.add(author);
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        authorList.forEach(author -> {
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setName(author.getName());
            authorResponseDto.setSurname(author.getSurname());
            authorResponseDto.setEmail(author.getEmail());
            authorResponseDto.setBio(author.getBio());
            authorResponseDto.setBooks(author.getBooks());
            authorResponseDtoList.add(authorResponseDto);
        });
        return authorResponseDtoList;
    }

    @Override
    public Optional<Author> getAuthorByName(String authorName) {
        return authorList.stream()
                .filter(author -> author.getName().equals(authorName))
                .findFirst();
    }
}
