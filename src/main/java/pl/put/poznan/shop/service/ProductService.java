package pl.put.poznan.shop.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.put.poznan.shop.entity.Product;

public interface ProductService {

    Product checkProduct(String name, String category);

    Product findProduct(Long id);

    Boolean existsProduct(Long id);;
}
