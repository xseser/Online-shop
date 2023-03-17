package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.shop.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
