package service;

import dto.ProductRequestDto;
import dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    void save(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAll();
    void listAll();
}
