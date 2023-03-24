package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.ComplaintType;
@Repository
public interface ComplaintTypeRepository extends JpaRepository<ComplaintType, Long> {

    ComplaintType findComplaintTypeByStatusName(String status);
}
