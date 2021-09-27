package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.services.SuppliersService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class SuppliersController {

    private final SuppliersService suppliersService;

    @GetMapping("/suppliers")
    public Iterable<SuppliersDto> getAllSuppliers() {
        return suppliersService.findAll();
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable("id") Long id) {
        Optional<SuppliersDto> suppliersDto = Optional.ofNullable(suppliersService.findById(id));
        return suppliersDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json", path = "/suppliers")
    public SuppliersDto createSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.save(suppliersDto);
    }

    @PutMapping("/suppliers/{id}")
    public SuppliersDto updateSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.save(suppliersDto);
    }

    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers(@PathVariable("id") Long id) {
        suppliersService.deleteById(id);
    }

}
