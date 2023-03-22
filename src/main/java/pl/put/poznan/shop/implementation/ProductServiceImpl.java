package pl.put.poznan.shop.implementation;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.put.poznan.shop.entity.Product;
import pl.put.poznan.shop.repository.ProductRepository;
import pl.put.poznan.shop.service.ProductService;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String name, String category, Long weight, LocalDate expirationDate,
                                 Long productCount, Double price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setWeight(weight);
        product.setExpirationDate(expirationDate);
        product.setProductCount(productCount);
        product.setPrice(price);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.deleteById(product.getId());
    }

    @Override
    public Product createProductWithConstructor(Product product) {
        return productRepository.save(product);
    }
}
