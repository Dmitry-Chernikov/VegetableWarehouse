package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.services.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class EmployeeControllerREST {

    private final EmployeeService employeeService;

    @GetMapping(path = "/employee")
    public Iterable<EmployeeDto> getAllEmployee() {
        return employeeService.findAllDto();
    }

    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        Optional<EmployeeDto> employeeDto = Optional.ofNullable(employeeService.findByIdDto(id));
        return employeeDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/employee", consumes = "application/json")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveDto(employeeDto);
    }

    @PutMapping(path = "/employee/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveDto(employeeDto);
    }

    @PatchMapping(path = "/employee/{id}", consumes = "application/json")
    public EmployeeDto updateCheckEmployee(@PathVariable("id") Long id, @RequestBody @Validated EmployeeDto employeeDto) {
        EmployeeDto employeeDtoRefresh = employeeService.findByIdDto(id);

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

        return employeeService.saveDto(employeeDtoRefresh);
    }

    @DeleteMapping(path = "/employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteBuIdDto(id);
    }
}
