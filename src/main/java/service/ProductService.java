package service;

import dto.ProductRequestDto;
import dto.ProductResponseDto;
import factory.service.BaseService;

import java.util.List;

public interface ProductService extends BaseService {
    void save(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getAll();
    void listAll();
    void controlPublisherByProductRequestDto(ProductRequestDto productRequestDto);
    void controlAuthorByProductRequestDto(ProductRequestDto productRequestDto);
    void controlProductIsRegisteredByProductRequestDto(ProductRequestDto productRequestDto);
}
