package service;

import dto.UserRequestDto;
import dto.UserResponseDto;
import factory.repository.UserRepositoryFactory;
import model.enums.RepositoryType;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private UserRepository userRepository = userRepositoryFactory.getBaseRepository(RepositoryType.USER);

    @Override
    public void save(UserRequestDto userRequestDto) {
        Optional<UserResponseDto> userResponseDtoByEmail = getByEmail(userRequestDto.getEmail());
        if (userResponseDtoByEmail.isEmpty()){
            userRepository.save(userRequestDto);
        }
        else{
            throw new RuntimeException("This email address is registered!");
        }
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.getAll();
    }

    @Override
    public Optional<UserResponseDto> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

}
