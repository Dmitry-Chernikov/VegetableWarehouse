package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.service.SalesServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class SalesControllerREST {

    private final SalesServiceDto salesServiceDto;

    //Получить все записи
    @GetMapping(path = "/sales")
    public Iterable<SalesDto> getAllSales() {
        return salesServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/sales/{id}")
    public ResponseEntity<SalesDto> getSalesById(@PathVariable("id") Long id) {
        Optional<SalesDto> salesDto = Optional.ofNullable(salesServiceDto.findById(id));
        return salesDto.<ResponseEntity<SalesDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/sales", consumes = "application/json")
    public SalesDto postSales(@RequestBody SalesDto salesDto) {
        return salesServiceDto.save(salesDto);
    }

    //Метод обновления
    @PutMapping(path = "/sales/{id}")
    public SalesDto putSales(@RequestBody SalesDto salesDto) {
        return salesServiceDto.save(salesDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/sales/{id}", consumes = "application/json")
    public SalesDto patchSales(@PathVariable("id") Long id, @RequestBody SalesDto salesDto) {
        SalesDto salesDtoRefresh = salesServiceDto.findById(id);

        if (salesDto.getBarcode() != null) {
            salesDtoRefresh.setBarcode(salesDto.getBarcode());
        }

//        if (salesDto.getBaseProducts() != null) {
//            salesDtoRefresh.setBaseProducts(salesDto.getBaseProducts());
//        }

        //if (salesDto.getCountProduct() != 0.0) {
        //    salesDtoRefresh.setCountProduct(salesDto.getCountProduct());
        //}

        if (salesDto.getClientName() != null) {
            salesDtoRefresh.setClientName(salesDto.getClientName());
        }

//        if (salesDto.getClients() != null) {
//            salesDtoRefresh.setClients(salesDto.getClients());
//        }

//        if (salesDto.getEmployee() != null) {
//            salesDtoRefresh.setEmployee(salesDto.getEmployee());
//        }

        if (salesDto.getOperationDate() != null) {
            salesDtoRefresh.setOperationDate(salesDto.getOperationDate());
        }

        //if (salesDto.getValuePrice() != null) {
        //    salesDtoRefresh.setValuePrice(salesDto.getValuePrice());
        //}
        return salesServiceDto.save(salesDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/sales/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSales(@PathVariable("id") Long id) {
        try {
            salesServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
