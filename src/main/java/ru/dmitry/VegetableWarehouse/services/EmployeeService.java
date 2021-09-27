package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.mappers.EmployeeMapper;
import ru.dmitry.VegetableWarehouse.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    //Read id to Dto
    public EmployeeDto findById(Long id) {
        return mapper.toDto(employeeRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public EmployeeDto save(EmployeeDto goodsDto) {
        return mapper.toDto(employeeRepository.save(mapper.toEntity(goodsDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
