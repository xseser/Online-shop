package pl.put.poznan.shop.implementation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.shop.repository.ProductRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void tryToAddProductNamedCarrot() {
        String name = "carrot";
        String category = "vegetables";
        System.out.println(productService.createProduct(name, category,
                300L, LocalDate.parse("2024-03-22"), 20L, 2.87));
    }
}