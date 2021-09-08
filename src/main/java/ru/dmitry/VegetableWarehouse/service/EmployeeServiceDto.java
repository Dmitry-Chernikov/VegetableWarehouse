package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.EmployeeMapper;
import ru.dmitry.VegetableWarehouse.converter.UnitsMapper;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repo.EmployeeRepository;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceDto {
    private final EmployeeRepository unitsRepository;
    private final EmployeeMapper mapper;
    //Read id
    public EmployeeDto findById(Long id){
        return mapper.toDto(unitsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<EmployeeDto> findAll(){
        List<EmployeeDto> employeeDto = new ArrayList<>();
        for (Employee employee: unitsRepository.findAll()) {
            employeeDto.add(mapper.toDto(employee));
        }
        return employeeDto;
    }
    //Save one unit
    public EmployeeDto save(EmployeeDto employeeDto){
        return mapper.toDto(unitsRepository.save(mapper.toEntity(employeeDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            unitsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
