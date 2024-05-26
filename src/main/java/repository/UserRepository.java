package repository;

import dto.UserRequestDto;
import dto.UserResponseDto;
import model.User;
import factory.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository {
    void save(UserRequestDto userRequestDto);
    List<UserResponseDto> getAll();
    Optional<UserResponseDto> getByEmail(String email);
    UserResponseDto getUserResponseDto(User user);
    Optional<User> getUserByEmail(String email);
}
