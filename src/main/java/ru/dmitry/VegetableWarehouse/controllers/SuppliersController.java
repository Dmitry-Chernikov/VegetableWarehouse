package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.services.SuppliersService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Поставщики\" и используеться CRUD для базы данных.")
public class SuppliersController {

    private final SuppliersService suppliersService;

        @ApiOperation("Метод возвращает всех поставщиков овощебазы которые храняться в таблице \"Поставщики\"")
    @GetMapping("/suppliers")
    public Iterable<SuppliersDto> getAllSuppliers() {
        return suppliersService.findAll();
    }

        @ApiOperation("Метод возвращает одного поставщика овощебазы по id")
    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable("id") Long id) {
        Optional<SuppliersDto> suppliersDto = Optional.ofNullable(suppliersService.findById(id));
        return suppliersDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

         @ApiOperation("Метод добовляет в таблице \"Поставщики\" одного поставщика")
    @PostMapping(path = "/suppliers")
    public SuppliersDto createSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.save(suppliersDto);
    }
    
        @ApiOperation("Метод изменяет атрибуты поставщика в таблице \"Поставщики\"")
    @PutMapping("/suppliers/{id}")
    public SuppliersDto updateSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.save(suppliersDto);
    }
        
        @ApiOperation("Метод удаляет поставщика из таблицы \"Поставщики\" по id")
    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers(@PathVariable("id") Long id) {
        suppliersService.deleteById(id);
    }

}
