package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.services.SalesService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class SalesControllerREST {

    private final SalesService salesService;

    @GetMapping(path = "/sales")
    public Iterable<SalesDto> getAllSales() {
        return salesService.findAllDto();
    }

    @GetMapping(path = "/sales/{id}")
    public ResponseEntity<SalesDto> getSalesById(@PathVariable("id") Long id) {
        Optional<SalesDto> salesDto = Optional.ofNullable(salesService.findByIdDto(id));
        return salesDto.<ResponseEntity<SalesDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/sales", consumes = "application/json")
    public SalesDto createSales(@RequestBody SalesDto salesDto) {
        return salesService.saveDto(salesDto);
    }

    @PutMapping(path = "/sales/{id}")
    public SalesDto updateSales(@RequestBody SalesDto salesDto) {
        return salesService.saveDto(salesDto);
    }

    @PatchMapping(path = "/sales/{id}", consumes = "application/json")
    public SalesDto updateCheckSales(@PathVariable("id") Long id, @RequestBody @Validated SalesDto salesDto) {
        SalesDto salesDtoRefresh = salesService.findByIdDto(id);

        if (salesDto.getBarcode() != null) {
            salesDtoRefresh.setBarcode(salesDto.getBarcode());
        }

        if (salesDto.getNameTypeVegetable() != null) {
            salesDtoRefresh.setNameTypeVegetable(salesDto.getNameTypeVegetable());
        }

        if (salesDto.getCountProduct() != 0.0) {
            salesDtoRefresh.setCountProduct(salesDto.getCountProduct());
        }

        if (salesDto.getClientName() != null) {
            salesDtoRefresh.setClientName(salesDto.getClientName());
        }

        if (salesDto.getNameClient() != null) {
            salesDtoRefresh.setNameClient(salesDto.getNameClient());
        }

        if (salesDto.getFullName() != null) {
            salesDtoRefresh.setFullName(salesDto.getFullName());
        }

        if (salesDto.getOperationDate() != null) {
            salesDtoRefresh.setOperationDate(salesDto.getOperationDate());
        }

        if (salesDto.getValuePrice() != 0.0) {
            salesDtoRefresh.setValuePrice(salesDto.getValuePrice());
        }
        return salesService.saveDto(salesDtoRefresh);
    }

    @DeleteMapping(path = "/sales/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSales(@PathVariable("id") Long id) {
        try {
            salesService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
