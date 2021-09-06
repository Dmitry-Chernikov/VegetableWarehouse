package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.service.PurchaseService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class PurchaseControllerREST {

    private final PurchaseService purchaseService;

    //Получить все записи
    @GetMapping(path = "/purchase")
    public Iterable<Purchase> getAllPurchase() {
        return purchaseService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/purchase/{id}")
    public ResponseEntity<Purchase> getUnitsById(@PathVariable("id") Long id) {
        Optional<Purchase> purchase = Optional.ofNullable(purchaseService.findById(id));
        if (purchase.isPresent()) {
            return new ResponseEntity<>(purchase.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/purchase", consumes = "application/json")
    public Purchase postPurchase(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    //Метод обновления
    @PutMapping(path = "/purchase/{id}")
    public Purchase putPurchase(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/purchase/{id}", consumes = "application/json")
    public Purchase patchPurchase(@PathVariable("id") Long id, @RequestBody Purchase purchase) {
        Purchase purchaseRefresh = purchaseService.findById(id);

        if (purchase.getBarcode() != null) {
            purchaseRefresh.setBarcode(purchase.getBarcode());
        }

        if (purchase.getBaseProducts() != null) {
            purchaseRefresh.setBaseProducts(purchase.getBaseProducts());
        }

        //if (purchase.getCountProduct() != null) {
        //    purchaseRefresh.setCountProduct(purchase.getCountProduct());
        //}

        if (purchase.getSuppliersName() != null) {
            purchaseRefresh.setSuppliersName(purchase.getSuppliersName());
        }

        if (purchase.getSuppliers() != null) {
            purchaseRefresh.setSuppliers(purchase.getSuppliers());
        }

        if (purchase.getEmployee() != null) {
            purchaseRefresh.setEmployee(purchase.getEmployee());
        }

        if (purchase.getOperationDate() != null) {
            purchaseRefresh.setOperationDate(purchase.getOperationDate());
        }

        //if (purchase.getValuePrice() != null) {
        //    purchaseRefresh.setValuePrice(purchase.getValuePrice());
        //}
        return purchaseService.save(purchaseRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/purchase/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable("id") Long id) {
        try {
            purchaseService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
