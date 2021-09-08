package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.model.Employee;

@Component
public class EmployeeMapper extends AbstractMapper<Employee, EmployeeDto>{
    @Autowired
    EmployeeMapper() {
        super(Employee.class, EmployeeDto.class);
    }
}
