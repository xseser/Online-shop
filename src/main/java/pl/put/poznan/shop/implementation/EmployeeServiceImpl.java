package pl.put.poznan.shop.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.put.poznan.shop.entity.Employee;
import pl.put.poznan.shop.repository.EmployeeRepository;
import pl.put.poznan.shop.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;
    List<Employee> findEmployeesByEmploymentDate(LocalDate wantedDate){
        return employeeRepository.findAllByDateOfEmploymentBefore(wantedDate);
    }
}
