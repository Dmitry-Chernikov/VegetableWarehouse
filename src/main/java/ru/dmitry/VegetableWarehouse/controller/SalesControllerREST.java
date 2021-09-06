package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.service.SalesService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class SalesControllerREST {

    private final SalesService salesService;

    //Получить все записи
    @GetMapping(path = "/sales")
    public Iterable<Sales> getAllSales() {
        return salesService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/sales/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable("id") Long id) {
        Optional<Sales> sales = Optional.ofNullable(salesService.findById(id));
        if (sales.isPresent()) {
            return new ResponseEntity<>(sales.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/sales", consumes = "application/json")
    public Sales postSales(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    //Метод обновления
    @PutMapping(path = "/sales/{id}")
    public Sales putSales(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/sales/{id}", consumes = "application/json")
    public Sales patchSales(@PathVariable("id") Long id, @RequestBody Sales sales) {
        Sales salesRefresh = salesService.findById(id);

        if (sales.getBarcode() != null) {
            salesRefresh.setBarcode(sales.getBarcode());
        }

        if (sales.getBaseProducts() != null) {
            salesRefresh.setBaseProducts(sales.getBaseProducts());
        }

        //if (sales.getCountProduct() != 0.0) {
        //    salesRefresh.setCountProduct(sales.getCountProduct());
        //}

        if (sales.getClientName() != null) {
            salesRefresh.setClientName(sales.getClientName());
        }

        if (sales.getClients() != null) {
            salesRefresh.setClients(sales.getClients());
        }

        if (sales.getEmployee() != null) {
            salesRefresh.setEmployee(sales.getEmployee());
        }

        if (sales.getOperationDate() != null) {
            salesRefresh.setOperationDate(sales.getOperationDate());
        }

        //if (sales.getValuePrice() != null) {
        //    salesRefresh.setValuePrice(sales.getValuePrice());
        //}
        return salesService.save(salesRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/sales/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSales(@PathVariable("id") Long id) {
        try {
            salesService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
