package repository;

import dto.ProductRequestDto;
import dto.ProductResponseDto;
import model.Author;
import model.Publisher;

import java.util.List;

public interface ProductRepository {
    void save(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAll();
    Publisher getPublisherByProductRequestDto(ProductRequestDto productRequestDto);
    Author getAuthorByProductRequestDto(ProductRequestDto productRequestDto);
}
