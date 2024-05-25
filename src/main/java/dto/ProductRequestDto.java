package dto;

import model.enums.ProductType;

import java.math.BigDecimal;

public class ProductRequestDto {
    private String name;
    private BigDecimal amount;
    private String description;
    private PublisherRequestDto publisherRequestDto;
    private AuthorRequestDto authorRequestDto;
    private ProductType productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PublisherRequestDto getPublisherRequestDto() {
        return publisherRequestDto;
    }

    public void setPublisherRequestDto(PublisherRequestDto publisherRequestDto) {
        this.publisherRequestDto = publisherRequestDto;
    }

    public AuthorRequestDto getAuthorRequestDto() {
        return authorRequestDto;
    }

    public void setAuthorRequestDto(AuthorRequestDto authorRequestDto) {
        this.authorRequestDto = authorRequestDto;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
