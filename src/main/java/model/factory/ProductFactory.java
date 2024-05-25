package model.factory;

import model.*;
import model.enums.ProductType;

import java.math.BigDecimal;

public class ProductFactory {

    public static Product getProduct(ProductType productType, String name, BigDecimal amount, String description, Publisher publisher, Author author){
        Product product;
        if (productType.equals(ProductType.BOOK)){
            product = new Book(productType, name, amount, description, publisher, author);
        }
        else if (productType.equals(ProductType.JOURNAL)){
            product = new Journal(productType, name, amount, description, publisher, author);
        }
        else {
            throw new RuntimeException("Geçerli bir ürün tipi değildir!");
        }

        return product;
    }
}
