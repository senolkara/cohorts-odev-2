package repository;

import dto.AuthorRequestDto;
import dto.AuthorResponseDto;
import dto.UserResponseDto;
import factory.repository.UserRepositoryFactory;
import model.Author;
import model.User;
import model.enums.RepositoryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepositoryImpl implements AuthorRepository {

    private UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private UserRepository userRepository = userRepositoryFactory.getBaseRepository(RepositoryType.USER);
    private static List<Author> authorList = new ArrayList<>();

    @Override
    public void save(AuthorRequestDto authorRequestDto) {
        User user = getUserByAuthorRequestDto(authorRequestDto);
        Author author = new Author(
                authorRequestDto.getUserRequestDto().getName(),
                authorRequestDto.getUserRequestDto().getSurname(),
                authorRequestDto.getUserRequestDto().getEmail(),
                authorRequestDto.getUserRequestDto().getPassword(),
                authorRequestDto.getUserRequestDto().getAddress(),
                authorRequestDto.getUserRequestDto().getBirthDate()
        );
        author.setUser(user);
        authorList.add(author);
    }

    @Override
    public List<AuthorResponseDto> getAll() {
        List<AuthorResponseDto> authorResponseDtoList = new ArrayList<>();
        authorList.forEach(author -> {
            AuthorResponseDto authorResponseDto = getAuthorResponseDto(author);
            authorResponseDtoList.add(authorResponseDto);
        });
        return authorResponseDtoList;
    }

    @Override
    public Optional<Author> getByName(String authorName) {
        return authorList.stream()
                .filter(author -> author.getName().equals(authorName))
                .findFirst();
    }

    @Override
    public User getUserByAuthorRequestDto(AuthorRequestDto authorRequestDto){
        Optional<User> userOptional = userRepository.getUserByEmail(authorRequestDto.getUserRequestDto().getEmail());
        if (userOptional.isEmpty()){
            System.out.println("user not found : " + authorRequestDto.getUserRequestDto().getEmail());
            throw new RuntimeException("user not found");
        }
        return userOptional.get();
    }

    private AuthorResponseDto getAuthorResponseDto(Author author){
        UserResponseDto userResponseDto = userRepository.getUserResponseDto(author.getUser());
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setUserResponseDto(userResponseDto);
        authorResponseDto.setBio(author.getBio());
        authorResponseDto.setBooks(author.getBooks());
        return authorResponseDto;
    }


}
