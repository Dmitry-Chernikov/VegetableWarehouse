package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.mappers.EmployeeMapper;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    //Read id
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    //Save one unit
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            employeeRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }


    //Read id
    public EmployeeDto findByIdDto(Long id){
        return mapper.toDto(employeeRepository.findById(id).orElse(null));
    }
    //Read All
    public List<EmployeeDto> findAllDto(){
        List<EmployeeDto> employeeDto = new ArrayList<>();
        for (Employee employee: employeeRepository.findAll()) {
            employeeDto.add(mapper.toDto(employee));
        }
        return employeeDto;
    }
    //Save one unit
    public EmployeeDto saveDto(EmployeeDto employeeDto){
        return mapper.toDto(employeeRepository.save(mapper.toEntity(employeeDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            employeeRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
