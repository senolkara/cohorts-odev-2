package repository;

import dto.ProductRequestDto;
import dto.ProductResponseDto;
import factory.model.Product;
import factory.repository.BaseRepository;
import model.Author;
import model.Category;
import model.Publisher;

import java.util.List;

public interface ProductRepository extends BaseRepository {
    void save(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAll();
    Publisher getPublisherByProductRequestDto(ProductRequestDto productRequestDto);
    Author getAuthorByProductRequestDto(ProductRequestDto productRequestDto);
    Category getCategoryByProductRequestDto(ProductRequestDto productRequestDto);
    Product getProductByProductRequestDto(ProductRequestDto productRequestDto);
}
