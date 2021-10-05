package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.services.TypeWarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Типы складов\" и используеться CRUD для базы данных.")
public class TypeWarehouseController {

    private final TypeWarehouseService typeWarehouseService;

        @ApiOperation("Метод возвращает все имеющися склады овощебазы которые храняться в таблице \"Типы складов\"")
    @GetMapping(path = "/typeWarehouse")
    public List<TypeWarehouseDto> getAllTypeWarehouse() {
        return typeWarehouseService.findAll();
    }

         @ApiOperation("Метод возвращает тип склада овощебазы по id из таблицы \"Типы складов\"")
    @GetMapping(path = "/typeWarehouse/{id}")
    public ResponseEntity<TypeWarehouseDto> getTypeWarehouseById(@PathVariable("id") Long id) {
        Optional<TypeWarehouseDto> typeWarehouseDto = Optional.ofNullable(typeWarehouseService.findById(id));
        return typeWarehouseDto.map(warehouseDto -> new ResponseEntity<>(warehouseDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добовляет тип склада в таблицу \"Типы складов\"")
    @PostMapping(path = "/typeWarehouse")
    public TypeWarehouseDto createTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.save(typeWarehouseDto);
    }

        @ApiOperation("Метод изменяет атрибуты типа склада в таблице \"Типы складов\"")
    @PutMapping(path = "/typeWarehouse/{id}")
    public TypeWarehouseDto updateTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.save(typeWarehouseDto);
    }
    
        @ApiOperation("Метод удаляет из таблицы \"Типы складов\" по id имеющийся склад")
    @DeleteMapping(path = "/typeWarehouse/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTypeWarehouse(@PathVariable("id") Long id) {
        typeWarehouseService.deleteById(id);
    }
}
