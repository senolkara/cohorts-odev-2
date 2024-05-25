package model.factory;

import model.Author;
import model.Publisher;
import model.enums.ProductType;

import java.math.BigDecimal;

public interface Product {
    ProductType getProductType();
    String getName();
    BigDecimal getAmount();
    String getDescription();
    Publisher getPublisher();
    Author getAuthor();
}