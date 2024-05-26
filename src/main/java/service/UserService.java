package service;

import dto.UserRequestDto;
import dto.UserResponseDto;
import factory.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService {
    void save(UserRequestDto userRequestDto);
    List<UserResponseDto> getAll();
    Optional<UserResponseDto> getByEmail(String email);
}
