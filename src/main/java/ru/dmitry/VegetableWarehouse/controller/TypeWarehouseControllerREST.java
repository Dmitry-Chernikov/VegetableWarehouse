package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.service.TypeWarehouseServiceDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class TypeWarehouseControllerREST {

    private final TypeWarehouseServiceDto typeWarehouseServiceDto;

    //Получить все записи
    @GetMapping(path = "/type-warehouse")
    public List<TypeWarehouseDto> getAllTypeWarehouse() {
        return typeWarehouseServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/type-warehouse/{id}")
    public ResponseEntity<TypeWarehouseDto> getTypeWarehouseById(@PathVariable("id") Long id) {
        Optional<TypeWarehouseDto> typeWarehouseDto = Optional.ofNullable(typeWarehouseServiceDto.findById(id));
        return typeWarehouseDto.map(warehouseDto -> new ResponseEntity<>(warehouseDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/type-warehouse", consumes = "application/json")
    public TypeWarehouseDto postTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseServiceDto.save(typeWarehouseDto);
    }

    //Метод обновления
    @PutMapping(path = "/type-warehouse/{id}")
    public TypeWarehouseDto putTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseServiceDto.save(typeWarehouseDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/type-warehouse/{id}", consumes = "application/json")
    public TypeWarehouseDto patchTypeWarehouse(@PathVariable("id") Long id, @RequestBody TypeWarehouseDto typeWarehouseDto) {
        TypeWarehouseDto typeWarehouseDtoRefresh = typeWarehouseServiceDto.findById(id);

        if (typeWarehouseDto.getNameWarehouse() != null) {
            typeWarehouseDtoRefresh.setNameWarehouse(typeWarehouseDto.getNameWarehouse());
        }

        return typeWarehouseServiceDto.save(typeWarehouseDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/type-warehouse/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTypeWarehouse(@PathVariable("id") Long id) {
        try {
            typeWarehouseServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
