package repository;

import dto.AuthorResponseDto;
import dto.ProductRequestDto;
import dto.ProductResponseDto;
import dto.PublisherResponseDto;
import model.Author;
import model.Publisher;
import model.factory.Product;
import model.factory.ProductFactory;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private Set<Product> productSet = new HashSet<>();

    private PublisherRepository publisherRepository;
    private AuthorRepository authorRepository;

    public ProductRepositoryImpl(PublisherRepository publisherRepository, AuthorRepository authorRepository){
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
        Publisher publisher = controlPublisherByOptional(productRequestDto);
        Author author = controlAuthorByOptional(productRequestDto);
        Product product = ProductFactory.getProduct(
                productRequestDto.getProductType(),
                productRequestDto.getName(),
                productRequestDto.getAmount(),
                productRequestDto.getDescription(),
                publisher,
                author);
        productSet.add(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        productSet.forEach(product -> {
            PublisherResponseDto publisherResponseDto = new PublisherResponseDto();
            publisherResponseDto.setName(product.getPublisher().getName());
            publisherResponseDto.setCreateDate(product.getPublisher().getCreateDate());
            publisherResponseDto.setBookList(product.getPublisher().getBookList());
            
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setName(product.getAuthor().getName());
            authorResponseDto.setSurname(product.getAuthor().getSurname());
            authorResponseDto.setEmail(product.getAuthor().getEmail());
            authorResponseDto.setBio(product.getAuthor().getBio());
            authorResponseDto.setBooks(product.getAuthor().getBooks());


            ProductResponseDto productResponseDto = getProductResponseDto(product, publisherResponseDto, authorResponseDto);
            productResponseDtoList.add(productResponseDto);
        });
        return productResponseDtoList;
    }

    private ProductResponseDto getProductResponseDto(Product product, PublisherResponseDto publisherResponseDto, AuthorResponseDto authorResponseDto) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setAmount(product.getAmount());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setProductType(product.getProductType());
        productResponseDto.setPublisherResponseDto(publisherResponseDto);
        productResponseDto.setAuthorResponseDto(authorResponseDto);
        productResponseDto.setProductType(product.getProductType());
        return productResponseDto;
    }

    private Publisher controlPublisherByOptional(ProductRequestDto productRequestDto){
        Optional<Publisher> publisherOptionalByName = getPublisherByName(productRequestDto.getPublisherRequestDto().getName());
        if (publisherOptionalByName.isEmpty()){
            System.out.println("publisher not found : " + productRequestDto.getPublisherRequestDto().getName());
            throw new RuntimeException("publisher not found");
        }
        return publisherOptionalByName.get();
    }

    private Optional<Publisher> getPublisherByName(String publisherName){
        return publisherRepository.getPublisherByName(publisherName);
    }

    private Author controlAuthorByOptional(ProductRequestDto productRequestDto){
        Optional<Author> authorOptionalByName = getAuthorByName(productRequestDto.getAuthorRequestDto().getName());
        if (authorOptionalByName.isEmpty()){
            System.out.println("author not found : " + productRequestDto.getAuthorRequestDto().getName());
            throw new RuntimeException("publisher not found");
        }
        return authorOptionalByName.get();
    }

    private Optional<Author> getAuthorByName(String authorName){
        return authorRepository.getAuthorByName(authorName);
    }
}
