package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.model.Employee;

@Mapper (componentModel = "spring")
public interface EmployeeMapper{
    EmployeeDto toDto(Employee  employee);
    Employee  toEntity(EmployeeDto employeeDto);
}
