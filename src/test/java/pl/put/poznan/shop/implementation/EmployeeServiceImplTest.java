package pl.put.poznan.shop.implementation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void checkIfTheresAtLeastOneEmployee() {
        assertFalse((employeeService.findEmployeesByEmploymentDate(LocalDate.now()).isEmpty()));
    }
}