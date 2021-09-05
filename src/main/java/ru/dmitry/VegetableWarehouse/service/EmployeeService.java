package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.repo.EmployeeRepository;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //Конструктор
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}
