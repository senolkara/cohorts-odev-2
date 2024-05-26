package repository;

import dto.UserRequestDto;
import dto.UserResponseDto;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static List<User> userList = new ArrayList<>();

    @Override
    public void save(UserRequestDto userRequestDto) {
        User user = new User(
                userRequestDto.getName(),
                userRequestDto.getSurname(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword()
        );
        userList.add(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userList.forEach(user -> {
            UserResponseDto userResponseDto = getUserResponseDto(user);
            userResponseDtoList.add(userResponseDto);
        });
        return userResponseDtoList;
    }

    @Override
    public Optional<UserResponseDto> getByEmail(String email) {
        return getAll().stream()
                .filter(userResponseDto -> userResponseDto.getEmail().equals(email))
                .filter(UserResponseDto::getActive)
                .findFirst();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(User::getActive)
                .findFirst();
    }

    @Override
    public UserResponseDto getUserResponseDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setSurname(user.getSurname());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPhoneNumber(user.getPhoneNumber());
        userResponseDto.setActive(user.getActive());
        return userResponseDto;
    }
}
