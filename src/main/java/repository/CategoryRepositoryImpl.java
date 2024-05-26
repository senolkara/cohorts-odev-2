package repository;

import dto.CategoryRequestDto;
import dto.CategoryResponseDto;
import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static List<Category> categoryList = new ArrayList<>();

    @Override
    public void save(CategoryRequestDto categoryRequestDto) {
        Category category = new Category(categoryRequestDto.getName(), categoryRequestDto.getDescription());
        categoryList.add(category);
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        categoryList.forEach(category -> {
            CategoryResponseDto categoryResponseDto = getCategoryResponseDto(category);
            categoryResponseDtoList.add(categoryResponseDto);
        });
        return categoryResponseDtoList;
    }

    @Override
    public Optional<Category> getByName(String categoryName) {
        return categoryList.stream()
                .filter(category -> category.getName().equals(categoryName))
                .findFirst();
    }

    private CategoryResponseDto getCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setName(category.getName());
        categoryResponseDto.setDescription(category.getDescription());
        return categoryResponseDto;
    }
}
