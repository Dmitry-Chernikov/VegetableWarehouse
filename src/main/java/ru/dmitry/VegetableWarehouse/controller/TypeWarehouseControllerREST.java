package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.service.TypeWarehouseService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class TypeWarehouseControllerREST {

    private final TypeWarehouseService typeWarehouseService;

    //Получить все записи
    @GetMapping(path = "/type-warehouse")
    public Iterable<TypeWarehouse> getAllTypeWarehouse() {
        return typeWarehouseService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/type-warehouse/{id}")
    public ResponseEntity<TypeWarehouse> getTypeWarehouseById(@PathVariable("id") Long id) {
        Optional<TypeWarehouse> typeWarehouse = Optional.ofNullable(typeWarehouseService.findById(id));
        if (typeWarehouse.isPresent()) {
            return new ResponseEntity<>(typeWarehouse.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/type-warehouse", consumes = "application/json")
    public TypeWarehouse postTypeWarehouse(@RequestBody TypeWarehouse typeWarehouse) {
        return typeWarehouseService.save(typeWarehouse);
    }

    //Метод обновления
    @PutMapping(path = "/type-warehouse/{id}")
    public TypeWarehouse putTypeWarehouse(@RequestBody TypeWarehouse typeWarehouse) {
        return typeWarehouseService.save(typeWarehouse);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/type-warehouse/{id}", consumes = "application/json")
    public TypeWarehouse patchTypeWarehouse(@PathVariable("id") Long id, @RequestBody TypeWarehouse typeWarehouse) {
        TypeWarehouse typeWarehouseRefresh = typeWarehouseService.findById(id);

        if (typeWarehouse.getNameWarehouse() != null) {
            typeWarehouseRefresh.setNameWarehouse(typeWarehouse.getNameWarehouse());
        }

        return typeWarehouseService.save(typeWarehouseRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/type-warehouse/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTypeWarehouse(@PathVariable("id") Long id) {
        try {
            typeWarehouseService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
