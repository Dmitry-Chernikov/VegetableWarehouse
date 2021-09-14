package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.services.TypeWarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class TypeWarehouseControllerREST {

    private final TypeWarehouseService typeWarehouseService;

    @GetMapping(path = "/type-warehouse")
    public List<TypeWarehouseDto> getAllTypeWarehouse() {
        return typeWarehouseService.findAllDto();
    }

    @GetMapping(path = "/type-warehouse/{id}")
    public ResponseEntity<TypeWarehouseDto> getTypeWarehouseById(@PathVariable("id") Long id) {
        Optional<TypeWarehouseDto> typeWarehouseDto = Optional.ofNullable(typeWarehouseService.findByIdDto(id));
        return typeWarehouseDto.map(warehouseDto -> new ResponseEntity<>(warehouseDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/type-warehouse", consumes = "application/json")
    public TypeWarehouseDto createTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.saveDto(typeWarehouseDto);
    }

    @PutMapping(path = "/type-warehouse/{id}")
    public TypeWarehouseDto updateTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.saveDto(typeWarehouseDto);
    }

    @PatchMapping(path = "/type-warehouse/{id}", consumes = "application/json")
    public TypeWarehouseDto updateCheckTypeWarehouse(@PathVariable("id") Long id, @RequestBody @Validated TypeWarehouseDto typeWarehouseDto) {
        TypeWarehouseDto typeWarehouseDtoRefresh = typeWarehouseService.findByIdDto(id);

        if (typeWarehouseDto.getNameWarehouse() != null) {
            typeWarehouseDtoRefresh.setNameWarehouse(typeWarehouseDto.getNameWarehouse());
        }

        return typeWarehouseService.saveDto(typeWarehouseDtoRefresh);
    }

    @DeleteMapping(path = "/type-warehouse/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTypeWarehouse(@PathVariable("id") Long id) {
        typeWarehouseService.deleteBuIdDto(id);
    }
}
