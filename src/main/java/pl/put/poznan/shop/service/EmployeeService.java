package pl.put.poznan.shop.service;

import pl.put.poznan.shop.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeesByEmploymentDate(LocalDate wantedDate);
}
