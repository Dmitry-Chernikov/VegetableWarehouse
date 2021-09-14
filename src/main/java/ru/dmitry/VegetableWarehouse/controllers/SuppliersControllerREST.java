package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.services.SuppliersService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class SuppliersControllerREST {

    private final SuppliersService suppliersService;

    @GetMapping("/suppliers")
    public Iterable<SuppliersDto> getAllSuppliers() {
        return suppliersService.findAllDto();
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable("id") Long id) {
        Optional<SuppliersDto> suppliersDto = Optional.ofNullable(suppliersService.findByIdDto(id));
        return suppliersDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json", path = "/suppliers")
    public SuppliersDto createSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.saveDto(suppliersDto);
    }

    @PutMapping("/suppliers/{id}")
    public SuppliersDto updateSuppliers(@RequestBody SuppliersDto suppliersDto) {
        return suppliersService.saveDto(suppliersDto);
    }

    @PatchMapping(path = "/suppliers/{id}",consumes = "application/json")
    public SuppliersDto updateCheckSuppliers(@PathVariable("id") Long id, @RequestBody @Validated SuppliersDto suppliersDto){
        SuppliersDto suppliersDtoRefresh = suppliersService.findByIdDto(id);

        if(suppliersDto.getName() != null){
            suppliersDtoRefresh.setName(suppliersDto.getName());
        }

        if(suppliersDto.getCodeUNP() != null){
            suppliersDtoRefresh.setCodeUNP(suppliersDto.getCodeUNP());
        }

        if(suppliersDto.getLegalAddress() != null){
            suppliersDtoRefresh.setLegalAddress(suppliersDto.getLegalAddress());
        }

        if(suppliersDto.getTelephoneNumber() != null){
            suppliersDtoRefresh.setTelephoneNumber(suppliersDto.getTelephoneNumber());
        }

        if(suppliersDto.getFullName() != null){
            suppliersDtoRefresh.setFullName(suppliersDto.getFullName());
        }

        if(suppliersDto.getWorkingPosition() != null){
            suppliersDtoRefresh.setWorkingPosition(suppliersDto.getWorkingPosition());
        }

        return suppliersService.saveDto(suppliersDtoRefresh);
    }

    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers(@PathVariable("id") Long id) {
        suppliersService.deleteBuIdDto(id);
    }

}
