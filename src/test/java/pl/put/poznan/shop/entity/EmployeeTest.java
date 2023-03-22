package pl.put.poznan.shop.entity;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.put.poznan.shop.repository.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void checkIfEmployeeWithIdOneExists(){
        assertEquals(employeeRepository.existsEmployeeById(1L), true);
    }

    @Test
    public void checkIfEmployeeWithIdOneHasNameAnna(){
        assertEquals(employeeRepository.findEmployeeById(1L).toString(), "Anna");
    }
}