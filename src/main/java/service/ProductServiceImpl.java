package service;

import dto.AuthorResponseDto;
import dto.ProductRequestDto;
import dto.ProductResponseDto;
import dto.PublisherResponseDto;
import factory.repository.ProductRepositoryFactory;
import model.enums.RepositoryType;
import repository.*;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductRepositoryFactory productRepositoryFactory = new ProductRepositoryFactory();
    private ProductRepository productRepository = productRepositoryFactory.getBaseRepository(RepositoryType.PRODUCT);
    private PublisherService publisherService;
    private AuthorService authorService;

    public ProductServiceImpl(PublisherService publisherService, AuthorService authorService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
        controlPublisherByProductRequestDto(productRequestDto);
        controlAuthorByProductRequestDto(productRequestDto);
        controlProductIsRegisteredByProductRequestDto(productRequestDto);
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
        Optional<AuthorResponseDto> authorResponseDtoByName = authorService.getByName(productRequestDto.getAuthorRequestDto().getUserRequestDto().getName());
        if (authorResponseDtoByName.isEmpty()){
            System.out.println("author not found : " + productRequestDto.getAuthorRequestDto().getUserRequestDto().getName());
            throw new RuntimeException("author not found");
        }
    }

    @Override
    public void controlProductIsRegisteredByProductRequestDto(ProductRequestDto productRequestDtoForControl) {
        Optional<ProductResponseDto> productResponseDtoByOptional = getAll().stream()
                .filter(productResponseDto -> productResponseDto.getName().equals(productRequestDtoForControl.getName()))
                .filter(productResponseDto -> productResponseDto.getAuthorResponseDto().getUserResponseDto().getName().equals(productRequestDtoForControl.getAuthorRequestDto().getUserRequestDto().getName()))
                .filter(productResponseDto -> productResponseDto.getPublisherResponseDto().getName().equals(productRequestDtoForControl.getPublisherRequestDto().getName()))
                .filter(productResponseDto -> productResponseDto.getCategoryResponseDto().getName().equals(productRequestDtoForControl.getCategoryRequestDto().getName()))
                .findFirst();
        if (productResponseDtoByOptional.isPresent()){
            throw new RuntimeException("product is registered!");
        }
    }

}
