package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.shop.entity.ReturnType;

public interface ReturnTypeRepository extends JpaRepository<ReturnType, Long> {
}
