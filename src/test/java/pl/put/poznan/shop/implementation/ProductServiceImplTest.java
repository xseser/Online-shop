package pl.put.poznan.shop.implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import pl.put.poznan.shop.entity.Product;
import pl.put.poznan.shop.repository.ProductRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void setUp(){
        Product product = new Product();
        product.setName("cookie");
        product.setCategory("sweets");
        product.setPrice(3L);
        product.setWeight(3000L);
        Product savedProduct = productService.createProduct("cookie","sweets",3L, 3L, 2L);
        System.out.println(savedProduct);
    }

}