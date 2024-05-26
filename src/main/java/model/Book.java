package model;

import model.enums.ProductType;
import factory.model.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class Book implements Product {
    private ProductType productType;
    private String name;
    private BigDecimal amount;
    private String description;
    private Publisher publisher;
    private Author author;
    private Category category;
    private Integer stock;

    public Book(ProductType productType, String name, BigDecimal amount, String description, Publisher publisher, Author author, Category category, Integer stock) {
        this.productType = productType;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    @Override
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "productType=" + productType +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", author=" + author +
                ", category=" + category +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return productType == book.productType && Objects.equals(name, book.name) && Objects.equals(amount, book.amount) && Objects.equals(description, book.description) && Objects.equals(publisher, book.publisher) && Objects.equals(author, book.author) && Objects.equals(category, book.category) && Objects.equals(stock, book.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, name, amount, description, publisher, author, category, stock);
    }
}
