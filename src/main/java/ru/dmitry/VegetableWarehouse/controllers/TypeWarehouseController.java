package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.services.TypeWarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class TypeWarehouseController {

    private final TypeWarehouseService typeWarehouseService;

    @GetMapping(path = "/typeWarehouse")
    public List<TypeWarehouseDto> getAllTypeWarehouse() {
        return typeWarehouseService.findAll();
    }

    @GetMapping(path = "/typeWarehouse/{id}")
    public ResponseEntity<TypeWarehouseDto> getTypeWarehouseById(@PathVariable("id") Long id) {
        Optional<TypeWarehouseDto> typeWarehouseDto = Optional.ofNullable(typeWarehouseService.findById(id));
        return typeWarehouseDto.map(warehouseDto -> new ResponseEntity<>(warehouseDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/typeWarehouse", consumes = "application/json")
    public TypeWarehouseDto createTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.save(typeWarehouseDto);
    }

    @PutMapping(path = "/typeWarehouse/{id}")
    public TypeWarehouseDto updateTypeWarehouse(@RequestBody TypeWarehouseDto typeWarehouseDto) {
        return typeWarehouseService.save(typeWarehouseDto);
    }

    @DeleteMapping(path = "/typeWarehouse/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTypeWarehouse(@PathVariable("id") Long id) {
        typeWarehouseService.deleteById(id);
    }
}
