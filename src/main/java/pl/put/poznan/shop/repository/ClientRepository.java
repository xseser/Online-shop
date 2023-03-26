package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.shop.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
