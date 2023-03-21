package pl.put.poznan.shop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pl.put.poznan.shop.entity.Product;

import java.util.List;

public interface ProductService {

    Product checkProduct(String name, String category);

    Product findProduct(Long id);

    Boolean existsProduct(Long id);

    List<Product> getAllProducts();
}
