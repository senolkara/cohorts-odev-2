package service;

import dto.CategoryRequestDto;
import dto.CategoryResponseDto;
import factory.repository.CategoryRepositoryFactory;
import model.Category;
import model.enums.RepositoryType;
import repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepositoryFactory categoryRepositoryFactory = new CategoryRepositoryFactory();
    private CategoryRepository categoryRepository = categoryRepositoryFactory.getBaseRepository(RepositoryType.CATEGORY);

    @Override
    public void save(CategoryRequestDto categoryRequestDto) {
        Optional<Category> categoryOptional = getByName(categoryRequestDto.getName());
        if (categoryOptional.isEmpty()){
            categoryRepository.save(categoryRequestDto);
            System.out.println("category saved.");
        }
        else{
            throw new RuntimeException("category is registered!");
        }
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Optional<Category> getByName(String categoryName) {
        return categoryRepository.getByName(categoryName);
    }
}
