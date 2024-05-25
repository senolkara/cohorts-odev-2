package service;

import dto.AuthorResponseDto;
import dto.ProductRequestDto;
import dto.ProductResponseDto;
import dto.PublisherResponseDto;
import repository.*;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepositoryImpl();
    private PublisherService publisherService;
    private AuthorService authorService;

    public ProductServiceImpl(PublisherService publisherService, AuthorService authorService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
        System.out.println(publisherService.hashCode());
        controlPublisherByProductRequestDto(productRequestDto);
        controlAuthorByProductRequestDto(productRequestDto);
        productRepository.save(productRequestDto);
        System.out.println("Product Service: saved -> " + productRequestDto.getName());
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void listAll() {
        getAll().forEach(System.out::println);
    }

    @Override
    public void controlPublisherByProductRequestDto(ProductRequestDto productRequestDto){
        Optional<PublisherResponseDto> publisherResponseDtoByName = publisherService.getByName(
                productRequestDto.getPublisherRequestDto().getName()
        );
        if (publisherResponseDtoByName.isEmpty()){
            System.out.println("publisher not found : " + productRequestDto.getPublisherRequestDto().getName());
            throw new RuntimeException("publisher not found");
        }
    }

    @Override
    public void controlAuthorByProductRequestDto(ProductRequestDto productRequestDto){
        Optional<AuthorResponseDto> AuthorResponseDtoByName = authorService.getByName(productRequestDto.getAuthorRequestDto().getName());
        if (AuthorResponseDtoByName.isEmpty()){
            System.out.println("author not found : " + productRequestDto.getAuthorRequestDto().getName());
            throw new RuntimeException("author not found");
        }
    }
}
