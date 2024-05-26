package repository;

import dto.CategoryRequestDto;
import dto.CategoryResponseDto;
import factory.repository.BaseRepository;
import model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends BaseRepository {
    void save(CategoryRequestDto categoryRequestDto);
    List<CategoryResponseDto> getAll();
    Optional<Category> getByName(String categoryName);
}
