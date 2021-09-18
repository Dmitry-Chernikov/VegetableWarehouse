package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.mappers.EmployeeMapper;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    //Read id
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //Save one unit
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }


    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public EmployeeDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<EmployeeDto> findAllDto() {
        List<EmployeeDto> employeeDto = new ArrayList<>();
        for (Employee employee : this.findAll()) {
            employeeDto.add(mapper.toDto(employee));
        }
        return employeeDto;
    }

    //Save one unit and return Dto
    public EmployeeDto saveDto(EmployeeDto goodsDto) {
        return mapper.toDto(this.save(mapper.toEntity(goodsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}