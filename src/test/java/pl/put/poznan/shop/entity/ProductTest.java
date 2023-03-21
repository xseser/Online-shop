package pl.put.poznan.shop.entity;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.put.poznan.shop.repository.ProductRepository;
import pl.put.poznan.shop.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void checkIfProductWithIdOneExists(){
        assertEquals(productRepository.existsProductById(1L), true);
    }

    @Test
    public void checkIfProductWithIdTwoExists(){
        assertEquals(productRepository.existsProductById(2L), true);
    }




}