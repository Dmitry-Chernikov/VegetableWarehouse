package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.model.Employee;

@Mapper (componentModel = "spring")
public interface EmployeeMapper{
    EmployeeDto toDto(Employee  employee);
    Employee  toEntity(EmployeeDto employeeDto);
}
