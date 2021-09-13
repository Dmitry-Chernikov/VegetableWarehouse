package ru.dmitry.VegetableWarehouse.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeeControllerREST {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeControllerREST(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Получить все записи
    @GetMapping(path = "/employee")
    public Iterable<EmployeeDto> getAllEmployee() {
        return employeeService.findAllDto();
    }

    //Получить записи по id
    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        Optional<EmployeeDto> employeeDto = Optional.ofNullable(employeeService.findByIdDto(id));
        return employeeDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/employee", consumes = "application/json")
    public EmployeeDto postEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveDto(employeeDto);
    }

    //Метод обновления
    @PutMapping(path = "/employee/{id}")
    public EmployeeDto putEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveDto(employeeDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/employee/{id}", consumes = "application/json")
    public EmployeeDto patchEmployee(@PathVariable("id") Long id, @RequestBody @Validated EmployeeDto employeeDto) {
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
    }*/

    //Метод удаления
    @DeleteMapping(path = "/employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
