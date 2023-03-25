package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.ReturnType;

@Repository
public interface ReturnTypeRepository extends JpaRepository<ReturnType, Long> {
}
