package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class EmployeeControllerREST {

    private final EmployeeService employeeService;

    //Получить все записи
    @GetMapping(path = "/employee")
    public Iterable<Employee> getAllEmployee() {
        return employeeService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/employee", consumes = "application/json")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    //Метод обновления
    @PutMapping(path = "/employee/{id}")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/employee/{id}", consumes = "application/json")
    public Employee patchEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee employeeRefresh = employeeService.findById(id);

        if (employee.getFullName() != null) {
            employeeRefresh.setFullName(employee.getFullName());
        }

        if (employee.getDateBirth() != null) {
            employeeRefresh.setDateBirth(employee.getDateBirth());
        }

        if (employee.getDateBirth() != null) {
            employeeRefresh.setDateBirth(employee.getDateBirth());
        }

        if (employee.getPosition() != null) {
            employeeRefresh.setPosition(employee.getPosition());
        }
        if (employee.getAccommodationAddress() != null) {
            employeeRefresh.setAccommodationAddress(employee.getAccommodationAddress());
        }
        if (employee.getTelephoneHome() != null) {
            employeeRefresh.setTelephoneHome(employee.getTelephoneHome());
        }
        if (employee.getTelephoneMobil() != null) {
            employeeRefresh.setTelephoneMobil(employee.getTelephoneMobil());
        }

        return employeeService.save(employeeRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
