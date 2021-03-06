package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.services.SalesService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Приходные накладные\" и используеться CRUD для базы данных.")
public class SalesController {

    private final SalesService salesService;

        @ApiOperation("Метод возвращает все накладные из таблицы \"Приходные накладные\"")
    @GetMapping(path = "/sales")
    public Iterable<SalesDto> getAllSales() {
        return salesService.findAll();
    }

        @ApiOperation("Метод возвращает одну накладную из таблицы \"Приходные накладные\"овощебазы по id")
    @GetMapping(path = "/sales/{id}")
    public ResponseEntity<SalesDto> getSalesById(@PathVariable("id") Long id) {
        Optional<SalesDto> salesDto = Optional.ofNullable(salesService.findById(id));
        return salesDto.<ResponseEntity<SalesDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добовляет в таблице \"Приходные накладные\" одну накладную")
    @PostMapping(path = "/sales")
    public SalesDto createSales(@RequestBody SalesDto salesDto) {
        return salesService.save(salesDto);
    }
        
        @ApiOperation("Метод изменяет атрибуты накладной из таблицы \"Приходные накладные\"")
    @PutMapping(path = "/sales/{id}")
    public SalesDto updateSales(@RequestBody SalesDto salesDto) {
        return salesService.save(salesDto);
    }

        @ApiOperation("Метод удаляет накладную из таблицы \"Приходные накладные\" по id")
    @DeleteMapping(path = "/sales/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSales(@PathVariable("id") Long id) {
        try {
            salesService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
