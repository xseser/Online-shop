package pl.put.poznan.shop.service;

import pl.put.poznan.shop.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product createProduct(String name, String category, Long weight, LocalDate expirationDate,
                          Long productCount, Double price);

    void deleteProduct(Product product);

    void createProductWithConstructor(Product product);
}
