package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.shop.entity.ClientType;

public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
