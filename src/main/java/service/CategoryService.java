package service;

import dto.CategoryRequestDto;
import dto.CategoryResponseDto;
import factory.service.BaseService;
import model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService extends BaseService {
    void save(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getAll();
    Optional<Category> getByName(String categoryName);
}
