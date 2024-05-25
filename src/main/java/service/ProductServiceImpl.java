package service;

import dto.ProductRequestDto;
import dto.ProductResponseDto;
import repository.*;

import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private PublisherService publisherService;
    private PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    private AuthorRepository authorRepository = new AuthorRepositoryImpl();

    public ProductServiceImpl(PublisherService publisherService) {
        this.publisherService = publisherService;
        this.productRepository = new ProductRepositoryImpl(publisherRepository, authorRepository);
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
        System.out.println(publisherService.hashCode());
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
}
