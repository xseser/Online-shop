package pl.put.poznan.shop.service;

import pl.put.poznan.shop.entity.Product;

public interface ProductService {

    Product checkProduct(String name, String category);
}
