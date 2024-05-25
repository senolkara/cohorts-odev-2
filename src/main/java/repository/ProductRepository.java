package repository;

import dto.ProductRequestDto;
import dto.ProductResponseDto;

import java.util.List;

public interface ProductRepository {
    void save(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAll();
}
