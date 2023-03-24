package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.shop.entity.Return;

public interface ReturnRepository extends JpaRepository<Return, Long> {
}
