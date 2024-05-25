package model;

import model.factory.Product;
import model.enums.ProductType;

import java.math.BigDecimal;
import java.util.Objects;

public class Journal implements Product {
    private ProductType productType;
    private String name;
    private BigDecimal amount;
    private String description;
    private Publisher publisher;
    private Author author;

    public Journal(ProductType productType, String name, BigDecimal amount, String description, Publisher publisher, Author author) {
        this.productType = productType;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
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
    public String toString() {
        return "Journal{" +
                "productType=" + productType +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return productType == journal.productType && Objects.equals(name, journal.name) && Objects.equals(amount, journal.amount) && Objects.equals(description, journal.description) && Objects.equals(publisher, journal.publisher) && Objects.equals(author, journal.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, name, amount, description, publisher, author);
    }
}