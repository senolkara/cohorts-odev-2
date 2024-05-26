package dto;

import model.enums.ProductType;

import java.math.BigDecimal;

public class ProductResponseDto {
    private String name;
    private BigDecimal amount;
    private String description;
    private PublisherResponseDto publisherResponseDto;
    private AuthorResponseDto authorResponseDto;
    private ProductType productType;
    private CategoryResponseDto categoryResponseDto;
    private Integer stock;

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

    public PublisherResponseDto getPublisherResponseDto() {
        return publisherResponseDto;
    }

    public void setPublisherResponseDto(PublisherResponseDto publisherResponseDto) {
        this.publisherResponseDto = publisherResponseDto;
    }

    public AuthorResponseDto getAuthorResponseDto() {
        return authorResponseDto;
    }

    public void setAuthorResponseDto(AuthorResponseDto authorResponseDto) {
        this.authorResponseDto = authorResponseDto;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public CategoryResponseDto getCategoryResponseDto() {
        return categoryResponseDto;
    }

    public void setCategoryResponseDto(CategoryResponseDto categoryResponseDto) {
        this.categoryResponseDto = categoryResponseDto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
