package repository;

import dto.*;
import factory.repository.AuthorRepositoryFactory;
import factory.repository.CategoryRepositoryFactory;
import factory.repository.PublisherRepositoryFactory;
import factory.repository.UserRepositoryFactory;
import model.Author;
import model.Category;
import model.Publisher;
import factory.model.Product;
import factory.model.ProductFactory;
import model.enums.RepositoryType;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    private static Set<Product> productSet = new HashSet<>();

    private UserRepositoryFactory userRepositoryFactory = new UserRepositoryFactory();
    private UserRepository userRepository = userRepositoryFactory.getBaseRepository(RepositoryType.USER);

    private PublisherRepositoryFactory publisherRepositoryFactory = new PublisherRepositoryFactory();
    private PublisherRepository publisherRepository = publisherRepositoryFactory.getBaseRepository(RepositoryType.PUBLISHER);

    private AuthorRepositoryFactory authorRepositoryFactory = new AuthorRepositoryFactory();
    private AuthorRepository authorRepository = authorRepositoryFactory.getBaseRepository(RepositoryType.AUTHOR);

    private CategoryRepositoryFactory categoryRepositoryFactory = new CategoryRepositoryFactory();
    private CategoryRepository categoryRepository = categoryRepositoryFactory.getBaseRepository(RepositoryType.CATEGORY);

    @Override
    public void save(ProductRequestDto productRequestDto) {
        Publisher publisher = getPublisherByProductRequestDto(productRequestDto);
        Author author = getAuthorByProductRequestDto(productRequestDto);
        Category category = getCategoryByProductRequestDto(productRequestDto);
        Product product = ProductFactory.getProduct(
                productRequestDto.getProductType(),
                productRequestDto.getName(),
                productRequestDto.getAmount(),
                productRequestDto.getDescription(),
                publisher,
                author,
                category,
                productRequestDto.getStock());
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
        Optional<Author> authorOptional = authorRepository.getByName(productRequestDto.getAuthorRequestDto().getUserRequestDto().getName());
        if (authorOptional.isEmpty()){
            System.out.println("author not found : " + productRequestDto.getAuthorRequestDto().getUserRequestDto().getName());
            throw new RuntimeException("author not found");
        }
        return authorOptional.get();
    }

    @Override
    public Category getCategoryByProductRequestDto(ProductRequestDto productRequestDto){
        Optional<Category> categoryOptional = categoryRepository.getByName(
                productRequestDto.getCategoryRequestDto().getName()
        );
        if (categoryOptional.isEmpty()){
            System.out.println("category not found : " + productRequestDto.getCategoryRequestDto().getName());
            throw new RuntimeException("category not found");
        }
        return categoryOptional.get();
    }

    @Override
    public Product getProductByProductRequestDto(ProductRequestDto productRequestDtoForGet){
        Optional<Product> productByProductRequestDto = productSet.stream()
                .filter(product -> product.getName().equals(productRequestDtoForGet.getName()))
                .filter(product -> product.getAuthor().getUser().getName().equals(productRequestDtoForGet.getAuthorRequestDto().getUserRequestDto().getName()))
                .filter(product -> product.getPublisher().getName().equals(productRequestDtoForGet.getPublisherRequestDto().getName()))
                .filter(product -> product.getCategory().getName().equals(productRequestDtoForGet.getCategoryRequestDto().getName()))
                .findFirst();
        if (productByProductRequestDto.isEmpty()){
            throw new RuntimeException("product not found!");
        }
        return productByProductRequestDto.get();
    }

    @Override
    public ProductResponseDto getProductResponseDto(Product product) {
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
        UserResponseDto userResponseDto = userRepository.getUserResponseDto(product.getAuthor().getUser());
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setUserResponseDto(userResponseDto);
        authorResponseDto.setBio(product.getAuthor().getBio());
        authorResponseDto.setBooks(product.getAuthor().getBooks());
        return authorResponseDto;
    }

}
