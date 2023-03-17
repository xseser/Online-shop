package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
