package pl.put.poznan.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.shop.entity.Employee;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsEmployeeById(Long id);

    Employee findEmployeeById(Long id);

    Employee findEmployeeByBirthDate(LocalDate dateOfEmployment);
}
