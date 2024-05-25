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
    private static Set<Product> productSet = new HashSet<>();

    private PublisherRepository publisherRepository = new PublisherRepositoryImpl();
    private AuthorRepository authorRepository = new AuthorRepositoryImpl();

    @Override
    public void save(ProductRequestDto productRequestDto) {
        Publisher publisher = getPublisherByProductRequestDto(productRequestDto);
        Author author = getAuthorByProductRequestDto(productRequestDto);
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
            PublisherResponseDto publisherResponseDto = getPublisherResponseDto(product);
            AuthorResponseDto authorResponseDto = getAuthorResponseDto(product);
            ProductResponseDto productResponseDto = getProductResponseDto(product);
            productResponseDto.setPublisherResponseDto(publisherResponseDto);
            productResponseDto.setAuthorResponseDto(authorResponseDto);
            productResponseDtoList.add(productResponseDto);
        });
        return productResponseDtoList;
    }

    @Override
    public Publisher getPublisherByProductRequestDto(ProductRequestDto productRequestDto){
        Optional<Publisher> publisherOptional = publisherRepository.getByName(productRequestDto.getPublisherRequestDto().getName());
        if (publisherOptional.isEmpty()){
            System.out.println("publisher not found : " + productRequestDto.getPublisherRequestDto().getName());
            throw new RuntimeException("publisher not found");
        }
        return publisherOptional.get();
    }

    @Override
    public Author getAuthorByProductRequestDto(ProductRequestDto productRequestDto){
        Optional<Author> authorOptional = authorRepository.getByName(productRequestDto.getAuthorRequestDto().getName());
        if (authorOptional.isEmpty()){
            System.out.println("author not found : " + productRequestDto.getAuthorRequestDto().getName());
            throw new RuntimeException("author not found");
        }
        return authorOptional.get();
    }

    private ProductResponseDto getProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setAmount(product.getAmount());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setProductType(product.getProductType());
        productResponseDto.setProductType(product.getProductType());
        return productResponseDto;
    }

    private PublisherResponseDto getPublisherResponseDto(Product product){
        PublisherResponseDto publisherResponseDto = new PublisherResponseDto();
        publisherResponseDto.setName(product.getPublisher().getName());
        publisherResponseDto.setCreateDate(product.getPublisher().getCreateDate());
        publisherResponseDto.setBookList(product.getPublisher().getBookList());
        return publisherResponseDto;
    }

    private AuthorResponseDto getAuthorResponseDto(Product product){
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(product.getAuthor().getName());
        authorResponseDto.setSurname(product.getAuthor().getSurname());
        authorResponseDto.setEmail(product.getAuthor().getEmail());
        authorResponseDto.setBio(product.getAuthor().getBio());
        authorResponseDto.setBooks(product.getAuthor().getBooks());
        return authorResponseDto;
    }
}
