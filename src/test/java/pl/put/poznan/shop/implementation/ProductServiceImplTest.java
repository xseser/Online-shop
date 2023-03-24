package pl.put.poznan.shop.implementation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.put.poznan.shop.entity.Product;
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

    @Disabled
    @Test
    public void tryToAddProductNamed__Test__AndDeleteHim() {
        String name = "test";
        String category = "test";

        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setWeight(300L);
        product.setExpirationDate(LocalDate.parse("2095-03-22"));
        product.setProductCount(20L);
        product.setPrice(2.86);
        productService.createProductWithConstructor(product);
        productService.deleteProduct(product);
    }
}