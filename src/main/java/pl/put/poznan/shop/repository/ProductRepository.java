package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByCategoryAndName(String name, String category);
}
