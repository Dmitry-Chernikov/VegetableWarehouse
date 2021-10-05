package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.services.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Сотрудники\" и используеться CRUD для базы данных.", hidden = true)
public class EmployeeController {

    private final EmployeeService employeeService;

        @ApiOperation("Метод возвращает всех служащих овощебазы")
    @GetMapping(path = "/employee")
    public Iterable<EmployeeDto> getAllEmployee() {
        return employeeService.findAll();
    }

         @ApiOperation("Метод возвращает одного служащего овощебазы по id")
    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        Optional<EmployeeDto> employeeDto = Optional.ofNullable(employeeService.findById(id));
        return employeeDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод создаёт в таблице Служащие одного рабочего")
    @PostMapping(path = "/employee")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

        @ApiOperation("Метод изменяет атрибуты рабочего в таблице Служащие")
    @PutMapping(path = "/employee/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }
    
        @ApiOperation("Метод удаляет работника из таблицы Служащие по id")
    @DeleteMapping(path = "/employee/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }
}
