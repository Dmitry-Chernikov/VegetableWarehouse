package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.service.EmployeeServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class EmployeeControllerREST {

    private final EmployeeServiceDto employeeServiceDto;

    //Получить все записи
    @GetMapping(path = "/employee")
    public Iterable<EmployeeDto> getAllEmployee() {
        return employeeServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        Optional<EmployeeDto> employeeDto = Optional.ofNullable(employeeServiceDto.findById(id));
        return employeeDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/employee", consumes = "application/json")
    public EmployeeDto postEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeServiceDto.save(employeeDto);
    }

    //Метод обновления
    @PutMapping(path = "/employee/{id}")
    public EmployeeDto putEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeServiceDto.save(employeeDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/employee/{id}", consumes = "application/json")
    public EmployeeDto patchEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDtoRefresh = employeeServiceDto.findById(id);

        if (employeeDto.getFullName() != null) {
            employeeDtoRefresh.setFullName(employeeDto.getFullName());
        }

        if (employeeDto.getDateBirth() != null) {
            employeeDtoRefresh.setDateBirth(employeeDto.getDateBirth());
        }

        if (employeeDto.getDateBirth() != null) {
            employeeDtoRefresh.setDateBirth(employeeDto.getDateBirth());
        }

        if (employeeDto.getPosition() != null) {
            employeeDtoRefresh.setPosition(employeeDto.getPosition());
        }
        if (employeeDto.getAccommodationAddress() != null) {
            employeeDtoRefresh.setAccommodationAddress(employeeDto.getAccommodationAddress());
        }
        if (employeeDto.getTelephoneHome() != null) {
            employeeDtoRefresh.setTelephoneHome(employeeDto.getTelephoneHome());
        }
        if (employeeDto.getTelephoneMobil() != null) {
            employeeDtoRefresh.setTelephoneMobil(employeeDto.getTelephoneMobil());
        }

        return employeeServiceDto.save(employeeDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
