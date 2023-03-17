package pl.put.poznan.shop.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.put.poznan.shop.entity.Product;
import pl.put.poznan.shop.repository.ProductRepository;
import pl.put.poznan.shop.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product checkProduct(String name, String category) {
        return productRepository.findProductByCategoryAndName(name, category);
    }

    @Override
    public Product findProduct(Long id){
        return productRepository.findProductById(id);
    }
}
