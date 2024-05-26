package factory.model;

import model.*;
import model.enums.ProductType;

import java.math.BigDecimal;

public class ProductFactory {

    public static Product getProduct(ProductType productType, String name, BigDecimal amount, String description, Publisher publisher, Author author, Category category, Integer stock){
        Product product;
        if (productType.equals(ProductType.BOOK)){
            product = new Book(productType, name, amount, description, publisher, author, category, stock);
        }
        else if (productType.equals(ProductType.JOURNAL)){
            product = new Journal(productType, name, amount, description, publisher, author, category, stock);
        }
        else {
            throw new RuntimeException("Geçerli bir ürün tipi değildir!");
        }

        return product;
    }
}
