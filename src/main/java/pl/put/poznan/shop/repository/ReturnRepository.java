package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.Return;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Long> {
}
